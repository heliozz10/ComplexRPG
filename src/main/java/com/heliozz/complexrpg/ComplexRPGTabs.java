package com.heliozz.complexrpg;

import com.heliozz.complexrpg.content.ComplexRPGItems;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;

public class ComplexRPGTabs {
	public static final ResourceLocation ITEMS = new ResourceLocation(ComplexRPG.MODID, "items");
    public static final ResourceLocation BLOCKS = new ResourceLocation(ComplexRPG.MODID, "blocks");
    public static final ResourceLocation TOOLS = new ResourceLocation(ComplexRPG.MODID, "tools");
    
    public static void registerTabs(CreativeModeTabEvent.Register event) {
    	event.registerCreativeModeTab(ITEMS, builder -> builder
    			.title(Component.translatable("itemGroup.simplestrpg.items"))
    			.icon(() -> new ItemStack(ComplexRPGItems.CRIMSON_DAGGER.get()))
    			.displayItems((flags, output) -> {
    				ComplexRPGItems.ITEMS.getEntries().forEach(regObject -> {
    					output.accept(regObject.get());
    				});
    			}));
    }
}
