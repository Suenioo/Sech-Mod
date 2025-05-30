package net.sech.safiomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SafioMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.TOTEMKISSER);
        simpleItem(ModItems.ETETOTEM);
        simpleItem(ModItems.AUTOTOTEM);
        simpleItem(ModItems.ALBERT);
        simpleItem(ModItems.TOTEM_VESSEL);
        simpleItem(ModItems.RED_SABER_UPGRADE);
        simpleItem(ModItems.BALATRO_DISC);
        simpleItem(ModItems.HOLODET);
        simpleItem(ModItems.BUTT_PLUG);
        simpleItem(ModItems.TITIRITI_DISC);

        withExistingParent(ModItems.BOYKISSER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.CHECHU_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SafioMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SafioMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
