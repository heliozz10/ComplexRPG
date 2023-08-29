package com.heliozz.simplestrpg;

import static com.heliozz.simplestrpg.content.entity.mobs.SimplestRPGMobs.*;

import org.slf4j.Logger;

import com.heliozz.simplestrpg.content.entity.mobs.*;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SimplestRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SimplestRPGEvents {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
		LOGGER.info("Registered SimplestRPG spawn placements");
		registerOnGroundMob(event, POSSESSED_COW.get(), PossessedCow::checkPossessedCowSpawnRules);
	}
	
	public static <T extends Mob> void registerOnGroundMob(SpawnPlacementRegisterEvent event, EntityType<T> entity, SpawnPlacements.SpawnPredicate<T> predicate) {
		event.register(entity, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, predicate, Operation.REPLACE);
	}
}
