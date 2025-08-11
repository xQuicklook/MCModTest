package de.niklas.tutorialmod.datagen;

import de.niklas.tutorialmod.TutorialMod;
import de.niklas.tutorialmod.block.ModBlocks;
import de.niklas.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
                ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.RAW_ALEXANDRITE.get()), has(ModItems.RAW_ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HOE.get())
                .pattern("AA")
                .pattern(" B")
                .pattern(" B")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_AXE.get())
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HAMMER.get())
                .pattern(" AA")
                .pattern(" BA")
                .pattern("B  ")
                .define('A', ModItems.ALEXANDRITE_PICKAXE.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE_PICKAXE.get()), has(ModItems.ALEXANDRITE_PICKAXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_LEGGINS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALEXANDRITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOMAHAWK.get())
                .pattern("BCB")
                .pattern("BAB")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', Items.NETHERITE_INGOT)
                .define('C', ModItems.ALEXANDRITE_AXE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE_AXE.get()), has(ModItems.ALEXANDRITE_AXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHAIR.get())
                .pattern("A  ")
                .pattern("AAA")
                .pattern("A A")
                .define('A', Items.OAK_PLANKS)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(Items.OAK_PLANKS)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WALNUT_PLANKS.get(), 4)
                .pattern("A")
                .define('A', ModBlocks.WALNUT_LOG.get())
                .unlockedBy(getHasName(ModBlocks.WALNUT_LOG.get()), has(ModBlocks.WALNUT_LOG.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModBlocks.ALEXANDRITE_BLOCK.get())
                .define('B', ModItems.CHISEL.get())
                .unlockedBy(getHasName(ModItems.CHISEL.get()), has(ModItems.CHISEL.get())).save(pRecipeOutput);





        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), 9)
                .requires(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), has(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":alexandrite_from_magic_block");

        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()),
                RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.ALEXANDRITE_BLOCK.get(),
                0.3f,
                200)
                .unlockedBy("has_raw_alexandrite", has(ModItems.RAW_ALEXANDRITE.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":raw_alexandrite_block_from_smelting");

        oreSmelting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        stairBuilder(ModBlocks.ALEXANDRITE_STAIRS.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE.get());

        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE.get());

        fenceBuilder(ModBlocks.ALEXANDRITE_FENCE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE.get());

        doorBuilder(ModBlocks.ALEXANDRITE_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.ALEXANDRITE_TRAP_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        trimSmithing(pRecipeOutput, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaupen"));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
