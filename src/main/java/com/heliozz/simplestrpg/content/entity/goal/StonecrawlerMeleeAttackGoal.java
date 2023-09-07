package com.heliozz.simplestrpg.content.entity.goal;

import com.heliozz.simplestrpg.content.entity.mobs.Stonecrawler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.Path;

public class StonecrawlerMeleeAttackGoal extends Goal {
	protected final Stonecrawler mob;
	private final boolean followingTargetEvenIfNotSeen;
	private long lastCanUseCheck = 0;
	
	public StonecrawlerMeleeAttackGoal(Stonecrawler mob, boolean followingTargetEvenIfNotSeen) {
		this.mob = mob;
		this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
	}
	
	
	@Override
	public boolean canUse() {
		long ticks = mob.level.getGameTime();
		LivingEntity target = mob.getTarget();

        if (ticks - lastCanUseCheck < 20L) {
            return false;
        }
        
        lastCanUseCheck = ticks;
        
        Path path = mob.getNavigation().createPath(target, 0);
        
        if(path != null) {
        	return true;
        }
        
        boolean canAttack = getAttackReachSqr(target) >= mob.distanceToSqr(target);
        if(canAttack) return true;
        
        return false;
	}
	
	protected double getAttackReachSqr(LivingEntity p_25556_) {
	    return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + p_25556_.getBbWidth());
	}
}
