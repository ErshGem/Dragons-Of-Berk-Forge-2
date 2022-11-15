package com.tekhexs.dragonsofberk.client.models;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import com.tekhexs.dragonsofberk.entity.EntityDeadlyNadder;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeadlyNadderModel extends AnimatedGeoModel<EntityDeadlyNadder> {

    @Override
    public ResourceLocation getModelLocation(EntityDeadlyNadder object) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "geo/nadder.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDeadlyNadder object) {
        switch (object.getDragonVariant()) {
            default:
            case 0:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nadder/deadly_nadder.png");
            case 1:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nadder/blue_deadly_nadder.png");
            case 2:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nadder/brown_deadly_nadder.png");
            case 3:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nadder/green_deadly_nadder.png");
            case 4:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nadder/grey_deadly_nadder.png");
            case 5:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nadder/purple_deadly_nadder.png");
        }
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityDeadlyNadder animatable) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "animations/nadder.animation.json");
    }
}