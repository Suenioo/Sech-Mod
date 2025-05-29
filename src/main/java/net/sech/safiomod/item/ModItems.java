package net.sech.safiomod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.item.custom.AutoTotem;
import net.sech.safiomod.item.custom.EteTotem;
import net.sech.safiomod.item.custom.ButtPlug;
import net.sech.safiomod.item.custom.TotemKisser;
import net.sech.safiomod.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SafioMod.MOD_ID);

    public static final RegistryObject<Item> TOTEMKISSER = ITEMS.register("totemkisser",
            () -> new TotemKisser(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> ETETOTEM = ITEMS.register("etetotem",
            () -> new EteTotem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> AUTOTOTEM = ITEMS.register("autototem",
            () -> new AutoTotem(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));


    public static final RegistryObject<Item> ALBERT = ITEMS.register("albert",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TOTEM_VESSEL = ITEMS.register("totem_vessel",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RED_SABER_UPGRADE = ITEMS.register("red_saber_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> HOLODET = ITEMS.register("holodet",
            () -> new Item(new Item.Properties().food(ModFoods.HOLODET)));

    public static final RegistryObject<Item> BUTT_PLUG = ITEMS.register("butt_plug",
            () -> new ButtPlug(ModArmorMaterials.AMETHYST_SHARD, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> RED_SABER = ITEMS.register("red_saber",
            () -> new SwordItem(ModToolTiers.SAFIO, 4, 2, new Item.Properties().rarity(Rarity.RARE)));


    public static final RegistryObject<Item> BALATRO_DISC = ITEMS.register("balatro_disc",
            () -> new RecordItem(6, ModSounds.BALATRO_THEME, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 72000));
    public static final RegistryObject<Item> TITIRITI_DISC = ITEMS.register("titiriti_disc",
            () -> new RecordItem(6, ModSounds.TITIRITI_FOREVER, new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON), 4800));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
