package net.sech.safiomod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SafioMod.MOD_ID);

    public static final RegistryObject<SoundEvent> ACTIVATE_TOTEM_KISSER = registerSoundEvents("activate_totem_kisser");
    public static final RegistryObject<SoundEvent> ACTIVATE_ETE_TOTEM = registerSoundEvents("activate_ete_totem");
    public static final RegistryObject<SoundEvent> EQUIP_BUTT_PLUG = registerSoundEvents("equip_butt_plug");

    public static final RegistryObject<SoundEvent> BALATRO_THEME = registerSoundEvents("balatro_theme");
    public static final RegistryObject<SoundEvent> TITIRITI_FOREVER = registerSoundEvents("titiriti_forever");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(SafioMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
