package com.heliozz.simplestrpg;

import org.slf4j.Logger;

import com.heliozz.simplestrpg.content.SimplestRPGBlocks;
import com.heliozz.simplestrpg.content.SimplestRPGItems;
import com.heliozz.simplestrpg.content.entity.SimplestRPGEntityAttributes;
import com.heliozz.simplestrpg.content.entity.mobs.SimplestRPGMobs;
import com.mojang.logging.LogUtils;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SimplestRPG.MODID)
public class SimplestRPG
{
    public static final String MODID = "simplestrpg";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    //TODO: remove these below

    public static final RegistryObject<Block> EXAMPLE_BLOCK = SimplestRPGBlocks.BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = SimplestRPGItems.ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    public SimplestRPG() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        SimplestRPGMobs.MOBS.register(modEventBus);
        SimplestRPGBlocks.BLOCKS.register(modEventBus);
        SimplestRPGItems.ITEMS.register(modEventBus);
        SimplestRPGItems.SPAWN_EGGS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(SimplestRPGEvents.class);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(SimplestRPGEntityAttributes::addEntityAttributes);
        modEventBus.addListener(SimplestRPGTabs::registerTabs);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS)
            SimplestRPGItems.SPAWN_EGGS.getEntries().forEach(regobject -> {
            	event.accept(regobject);
            });
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
    	
    }
}
