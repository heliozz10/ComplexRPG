package com.heliozz.simplestrpg.content;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.content.items.CrimsonDaggerItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SimplestRPGItems {
	private static final Map<String, Type> MAP = new HashMap<String, Type>();
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplestRPG.MODID);
	
	public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplestRPG.MODID);
	
	public static final RegistryObject<Item>
	//Ordinary items
		WEAK_DEMONIC_SOUL = registerBasic("weak_demonic_soul", Type.SIMPLE),
		INFUSED_IRON_INGOT = registerBasic("infused_iron_ingot", Type.SIMPLE),
	
	//Equipment
		CRIMSON_DAGGER = register("crimson_dagger", () -> new CrimsonDaggerItem(), Type.HANDHELD);
	
	//Edibles
	
	//Special items
	
	public static RegistryObject<Item> registerBasic(String name, Type type) {
		return register(name, () -> new Item(new Item.Properties()), type);
	}
	
	public static RegistryObject<Item> register(String name, Supplier<? extends Item> sup, Type type) {
		MAP.put(name, type);
		return ITEMS.register(name, sup);
	}
	
	public enum Type {
		SIMPLE,
		HANDHELD
	}
	
	public static Map<String, Type> getMap() {
		return MAP;
	}
}
