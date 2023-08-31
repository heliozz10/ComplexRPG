package com.heliozz.simplestrpg.content.entity.mobs;

import java.util.UUID;

import javax.annotation.Nullable;

import com.heliozz.simplestrpg.content.SimplestRPGItems;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class PossessedCow extends Monster implements NeutralMob {
	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(10, 20);
	@Nullable
	private UUID persistentAngerTarget;
	private int remainingPersistentAngerTime;
	
	public PossessedCow(EntityType<? extends PossessedCow> entity, Level level) {
		super(entity, level);
		this.xpReward = 10;
	}
	
	public void setPersistentAngerTarget(@Nullable UUID entity) {
		this.persistentAngerTarget = entity;
	}
	
	public void setRemainingPersistentAngerTime(int time) {
	    this.remainingPersistentAngerTime = time;
	}

	public int getRemainingPersistentAngerTime() {
	    return this.remainingPersistentAngerTime;
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MAX_HEALTH, 10.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.2D)
				.add(Attributes.ATTACK_DAMAGE, 3.0D);
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
	    this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
	    this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
	}
	
	protected SoundEvent getAmbientSound() {
	    return SoundEvents.COW_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource source) {
	    return SoundEvents.COW_HURT;
	}

	protected SoundEvent getDeathSound() {
	    return SoundEvents.COW_DEATH;
	}
	
	protected void playStepSound(BlockPos pos, BlockState state) {
	    this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}
	
	public boolean hurt(DamageSource source, float damage) {
		boolean flag = super.hurt(source, damage);
		Entity entity = source.getEntity();
		if(entity instanceof Player player) {
			if(player.getMainHandItem().is(SimplestRPGItems.CRIMSON_DAGGER.get())) {
				if(flag) this.convertTo(SimplestRPGMobs.AWAKENED_COW.get(), false);
			}
		}
		return flag;
	}
	
	public boolean isAngryAt(LivingEntity entity) {
	    if (!this.canAttack(entity)) {
	       return false;
	    } else {
	       return entity.getUUID().equals(this.getPersistentAngerTarget());
	    }
	}
	
	public void startPersistentAngerTimer() {
	    this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}
	
	public void setTarget(@Nullable LivingEntity entity) {
		if (entity instanceof Player) {
			this.setLastHurtByPlayer((Player)entity);
		}

		super.setTarget(entity);
	}
	
	protected void customServerAiStep() {
	    this.updatePersistentAnger((ServerLevel)this.level, true);

	    if (this.isAngry()) {
	    	this.lastHurtByPlayerTime = this.tickCount;
	    }

	    super.customServerAiStep();
	}
	
	public UUID getPersistentAngerTarget() {
		return persistentAngerTarget;
	}
	
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
	    this.addPersistentAngerSaveData(tag);
	}
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.readPersistentAngerSaveData(this.level, tag);
	}
	
	public boolean isPreventingPlayerRest(Player player) {
		return this.isAngryAt(player);
	}
	
	public static boolean checkPossessedCowSpawnRules(EntityType<? extends PossessedCow> entity, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource source) {
		return level.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) &&
			level.getDifficulty() != Difficulty.PEACEFUL && 
			checkMobSpawnRules(entity, level, spawnType, pos, source);
	}
}
