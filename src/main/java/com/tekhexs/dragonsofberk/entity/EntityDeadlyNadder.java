package com.tekhexs.dragonsofberk.entity;

import com.tekhexs.dragonsofberk.entity.base.AbstractDragonBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;

import static net.minecraft.world.entity.ai.attributes.Attributes.*;

public class EntityDeadlyNadder extends AbstractDragonBase {

    private static final EntityDataAccessor<Integer> DRAGON_VARIANT = SynchedEntityData.defineId(EntityDeadlyNadder.class, EntityDataSerializers.INT);

    // base attributes
    public static final double BASE_SPEED_GROUND = 0.25D;
    public static final double BASE_SPEED_FLYING = 0.100F;
    public static final double BASE_DAMAGE = 5;
    public static final double BASE_HEALTH = 50;
    public static final double BASE_FOLLOW_RANGE = 16;
    public static final double BASE_FOLLOW_RANGE_FLYING = BASE_FOLLOW_RANGE * 2;
    public static final int BASE_KB_RESISTANCE = 1;

    public EntityDeadlyNadder(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
    }

    // animations
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(this.isFlying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deadly_nadder.fly", true));
            return PlayState.CONTINUE;
        }
        if(event.isMoving() && this.onGround) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deadly_nadder.walk", true));
            return PlayState.CONTINUE;
        }
        if(this.isInSittingPose() && this.onGround) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deadly_nadder.idle", true));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.deadly_nadder.idle", true));
        return PlayState.CONTINUE;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(MOVEMENT_SPEED, BASE_SPEED_GROUND)
                .add(MAX_HEALTH, BASE_HEALTH)
                .add(ATTACK_DAMAGE, BASE_FOLLOW_RANGE)
                .add(KNOCKBACK_RESISTANCE, BASE_KB_RESISTANCE)
                .add(ATTACK_DAMAGE, BASE_DAMAGE)
                .add(FLYING_SPEED, BASE_SPEED_FLYING);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DRAGON_VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getDragonVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(DRAGON_VARIANT, compound.getInt("Variant"));
    }

    // Variant
    public int getDragonVariant() {
        return this.entityData.get(DRAGON_VARIANT);
    }

    public void setDragonVariant(int pType) {
        this.entityData.set(DRAGON_VARIANT, pType);
    }

    // Variant pt2
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @javax.annotation.Nullable SpawnGroupData pSpawnData, @javax.annotation.Nullable CompoundTag pDataTag) {
        pSpawnData = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        this.setDragonVariant(this.random.nextInt(4));
        return pSpawnData;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }
}
