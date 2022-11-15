package com.tekhexs.dragonsofberk.init;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import com.tekhexs.dragonsofberk.entity.EntityDeadlyNadder;
import com.tekhexs.dragonsofberk.entity.EntityMonstrousNightmare;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, DragonsOfBerk.MOD_ID);

    public static final RegistryObject<EntityType<EntityMonstrousNightmare>> MONSTROUS_NIGHTMARE =
            ENTITIES.register("nightmare", () -> EntityType.Builder.of(EntityMonstrousNightmare::new, MobCategory.CREATURE)
                    .sized(3.5F, 4.4F)
                    .clientTrackingRange(50)
                    .setShouldReceiveVelocityUpdates(false)
                    .fireImmune()
                    .build(new ResourceLocation(DragonsOfBerk.MOD_ID, "nightmare").toString()));

    public static final RegistryObject<EntityType<EntityDeadlyNadder>> DEADLY_NADDER =
            ENTITIES.register("nadder", () -> EntityType.Builder.of(EntityDeadlyNadder::new, MobCategory.CREATURE)
                    .sized(3.5F, 4.69F)
                    .clientTrackingRange(50)
                    .setShouldReceiveVelocityUpdates(false)
                    .fireImmune()
                    .build(new ResourceLocation(DragonsOfBerk.MOD_ID, "nadder").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
