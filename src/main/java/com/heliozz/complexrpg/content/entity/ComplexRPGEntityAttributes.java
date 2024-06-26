package com.heliozz.complexrpg.content.entity;

import com.heliozz.complexrpg.content.entity.mobs.*;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

public class ComplexRPGEntityAttributes {
	public static void addEntityAttributes(EntityAttributeCreationEvent event) {
    	event.put(ComplexRPGMobs.POSSESSED_COW.get(), PossessedCow.createAttributes().build());
    	event.put(ComplexRPGMobs.AWAKENED_COW.get(), AwakenedCow.createAttributes().build());
    	event.put(ComplexRPGMobs.STONECRAWLER.get(), Stonecrawler.createAttributes().build());
    	event.put(ComplexRPGMobs.SOULMITE.get(), Soulmite.createAttributes().build());
    	event.put(ComplexRPGMobs.HARPOONER.get(), Harpooner.createAttributes().build());
    }
}
