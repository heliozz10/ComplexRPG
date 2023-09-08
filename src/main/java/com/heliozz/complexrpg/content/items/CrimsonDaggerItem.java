package com.heliozz.complexrpg.content.items;

import java.util.List;

import javax.annotation.Nullable;

import com.heliozz.complexrpg.enums.SimplestRPGTiers;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrimsonDaggerItem extends SwordItem {
	public CrimsonDaggerItem() {
		super(SimplestRPGTiers.CRIMSON_DAGGER, 4, -2.0F, new Item.Properties());
	}
	
	@OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(Component.translatable("tooltip.simplestrpg.crimson_dagger").withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
    }
}
