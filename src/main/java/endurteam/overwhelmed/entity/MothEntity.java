package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MothEntity extends AnimalEntity implements Flutterer {
    public AnimationState flyingAnimationState = new AnimationState();

    protected MothEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource damageSource) {
        return OverwhelmedSounds.ENTITY_SNAIL_HURT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return OverwhelmedSounds.ENTITY_SNAIL_DEATH;
    }

    protected void pushAway(Entity entity) {
    }

    protected void tickCramming() {
    }

    public static DefaultAttributeContainer.Builder createMothAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0F)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.4F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient())
        {
            this.flyingAnimationState.start(this.age);
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        BirdNavigation birdNavigation = new BirdNavigation(this, world){
            @Override
            public boolean isValidPosition(BlockPos pos) {
                return !this.world.getBlockState(pos.down()).isAir();
            }
        };
        birdNavigation.setCanPathThroughDoors(false);
        birdNavigation.setCanSwim(false);
        birdNavigation.setCanEnterOpenDoors(true);
        return birdNavigation;
    }

    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public boolean isFlappingWings() {
        return this.isInAir();
    }

    @Override
    public boolean isInAir() {
        return !this.isOnGround();
    }
}
