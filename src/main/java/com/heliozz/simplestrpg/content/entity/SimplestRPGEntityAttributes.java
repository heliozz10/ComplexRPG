package com.heliozz.simplestrpg.content.entity;

import org.slf4j.Logger;

import com.heliozz.simplestrpg.content.entity.mobs.*;
import com.heliozz.simplestrpg.content.entity.mobs.SimplestRPGMobs;
import com.mojang.logging.LogUtils;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

public class SimplestRPGEntityAttributes {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public static void addEntityAttributes(EntityAttributeCreationEvent event) {
    	event.put(SimplestRPGMobs.POSSESSED_COW.get(), PossessedCow.createAttributes().build());
    	event.put(SimplestRPGMobs.AWAKENED_COW.get(), AwakenedCow.createAttributes().build());
    }
    
}
