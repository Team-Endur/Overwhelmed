package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.datagen.OverwhelmedItemTagProvider;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class HornetEntity extends AnimalEntity implements Angerable, Flutterer {
    public static final TrackedData<Integer> ANGER = DataTracker.registerData(HornetEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(25, 49);
    @Nullable
    private UUID angryAt;

    protected HornetEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 25, true);
        this.lookControl = new HornetLookControl(this);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0f);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0f);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 16.0f);
        this.setPathfindingPenalty(PathNodeType.COCOA, -1.0f);
        this.setPathfindingPenalty(PathNodeType.FENCE, -1.0f);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ANGER, 0);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new TemptGoal(this, 1.4f, stack -> stack.isIn(OverwhelmedItemTagProvider.HORNET_FOOD), false));
        this.goalSelector.add(1, new HornetWanderAroundGoal(this));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 5f));
        this.goalSelector.add(3, new LookAroundGoal(this));
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

    public static DefaultAttributeContainer.Builder createHornetAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
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
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    @Override
    public boolean isFlappingWings() {
        return this.isInAir();
    }

    @Override
    public boolean isInAir() {
        return !this.isOnGround();
    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return this.angryAt;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {
        this.angryAt = angryAt;
    }

    @Override
    public int getAngerTime() {
        return this.dataTracker.get(ANGER);
    }

    @Override
    public void setAngerTime(int angerTime) {
        this.dataTracker.set(ANGER, angerTime);
    }

    @Override
    public void chooseRandomAngerTime() {
        this.setAngerTime(ANGER_TIME_RANGE.get(this.random));
    }

    class HornetLookControl extends LookControl {
        public HornetLookControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
            if(HornetEntity.this.hasAngerTime())
                return;

            super.tick();
        }
    }

    class HornetWanderAroundGoal extends Goal {
        private static final int MAX_DIST_FROM_HIVE = 50;
        private final HornetEntity hornet;

        public HornetWanderAroundGoal(HornetEntity hornet) {
            this.hornet = hornet;
        }

        @Override
        public boolean canStart() {
            return this.hornet.getNavigation().isIdle();
        }

        @Override
        public void start() {
            Vec3d loc = this.getRandomLocation();
            if(loc != null)
                this.hornet.getNavigation().startMovingAlong(this.hornet.getNavigation().findPathTo(BlockPos.ofFloored(loc), 1), 1.2);
        }

        @Override
        public boolean shouldContinue() {
            return this.hornet.getNavigation().isFollowingPath();
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d hornetPos = this.hornet.getPos();

            Vec3d vec3d3 = AboveGroundTargeting.find(this.hornet, 8, 7, hornetPos.x, hornetPos.z, 1.5707964f, 3, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }
            return NoPenaltySolidTargeting.find(this.hornet, 8, 4, -2, hornetPos.x, hornetPos.z, 1.5707963705062866);
        }
    }
}
