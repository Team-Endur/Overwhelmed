package endurteam.overwhelmed.entity;

import com.mojang.serialization.Codec;
import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public class MothEntity
        extends AnimalEntity
        implements Flutterer, VariantHolder<MothEntity.MothType> {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(MothEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected MothEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 15, true);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, -1.0f);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0f);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 16.0f);
        this.setPathfindingPenalty(PathNodeType.COCOA, -1.0f);
        this.setPathfindingPenalty(PathNodeType.FENCE, -1.0f);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, MothType.GRAND.id);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos) {
        if(getWorld().getBlockState(pos).isAir())
            return 10.0f;
        return 1.0f;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MothWanderAroundGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(2, new LookAroundGoal(this));
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

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    @Override
    public void setVariant(MothType variant) {
        this.dataTracker.set(VARIANT, variant.id);
    }

    @Override
    public MothType getVariant() {
        return MothType.byId(this.dataTracker.get(VARIANT));
    }

    public enum MothType implements StringIdentifiable {
        CABBAGE(0, "cabbage"),
        CHERRY(1, "cherry"),
        FUR(2, "fur"),
        GRAND(3, "grand"),
        LIVERWORT(4, "liverwort"),
        MONARCH(5, "monarch"),
        MORPHO(6, "morpho"),
        SLEEPY(7, "sleepy");

        private static final IntFunction<MothType> BY_ID;
        public static final Codec<MothType> CODEC;
        final int id;
        private final String name;

        private MothType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String asString() {
            return this.name;
        }

        public int getId() {
            return this.id;
        }

        public static MothType byId(int id) {
            return BY_ID.apply(id);
        }

        static {
            BY_ID = ValueLists.createIdToValueFunction(MothType::getId, MothType.values(), CABBAGE);
            CODEC = StringIdentifiable.createCodec(MothType::values);
        }
    }

    class MothWanderAroundGoal extends Goal {
        private final MothEntity moth;

        public MothWanderAroundGoal(MothEntity moth) {
            this.moth = moth;
        }

        @Override
        public boolean canStart() {
            return this.moth.getNavigation().isIdle();
        }

        @Override
        public void start() {
            Vec3d loc = this.getRandomLocation();
            if(loc != null)
                this.moth.getNavigation().startMovingAlong(this.moth.getNavigation().findPathTo(BlockPos.ofFloored(loc), 1), 1.0);
        }

        @Override
        public boolean shouldContinue() {
            return this.moth.getNavigation().isFollowingPath();
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d mothPos = this.moth.getPos();

            Vec3d vec3d3 = AboveGroundTargeting.find(this.moth, 15, 10, mothPos.x, mothPos.z, 1.5707964f, 5, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }
            return NoPenaltySolidTargeting.find(this.moth, 15, 10, -2, mothPos.x, mothPos.z, 1.5707963705062866);
        }
    }
}
