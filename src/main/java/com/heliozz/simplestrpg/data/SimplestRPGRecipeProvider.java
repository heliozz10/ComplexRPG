package com.heliozz.simplestrpg.data;

import java.util.function.Consumer;

import com.heliozz.simplestrpg.content.SimplestRPGItems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

public class SimplestRPGRecipeProvider extends RecipeProvider {

	public SimplestRPGRecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> writer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, SimplestRPGItems.INFUSED_IRON_INGOT.get())
				.pattern("###")
				.pattern("#I#")
				.pattern("###")
				.define('#', SimplestRPGItems.WEAK_DEMONIC_SOUL.get())
				.define('I', Items.IRON_INGOT)
				.unlockedBy("has_item", has(SimplestRPGItems.WEAK_DEMONIC_SOUL.get()))
				.save(writer);
	}
}
