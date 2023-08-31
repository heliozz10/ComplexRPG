package com.heliozz.simplestrpg.client;

import com.heliozz.simplestrpg.SimplestRPG;
import com.heliozz.simplestrpg.client.model.*;
import com.heliozz.simplestrpg.client.render.*;
import com.heliozz.simplestrpg.content.entity.mobs.SimplestRPGMobs;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = SimplestRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SimplestRPGClientEvents {
	@SubscribeEvent
	public static void onLayerDefinitionsRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(PossessedCowModel.LAYER_LOCATION, PossessedCowModel::createBodyLayer);
		event.registerLayerDefinition(AwakenedCowModel.LAYER_LOCATION, AwakenedCowModel::createBodyLayer);
		event.registerLayerDefinition(StonecrawlerModel.LAYER_LOCATION, AwakenedCowModel::createBodyLayer);
	}
	
	@SubscribeEvent
	public static void onEntityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SimplestRPGMobs.POSSESSED_COW.get(), PossessedCowRenderer::new);
		event.registerEntityRenderer(SimplestRPGMobs.AWAKENED_COW.get(), AwakenedCowRenderer::new);
		event.registerEntityRenderer(SimplestRPGMobs.STONECRAWLER.get(), StonecrawlerRenderer::new);
	}
}
