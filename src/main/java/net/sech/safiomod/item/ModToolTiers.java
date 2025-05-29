package net.sech.safiomod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAFIO = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2400, 9.0f, 4f, 17,
                    ModTags.Blocks.NEEDS_SAFIO_TOOL, () -> Ingredient.of(ModItems.RED_SABER_UPGRADE.get())),
            new ResourceLocation(SafioMod.MOD_ID, "safio"), List.of(Tiers.NETHERITE), List.of());

}
