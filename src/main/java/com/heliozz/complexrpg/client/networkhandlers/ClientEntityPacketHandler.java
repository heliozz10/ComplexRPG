package com.heliozz.complexrpg.client.networkhandlers;

import org.slf4j.Logger;

import com.heliozz.complexrpg.content.entity.mobs.Stonecrawler;
import com.heliozz.complexrpg.network.RefreshDimensionsPacket;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

public class ClientEntityPacketHandler {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	@SuppressWarnings("resource")
	public static void handleRefreshDimensions(final RefreshDimensionsPacket packet) {
		Entity entity = Minecraft.getInstance().level.getEntity(packet.entityId);
		if(entity == null) {
			return;
		} else 
			entity.refreshDimensions();
	}
}
