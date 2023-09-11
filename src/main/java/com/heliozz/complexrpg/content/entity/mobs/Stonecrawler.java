package com.heliozz.complexrpg.content.entity.mobs;

import java.util.UUID;

import org.slf4j.Logger;

import com.heliozz.complexrpg.content.entity.goal.StonecrawlerMeleeAttackGoal;
import com.mojang.logging.LogUtils;

import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Stonecrawler extends Monster {
	private static final Logger LOGGER = LogUtils.getLogger();
	
	private static final UUID SPEED_MODIFIER_2_PHASE_UUID = UUID.fromString("45A40252-6010-4692-8751-47FB9E65BD7B");
	private static final UUID DAMAGE_MODIFIER_2_PHASE_UUID = UUID.fromString("4A400C00-4D5E-11EE-A4BB-C7E213CD602B");
	private static final AttributeModifier SPEED_MODIFIER_2_PHASE = new AttributeModifier(SPEED_MODIFIER_2_PHASE_UUID, "2 phase speed boost", 0.07D, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier DAMAGE_MODIFIER_2_PHASE = new AttributeModifier(DAMAGE_MODIFIER_2_PHASE_UUID, "2 phase damage boost", 2.0D, AttributeModifier.Operation.ADDITION);
	private static final EntityDataAccessor<Boolean> DATA_CRAWLING_ID = SynchedEntityData.defineId(Stonecrawler.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDimensions REDUCED_HITBOX = EntityDimensions.scalable(0.8F, 0.8F);
	
	private boolean isInSecondPhase = false;
	
	protected Stonecrawler(EntityType<? extends Stonecrawler> entity, Level level) {
		super(entity, level);
		this.refreshDimensions();
		this.xpReward = 20;
	}
	
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	 	this.addBehaviourGoals();
	}

	protected void addBehaviourGoals() {
		this.goalSelector.addGoal(2, new StonecrawlerMeleeAttackGoal(this, true));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	   	this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	   	this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}
	

	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("IsInSecondPhase", this.isInSecondPhase);
	}
	
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.isInSecondPhase = tag.getBoolean("IsInSecondPhase");
	}
	
	public boolean hurt(DamageSource source, float damageIn) {
		boolean flag = super.hurt(source, damageIn);
		if(!this.level.isClientSide && !this.isInSecondPhase)
			if(this.getHealth() <= 30.0F) {
				AttributeInstance speed = this.getAttribute(Attributes.MOVEMENT_SPEED);
				AttributeInstance damage = this.getAttribute(Attributes.ATTACK_DAMAGE);
				speed.addPermanentModifier(SPEED_MODIFIER_2_PHASE);
				damage.addPermanentModifier(DAMAGE_MODIFIER_2_PHASE);
				this.isInSecondPhase = true;
			}
		return flag;
	}
	
	public void tick() {
		if(!this.level.isClientSide) {
			if(this.level.getGameTime() % 20 == 0) {
				LOGGER.info("Direction: " + this.getDirection().name());
				LOGGER.info(this.blockPosition().relative(getDirection()).toShortString());
				LOGGER.info(this.getDimensions(this.getPose()).toString());
			}
			if(this.level.getBlockState(this.blockPosition().above()).getMaterial().isSolid() && this.onGround)
				this.setCrawling(true);
			else if(this.level.getGameTime() % 100 == 0) 
				this.setCrawling(false);
		}
		super.tick();
	}
	
	public void setCrawling(boolean value) {
		this.entityData.set(DATA_CRAWLING_ID, value);
		this.refreshDimensions();
	}
	
	public boolean isCrawling() {
		return this.getEntityData().get(DATA_CRAWLING_ID);
	}
	
	public EntityDimensions getDimensions(Pose pose) {
		return this.isCrawling() ? REDUCED_HITBOX : super.getDimensions(pose); 
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.FOLLOW_RANGE, 32.0D)
				.add(Attributes.MAX_HEALTH, 50.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.28D)
				.add(Attributes.ATTACK_DAMAGE, 6.0D);
	}
	
	protected void defineSynchedData() {
	    super.defineSynchedData();
	    this.entityData.define(DATA_CRAWLING_ID, false);
	}
	
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
	    return dimensions.height - 0.1F;
	}
}