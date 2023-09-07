package com.heliozz.simplestrpg.content.entity.mobs;

import java.util.UUID;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Stonecrawler extends Monster {
	private static final UUID SPEED_MODIFIER_2_PHASE_UUID = UUID.fromString("45A40252-6010-4692-8751-47FB9E65BD7B");
	private static final UUID DAMAGE_MODIFIER_2_PHASE_UUID = UUID.fromString("4A400C00-4D5E-11EE-A4BB-C7E213CD602B");
	private static final AttributeModifier SPEED_MODIFIER_2_PHASE = new AttributeModifier(SPEED_MODIFIER_2_PHASE_UUID, "2 phase speed boost", 0.07D, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier DAMAGE_MODIFIER_2_PHASE = new AttributeModifier(DAMAGE_MODIFIER_2_PHASE_UUID, "2 phase damage boost", 2.0D, AttributeModifier.Operation.ADDITION);
	private static final EntityDataAccessor<Boolean> DATA_CRAWLING = SynchedEntityData.defineId(Stonecrawler.class, EntityDataSerializers.BOOLEAN);
	
	protected Stonecrawler(EntityType<? extends Stonecrawler> entity, Level level) {
		super(entity, level);
		this.xpReward = 20;
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	 	this.addBehaviourGoals();
	}

	protected void addBehaviourGoals() {
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	
	public boolean hurt(DamageSource source, float damageIn) {
		boolean flag = super.hurt(source, damageIn);
		if(this.getHealth() <= 30.0F) {
			AttributeInstance speed = this.getAttribute(Attributes.MOVEMENT_SPEED);
			AttributeInstance damage = this.getAttribute(Attributes.ATTACK_DAMAGE);
			speed.addTransientModifier(SPEED_MODIFIER_2_PHASE);
			damage.addTransientModifier(DAMAGE_MODIFIER_2_PHASE);
		}
		return flag;
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 32.0D)
				.add(Attributes.MAX_HEALTH, 50.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.28D)
				.add(Attributes.ATTACK_DAMAGE, 8.0D);
	}
	
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
	    return 1.5F;
	}
}