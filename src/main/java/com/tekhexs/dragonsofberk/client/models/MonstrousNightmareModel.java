package com.tekhexs.dragonsofberk.client.models;

import com.tekhexs.dragonsofberk.DragonsOfBerk;
import com.tekhexs.dragonsofberk.entity.EntityMonstrousNightmare;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MonstrousNightmareModel extends AnimatedGeoModel<EntityMonstrousNightmare> {

   /* @Override
    public ResourceLocation getModelResource(EntityMonstrousNightmare object) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "geo/nightmare.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityMonstrousNightmare object) {
        //return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/red_monstrous_nightmare_texture.png");
        switch (object.getDragonVariant()) {
            default:
            case 0:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/red_monstrous_nightmare_texture.png");
            case 1:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/blue_monstrous_nightmare_texture.png");
            case 2:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/brown_monstrous_nightmare_texture.png");
            case 3:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/green_monstrous_nightmare_texture.png");
            case 4:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/grey_monstrous_nightmare_texture.png");
            case 5:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/purple_monstrous_nightmare_texture.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(EntityMonstrousNightmare animatable) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "animations/nightmare.animation.json");
    }*/

    @Override
    public ResourceLocation getModelLocation(EntityMonstrousNightmare object) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "geo/nightmare.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMonstrousNightmare object) {
        //return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/red_monstrous_nightmare_texture.png");
        switch (object.getDragonVariant()) {
            default:
            case 0:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/red_monstrous_nightmare_texture.png");
            case 1:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/blue_monstrous_nightmare_texture.png");
            case 2:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/brown_monstrous_nightmare_texture.png");
            case 3:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/green_monstrous_nightmare_texture.png");
            case 4:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/grey_monstrous_nightmare_texture.png");
            case 5:
                return new ResourceLocation(DragonsOfBerk.MOD_ID, "textures/dragons/nightmare/purple_monstrous_nightmare_texture.png");
        }
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityMonstrousNightmare animatable) {
        return new ResourceLocation(DragonsOfBerk.MOD_ID, "animations/nightmare.animation.json");
    }
}