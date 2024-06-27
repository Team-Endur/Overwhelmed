package endurteam.overwhelmed.entity;

import com.mojang.serialization.Codec;
import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.VariantHolder;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
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
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public class ButterflyEntity
        extends AnimalEntity
        implements Flutterer, VariantHolder<ButterflyEntity.ButterflyType> {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(ButterflyEntity.class, TrackedDataHandlerRegistry.INTEGER);

    protected ButterflyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
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
        builder.add(VARIANT, ButterflyType.CABBAGE.id);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos) {
        if(getWorld().getBlockState(pos).isAir())
            return 10.0f;
        return 1.0f;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new ButterflyEntity.ButterflyWanderAroundGoal(this));
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

    public static DefaultAttributeContainer.Builder createButterflyAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0F)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6F);
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

    public Identifier getTextureId() {
        return new Identifier(Overwhelmed.MOD_ID, "textures/entity/butterfly/butterfly_" + this.getVariant().asString() + ".png");
    }

    @Override
    public void setVariant(ButterflyEntity.ButterflyType variant) {
        this.dataTracker.set(VARIANT, variant.id);
    }

    @Override
    public ButterflyEntity.ButterflyType getVariant() {
        return ButterflyEntity.ButterflyType.byId(this.dataTracker.get(VARIANT));
    }

    public enum ButterflyType implements StringIdentifiable {
        CABBAGE(0, "cabbage"),
        CHERRY(1, "cherry"),
        FUR(2, "fur"),
        LIVERWORT(3, "liverwort"),
        MONARCH(4, "monarch"),
        MORPHO(5, "morpho"),
        SLEEPY(6, "sleepy");

        private static final IntFunction<ButterflyEntity.ButterflyType> BY_ID;
        public static final Codec<ButterflyEntity.ButterflyType> CODEC;
        final int id;
        private final String name;

        ButterflyType(int id, String name) {
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

        public static ButterflyEntity.ButterflyType byId(int id) {
            return BY_ID.apply(id);
        }

        static {
            BY_ID = ValueLists.createIdToValueFunction(ButterflyEntity.ButterflyType::getId, ButterflyEntity.ButterflyType.values(), CABBAGE);
            CODEC = StringIdentifiable.createCodec(ButterflyEntity.ButterflyType::values);
        }
    }

    class ButterflyWanderAroundGoal extends Goal {
        private final ButterflyEntity butterfly;

        public ButterflyWanderAroundGoal(ButterflyEntity butterfly) {
            this.butterfly = butterfly;
        }

        @Override
        public boolean canStart() {
            return this.butterfly.getNavigation().isIdle();
        }

        @Override
        public void start() {
            Vec3d loc = this.getRandomLocation();
            if(loc != null)
                this.butterfly.getNavigation().startMovingAlong(this.butterfly.getNavigation().findPathTo(BlockPos.ofFloored(loc), 1), 1.1);
        }

        @Override
        public boolean shouldContinue() {
            return this.butterfly.getNavigation().isFollowingPath();
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d butterflyPos = this.butterfly.getPos();

            Vec3d vec3d3 = AboveGroundTargeting.find(this.butterfly, 15, 10, butterflyPos.x, butterflyPos.z, 1.5707964f, 5, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }
            return NoPenaltySolidTargeting.find(this.butterfly, 15, 10, -2, butterflyPos.x, butterflyPos.z, 1.5707963705062866);
        }
    }
}
