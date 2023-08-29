package com.heliozz.simplestrpg.content;

import java.util.function.Supplier;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.content.items.CrimsonDaggerItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SimplestRPGItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplestRPG.MODID);
	
	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplestRPG.MODID);
	
	public static final RegistryObject<Item>
	//Ordinary items
		WEAK_DEMONIC_SOUL = registerBasic("weak_demonic_soul"),
	
	//Equipment
		CRIMSON_DAGGER = register("crimson_dagger", () -> new CrimsonDaggerItem());
	
	//Edibles
	
	//Special items
	
	public static RegistryObject<Item> registerBasic(String name) {
		return register(name, () -> new Item(new Item.Properties()));
	}
	
	public static RegistryObject<Item> register(String name, Supplier<? extends Item> sup) {
		return ITEMS.register(name, sup);
	}
}
