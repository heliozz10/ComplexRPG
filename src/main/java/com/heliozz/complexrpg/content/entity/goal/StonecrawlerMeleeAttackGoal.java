package com.heliozz.complexrpg.content.entity.goal;

import java.util.EnumSet;

import org.slf4j.Logger;

import com.heliozz.complexrpg.content.entity.mobs.Stonecrawler;
import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.pathfinder.Path;

public class StonecrawlerMeleeAttackGoal extends Goal {
	protected final Stonecrawler mob;
	private final boolean followingTargetEvenIfNotSeen;
	private static final Logger LOGGER = LogUtils.getLogger();
	
	private Path path;
	private long lastCanUseCheck = 0;
	private int ticksUntilNextPathRecalculation = 40;
	private int ticksUntilNextAttack;
	
	public StonecrawlerMeleeAttackGoal(Stonecrawler mob, boolean followingTargetEvenIfNotSeen) {
		this.mob = mob;
		this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}
	
	
	@Override
	public boolean canUse() {
		long ticks = this.mob.level.getGameTime();
		
        if (ticks - lastCanUseCheck < 20L) {
            return false;
        }
        
        lastCanUseCheck = ticks;
        
        LivingEntity target = this.mob.getTarget();
        if(target == null) {
        	return false;
        }
        
        this.path = this.mob.getNavigation().createPath(target, 0);
        
        if(path != null) {
        	return true;
        }
        
        boolean canAttack = getAttackReachSqr(target) >= this.mob.distanceToSqr(target);
        if(canAttack) return true;
        
        this.mob.setCrawling(true);
        this.path = mob.getNavigation().createPath(target, 0);
        
        return path != null;
	}
	
	protected double getAttackReachSqr(LivingEntity target) {
	    return (double)(this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + target.getBbWidth());
	}
	
	public boolean canContinueToUse() {
	    LivingEntity livingentity = this.mob.getTarget();
	    if (livingentity == null) {
	       return false;
	    } else if (!livingentity.isAlive()) {
	       return false;
	    } else if (!this.followingTargetEvenIfNotSeen) {
	       return !this.mob.getNavigation().isDone();
	    } else if (!this.mob.isWithinRestriction(livingentity.blockPosition())) {
	       return false;
	    } else {
	       return !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
	    }
	}

	
	public void start() {
		this.mob.getNavigation().moveTo(this.path, 1.0D);
	    this.mob.setAggressive(true);
	}
	
	@Override
    public void stop() {
		LivingEntity livingentity = this.mob.getTarget();
	    if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
	    	this.mob.setTarget(null);
	    }
		
        this.mob.setAggressive(false);
        this.mob.setCrawling(false);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }
    
    public void tick() {
    	LivingEntity target = this.mob.getTarget();
    	if(target != null) {
    		this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
    		ticksUntilNextPathRecalculation--;
    		if(ticksUntilNextPathRecalculation <= 0) {
    			ticksUntilNextPathRecalculation = 40;
    			this.path = this.mob.getNavigation().createPath(target, 0);
    		
    			if(this.path == null && !this.mob.isCrawling()) {
    				BlockPos pos = this.mob.blockPosition();
    				boolean condition1 = this.mob.level.getBlockState(pos.relative(this.mob.getDirection())).getMaterial().isSolid();
    				boolean condition2 = this.mob.level.getBlockState(pos.relative(this.mob.getDirection()).above()).getMaterial().isSolid();
    				if(condition1 ^ condition2) {
    					this.mob.setCrawling(true);
    					path = this.mob.getNavigation().createPath(target, 0);
    					if(this.path != null) this.mob.getNavigation().moveTo(path, 1.0D);
    				}
    				return;
    			}
    			this.mob.getNavigation().moveTo(path, 1.0D);
    		}
    		
    		this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
    		this.checkAndPerformAttack(target, this.mob.distanceToSqr(target));
    	}
    }
    
    protected void checkAndPerformAttack(LivingEntity target, double distance) {
        double d0 = this.getAttackReachSqr(target);
        if (distance <= d0 && this.ticksUntilNextAttack <= 0) {
        	this.resetAttackCooldown();
        	this.mob.swing(InteractionHand.MAIN_HAND);
        	this.mob.doHurtTarget(target);
        }

    }
    
    protected void resetAttackCooldown() {
    	this.ticksUntilNextAttack = this.adjustedTickDelay(20);
    }
}
