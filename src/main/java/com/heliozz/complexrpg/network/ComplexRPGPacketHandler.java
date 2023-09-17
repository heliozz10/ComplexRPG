package com.heliozz.complexrpg.network;

import com.heliozz.complexrpg.ComplexRPG;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ComplexRPGPacketHandler {
	private static final String PROTOCOL_VERSION = "27";
	private static int ID = 0;
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ComplexRPG.MODID, "main"), 
			() -> PROTOCOL_VERSION, 
			PROTOCOL_VERSION::equals, 
			PROTOCOL_VERSION::equals
	);
	
	public static void register() {
		INSTANCE.registerMessage(ID++, RefreshDimensionsPacket.class, RefreshDimensionsPacket::encode, RefreshDimensionsPacket::decode, RefreshDimensionsPacket::handle);
	}
}
