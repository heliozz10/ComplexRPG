package com.heliozz.simplestrpg.enums;

import com.heliozz.simplestrpg.SimplestRPG;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public enum SimplestRPGTiers implements Tier {
	CRIMSON_DAGGER(4, 524, 2.0F, -1.0F, 15);
	
	private final int harvestLevel;
    private final int uses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private Ingredient repairMaterial;
	
	SimplestRPGTiers(int harvestLevel, int uses, float efficiency, float attackDamage, int enchantability) {
        this(harvestLevel, uses, efficiency, attackDamage, enchantability, Items.AIR);
    }
	SimplestRPGTiers(int harvestLevel, int uses, float efficiency, float attackDamage, int enchantability, String repairMaterial) {
        this(harvestLevel, uses, efficiency, attackDamage, enchantability, ForgeRegistries.ITEMS.getValue(new ResourceLocation(SimplestRPG.MODID, repairMaterial)));
    }
    private SimplestRPGTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Item repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.uses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = Ingredient.of(repairMaterialIn);
    }
    
    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamage;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial;
    }
}
