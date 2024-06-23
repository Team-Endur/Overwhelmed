package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SnailEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public SnailEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private void updateAnimations() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            updateAnimations();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D,
                Ingredient.ofItems(Items.SLIME_BALL), false));

        this.goalSelector.add(3, new FollowParentGoal(this, 1.15D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createSnailAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1F)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0F)
                .add(EntityAttributes.GENERIC_ARMOR, 0.2F)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.4F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.SLIME_BALL);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return OverwhelmedEntities.SNAIL.create(world);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return OverwhelmedSounds.ENTITY_SNAIL_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return OverwhelmedSounds.ENTITY_SNAIL_DEATH;
    }
}