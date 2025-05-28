package net.sech.safiomod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.entity.ModEntities;
import net.sech.safiomod.entity.custom.ChechuEntity;

@Mod.EventBusSubscriber(modid = SafioMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CHECHU.get(), ChechuEntity.createAttributes().build());
    }
}
