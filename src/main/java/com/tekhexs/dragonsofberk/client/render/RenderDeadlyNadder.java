package com.tekhexs.dragonsofberk.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.tekhexs.dragonsofberk.client.models.DeadlyNadderModel;
import com.tekhexs.dragonsofberk.entity.EntityDeadlyNadder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RenderDeadlyNadder extends GeoEntityRenderer<EntityDeadlyNadder> {
    public RenderDeadlyNadder(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeadlyNadderModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public RenderType getRenderType(EntityDeadlyNadder animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.3F, 0.3F, 0.3F);
        } else {
            //stack.scale(1.2F, 1.2F, 1.2F);
        }
        return RenderType.entityCutoutNoCull(getTextureLocation(animatable));
    }
}