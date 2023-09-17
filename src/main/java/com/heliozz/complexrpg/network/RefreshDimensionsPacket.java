package com.heliozz.complexrpg.network;

import java.util.function.Supplier;

import com.heliozz.complexrpg.client.networkhandlers.ClientEntityPacketHandler;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent.Context;

public class RefreshDimensionsPacket{
	public final int entityId;
	
	public RefreshDimensionsPacket(int entityId) {
		this.entityId = entityId;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeInt(entityId);
	}

	public static RefreshDimensionsPacket decode(FriendlyByteBuf buffer) {
		return new RefreshDimensionsPacket(
				buffer.readInt()
		);
	}

	public static void handle(RefreshDimensionsPacket packet, Supplier<Context> context) {
		ClientEntityPacketHandler.handleRefreshDimensions(packet);
		context.get().setPacketHandled(true);
	}
}
