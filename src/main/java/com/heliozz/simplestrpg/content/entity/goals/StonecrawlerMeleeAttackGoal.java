package com.heliozz.simplestrpg.content.entity.goals;

import com.heliozz.simplestrpg.content.entity.mobs.Stonecrawler;

import net.minecraft.world.entity.ai.goal.Goal;

public class StonecrawlerMeleeAttackGoal extends Goal {
	protected final Stonecrawler mob;
	private final boolean followingTargetEvenIfNotSeen;
	private long lastCanUseCheck;
	
	public StonecrawlerMeleeAttackGoal(Stonecrawler mob, boolean followingTargetEvenIfNotSeen) {
		this.mob = mob;
		this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
	}
	
	
	@Override
	public boolean canUse() {
		long ticks = mob.level.getGameTime();

        if (ticks - lastCanUseCheck < 20L) {
            return false;
        }
        
        lastCanUseCheck = ticks;
        return false;
	}
}
