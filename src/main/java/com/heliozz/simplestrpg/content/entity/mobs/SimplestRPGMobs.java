package com.heliozz.simplestrpg.content.entity.mobs;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.content.SimplestRPGItems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SimplestRPGMobs {
	public static final DeferredRegister<EntityType<?>> MOBS = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SimplestRPG.MODID);
	
	public static final RegistryObject<EntityType<PossessedCow>> POSSESSED_COW = registerEntity(PossessedCow::new, "possessed_cow", 0.9F, 1.4F, 0xFFFFFF, 0xFFFFFF, MobCategory.MONSTER);
	public static final RegistryObject<EntityType<AwakenedCow>> AWAKENED_COW = registerEntity(AwakenedCow::new, "awakened_cow", 0.9F, 1.4F, 0xFFFFFF, 0xFFFFFF, MobCategory.MONSTER);
	public static final RegistryObject<EntityType<Stonecrawler>> STONECRAWLER = registerEntity(Stonecrawler::new, "stonecrawler", 0.9F, 1.6F, 0xFFFFFF, 0xFFFFFF, MobCategory.MONSTER);
	
	private static final <T extends Mob> RegistryObject<EntityType<T>> registerEntity(EntityFactory<T> factory, String name, float width, float height, int primaryColor, int secondColor, MobCategory category) {
        RegistryObject<EntityType<T>> entity = MOBS.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(new ResourceLocation(SimplestRPG.MODID, name).toString()));
        SimplestRPGItems.SPAWN_EGGS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(entity, secondColor, primaryColor, new Item.Properties()));
        return entity;
    }
}
