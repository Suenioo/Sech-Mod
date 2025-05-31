package net.sech.safiomod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.entity.custom.BoykisserEntity;

public class BoykisserRenderer extends MobRenderer<BoykisserEntity, BoykisserModel<BoykisserEntity>> {
    public BoykisserRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BoykisserModel<>(pContext.bakeLayer(ModModelLayers.BOYKISSER_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BoykisserEntity pEntity) {
        return new ResourceLocation(SafioMod.MOD_ID, "textures/entity/boykisser.png");
    }

    @Override
    public void render(BoykisserEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
