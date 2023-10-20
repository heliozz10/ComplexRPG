package com.heliozz.complexrpg.client;

import org.slf4j.Logger;

import com.heliozz.complexrpg.ComplexRPG;
import com.heliozz.complexrpg.client.model.*;
import com.heliozz.complexrpg.client.render.*;
import com.heliozz.complexrpg.content.entity.mobs.ComplexRPGMobs;
import com.mojang.logging.LogUtils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = ComplexRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ComplexRPGClientEvents {
	private static final Logger LOGGER = LogUtils.getLogger();
	@SubscribeEvent
	public static void onLayerDefinitionsRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(PossessedCowModel.LAYER_LOCATION, PossessedCowModel::createBodyLayer);
		event.registerLayerDefinition(AwakenedCowModel.LAYER_LOCATION, AwakenedCowModel::createBodyLayer);
		event.registerLayerDefinition(StonecrawlerModel.LAYER_LOCATION, StonecrawlerModel::createBodyLayer);
		event.registerLayerDefinition(SoulmiteModel.LAYER_LOCATION, SoulmiteModel::createBodyLayer);
	}
	
	@SubscribeEvent
	public static void onEntityRendererRegister(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ComplexRPGMobs.POSSESSED_COW.get(), PossessedCowRenderer::new);
		event.registerEntityRenderer(ComplexRPGMobs.AWAKENED_COW.get(), AwakenedCowRenderer::new);
		event.registerEntityRenderer(ComplexRPGMobs.STONECRAWLER.get(), StonecrawlerRenderer::new);
		event.registerEntityRenderer(ComplexRPGMobs.SOULMITE.get(), SoulmiteRenderer::new);
	}
}
