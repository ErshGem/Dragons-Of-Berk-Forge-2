package com.tekhexs.dragonsofberk.client.models;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import com.tekhexs.dragonsofberk.entity.EntityDeadlyNadder;
import com.tekhexs.dragonsofberk.entity.EntityZippleback;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZipplebackModel extends AnimatedGeoModel<EntityZippleback> {

    @Override
    public ResourceLocation getModelLocation(EntityZippleback object) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "geo/zippleback.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityZippleback object) {
        switch (object.getDragonVariant()) {
            default:
            case 0:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/zippleback/green_hideous_zippleback.png");
            case 1:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/zippleback/blue_hideous_zippleback.png");
            case 2:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/zippleback/grey_hideous_zippleback.png");
            case 3:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/zippleback/orange_hideous_zippleback.png");
            case 4:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/zippleback/purple_hideous_zippleback.png");
        }
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityZippleback animatable) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "animations/zippleback.animation.json");
    }
}