package com.heliozz.complexrpg;

import org.slf4j.Logger;

import com.heliozz.complexrpg.client.ComplexRPGClientEvents;
import com.heliozz.complexrpg.content.ComplexRPGBlocks;
import com.heliozz.complexrpg.content.ComplexRPGItems;
import com.heliozz.complexrpg.content.entity.ComplexRPGEntityAttributes;
import com.heliozz.complexrpg.content.entity.mobs.ComplexRPGMobs;
import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ComplexRPG.MODID)
public class ComplexRPG
{
    public static final String MODID = "simplestrpg";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public ComplexRPG() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        ComplexRPGMobs.MOBS.register(modEventBus);
        ComplexRPGBlocks.BLOCKS.register(modEventBus);
        ComplexRPGItems.ITEMS.register(modEventBus);
        ComplexRPGItems.SPAWN_EGGS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ComplexRPGEvents.class);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ComplexRPGEntityAttributes::addEntityAttributes);
        modEventBus.addListener(ComplexRPGTabs::registerTabs);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS)
            ComplexRPGItems.SPAWN_EGGS.getEntries().forEach(regObject -> {
            	event.accept(regObject);
            });
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
    	
    }
}
