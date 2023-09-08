package com.heliozz.complexrpg.data;

import java.util.function.Consumer;

import com.heliozz.complexrpg.content.ComplexRPGItems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class ComplexRPGRecipeProvider extends RecipeProvider {

	public ComplexRPGRecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> writer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ComplexRPGItems.INFUSED_IRON_INGOT.get())
				.pattern("###")
				.pattern("#I#")
				.pattern("###")
				.define('#', ComplexRPGItems.WEAK_DEMONIC_SOUL.get())
				.define('I', Items.IRON_INGOT)
				.unlockedBy("has_item", has(ComplexRPGItems.WEAK_DEMONIC_SOUL.get()))
				.save(writer);
	}
}
