package com.heliozz.simplestrpg.content.entity.mobs;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class Stonecrawler extends Monster {
	private static final EntityDataAccessor<Boolean> CRAWLING_ID = SynchedEntityData.defineId(Stonecrawler.class, EntityDataSerializers.BOOLEAN);
	
	protected Stonecrawler(EntityType<? extends Stonecrawler> entity, Level level) {
		super(entity, level);
		this.xpReward = 20;
	}

}