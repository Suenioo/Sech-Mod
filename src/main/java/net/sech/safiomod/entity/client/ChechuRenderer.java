package net.sech.safiomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.entity.custom.ChechuEntity;

public class ChechuRenderer extends MobRenderer<ChechuEntity, ChechuModel<ChechuEntity>> {
    public ChechuRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ChechuModel<>(pContext.bakeLayer(ModModelLayers.CHECHU_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(ChechuEntity pEntity) {
        return new ResourceLocation(SafioMod.MOD_ID, "textures/entity/chechu.png");
    }

    @Override
    public void render(ChechuEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
