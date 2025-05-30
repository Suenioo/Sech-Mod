package net.sech.safiomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sech.safiomod.SafioMod;
import net.sech.safiomod.block.ModBlocks;
import net.sech.safiomod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ALBERT_SMELTABLES = List.of(ModItems.ALBERT.get(),
            ModBlocks.ALBERT_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, ALBERT_SMELTABLES, RecipeCategory.MISC, ModItems.ALBERT.get(), 2.0F, 1000, "albert");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.ALBERT_ORE.get(), 1)
                .requires(Blocks.LAPIS_ORE, 2)
                .requires(Blocks.EMERALD_ORE, 2)
                .unlockedBy("has_lapis", has(Blocks.LAPIS_ORE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOTEM_VESSEL.get(), 1)
                .pattern(" i ")
                .pattern("IiI")
                .pattern(" i ")
                .define('i', Items.GOLD_INGOT)
                .define('I', Items.GOLD_BLOCK)
                .unlockedBy("has_gold", has(Items.GOLD_BLOCK))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RED_SABER_UPGRADE.get(), 1)
                .pattern("DBD")
                .pattern("BNB")
                .pattern("DBD")
                .define('D', Items.DIAMOND)
                .define('B', Items.BLAZE_POWDER)
                .define('N', Items.NETHER_STAR)
                .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
                .save(pWriter);
        SmithingTransformRecipeBuilder
                .smithing(
                        Ingredient.of(ModItems.RED_SABER_UPGRADE.get()),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(Items.REDSTONE_BLOCK),
                        RecipeCategory.COMBAT, ModItems.RED_SABER.get())
                .unlocks("has_upgrade", has(ModItems.RED_SABER_UPGRADE.get()))
                .save(pWriter, SafioMod.MOD_ID + "red_saber_smithing");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike),
                    pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  SafioMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
