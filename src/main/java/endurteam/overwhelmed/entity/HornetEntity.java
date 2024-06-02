package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.datagen.OverwhelmedEntityTypeTagProvider;
import endurteam.overwhelmed.datagen.OverwhelmedItemTagProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.AboveGroundTargeting;
import net.minecraft.entity.ai.NoPenaltySolidTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class HornetEntity extends AnimalEntity implements Angerable, Flutterer {

    private boolean angryAtPlayer;
    private boolean hiveTooFar;
    private boolean playerTooFar;
    private BlockPos spawnPos;

    protected HornetEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new StingGoal(this, 1.399999976158142, true));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(2, new TemptGoal(this, 1.25, (stack) -> {
            return stack.isIn(OverwhelmedItemTagProvider.HORNET_FOOD);
        }, false));
        this.goalSelector.add(3, new HornetWanderAroundGoal(this, spawnPos));
        this.goalSelector.add(4, new SwimGoal(this));
//        this.targetSelector.add(1, (new BeeRevengeGoal(this)).setGroupRevenge(new Class[0]));
//        this.targetSelector.add(2, new StingTargetGoal(this));
        this.targetSelector.add(3, new UniversalAngerGoal(this, true));
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
    public boolean isInAir() {
        return false;
    }

    @Override
    public int getAngerTime() {
        return 0;
    }

    @Override
    public void setAngerTime(int angerTime) {

    }

    @Nullable
    @Override
    public UUID getAngryAt() {
        return null;
    }

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {

    }

    class StingGoal extends MeleeAttackGoal {
        StingGoal(final PathAwareEntity mob, final double speed, final boolean pauseWhenMobIdle) {
            super(mob, speed, pauseWhenMobIdle);
        }

        public boolean canStart() {
            return super.canStart() && HornetEntity.this.hasAngerTime();
        }

        public boolean shouldContinue() {
            return super.shouldContinue() && HornetEntity.this.hasAngerTime();
        }
    }

    class HornetWanderAroundGoal extends Goal {
        private static final int MAX_DISTANCE = 22;
        private final BlockPos spawnPos;
        private final double safeZoneDistance = 50;
        private final HornetEntity hornetEntity;

        HornetWanderAroundGoal(HornetEntity hornetEntity, BlockPos spawnPos) {
            this.hornetEntity = Objects.requireNonNull(hornetEntity);
            this.spawnPos = Objects.requireNonNull(spawnPos);
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            double distanceToSpawn = hornetEntity.getPos().distanceTo(Vec3d.ofCenter(spawnPos));
            return distanceToSpawn <= safeZoneDistance && hornetEntity.getNavigation().isIdle() && hornetEntity.getRandom().nextInt(10) == 0;
        }

        public boolean shouldContinue() {
            double distanceToSpawn = hornetEntity.getPos().distanceTo(Vec3d.ofCenter(spawnPos));
            return distanceToSpawn <= safeZoneDistance && hornetEntity.getNavigation().isFollowingPath();
        }

        public void start() {
            Vec3d targetPosition = this.getRandomLocation();
            if (targetPosition != null) {
                hornetEntity.getNavigation().startMovingAlong(hornetEntity.getNavigation().findPathTo(BlockPos.ofFloored(targetPosition), 1), 1.0);
            }
        }

        @Nullable
        private Vec3d getRandomLocation() {
            Vec3d targetVector;
            double distanceToSpawn = hornetEntity.getPos().distanceTo(Vec3d.ofCenter(spawnPos));
            if (distanceToSpawn > safeZoneDistance) {
                targetVector = Vec3d.ofCenter(spawnPos).subtract(hornetEntity.getPos()).normalize();
            } else {
                targetVector = hornetEntity.getRotationVec(0.0F);
            }

            Vec3d targetPosition = AboveGroundTargeting.find(hornetEntity, 8, 7, targetVector.x, targetVector.z, 1.5707964F, 3, 1);
            return targetPosition != null ? targetPosition : NoPenaltySolidTargeting.find(hornetEntity, 8, 4, -2, targetVector.x, targetVector.z, 1.5707963705062866);
        }
    }



    @Override
    public void chooseRandomAngerTime() {

    }
}
