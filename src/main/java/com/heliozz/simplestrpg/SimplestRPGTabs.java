package com.heliozz.simplestrpg;

import com.heliozz.simplestrpg.content.SimplestRPGItems;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class SimplestRPGTabs {
	public static final ResourceLocation ITEMS = new ResourceLocation(SimplestRPG.MODID, "items");
    public static final ResourceLocation BLOCKS = new ResourceLocation(SimplestRPG.MODID, "blocks");
    public static final ResourceLocation TOOLS = new ResourceLocation(SimplestRPG.MODID, "tools");
    
    public static void registerTabs(CreativeModeTabEvent.Register event) {
    	event.registerCreativeModeTab(ITEMS, builder -> builder
    			.title(Component.translatable("itemGroup.simplestrpg.items"))
    			.icon(() -> new ItemStack(SimplestRPGItems.CRIMSON_DAGGER.get()))
    			.displayItems((flags, output) -> {
    				SimplestRPGItems.ITEMS.getEntries().forEach(regObject -> {
    					output.accept(regObject.get());
    				});
    			}));
    }
}
