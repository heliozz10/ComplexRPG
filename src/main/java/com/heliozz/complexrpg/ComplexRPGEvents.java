package com.heliozz.complexrpg;

import static com.heliozz.complexrpg.content.entity.mobs.ComplexRPGMobs.*;

import org.slf4j.Logger;

import com.heliozz.complexrpg.content.entity.mobs.*;
import com.mojang.logging.LogUtils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent.Operation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ComplexRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ComplexRPGEvents {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
		LOGGER.info("Registered " + ComplexRPG.MODID + " spawn placements");
		registerOnGroundMob(event, POSSESSED_COW.get(), PossessedCow::checkPossessedCowSpawnRules);
	}
	
	public static <T extends Mob> void registerOnGroundMob(SpawnPlacementRegisterEvent event, EntityType<T> entity, SpawnPlacements.SpawnPredicate<T> predicate) {
		event.register(entity, SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, predicate, Operation.REPLACE);
	}
}
