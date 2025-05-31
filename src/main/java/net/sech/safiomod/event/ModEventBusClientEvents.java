package net.sech.safiomod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.entity.client.BoykisserModel;
import net.sech.safiomod.entity.client.ChechuModel;
import net.sech.safiomod.entity.client.ModModelLayers;

@Mod.EventBusSubscriber(modid = SafioMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void  registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CHECHU_LAYER, ChechuModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.BOYKISSER_LAYER, BoykisserModel::createBodyLayer);
    }

}
