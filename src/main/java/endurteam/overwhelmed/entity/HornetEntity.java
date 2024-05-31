package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.datagen.OverwhelmedEntityTypeTagProvider;
import endurteam.overwhelmed.datagen.OverwhelmedItemTagProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.LivingEntity;
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

    public HornetEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new TemptGoal(this, 1.25, (stack) -> {
            return stack.isIn(OverwhelmedItemTagProvider.HORNET_FOOD);
        }, false));

        this.goalSelector.add(2, new ReturnToHiveGoal(this, 1.0));

        this.targetSelector.add(1, (new HornerRevengeGoal(this)).setGroupRevenge(new Class[0]));
        this.targetSelector.add(2, new UniversalAngerGoal(this, true));
        this.targetSelector.add(3, new UniversalAngerGoal(this, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, BeeEntity.class, true));
//        this.targetSelector.add(5, new ActiveTargetGoal(this, SnailEntity.class, true));
        this.targetSelector.add(5, new ActiveTargetGoal(this, RabbitEntity.class, true));
        this.targetSelector.add(6, new ActiveTargetGoal(this, SpiderEntity.class, true));
        this.targetSelector.add(7, new ActiveTargetGoal(this, CaveSpiderEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createHornetAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 12)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(OverwhelmedItemTagProvider.HORNET_FOOD);
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

    public void setSpawnPos(BlockPos pos) {
        this.spawnPos = pos;
    }

    @Override
    public void tick() {
        super.tick();
        if (spawnPos != null) {
            double dx = this.getX() - spawnPos.getX();
            double dy = this.getY() - spawnPos.getY();
            double dz = this.getZ() - spawnPos.getZ();
            double distanceSq = dx * dx + dy * dy + dz * dz;
            hiveTooFar = distanceSq >= 50 * 50;
        }

        PlayerEntity nearestPlayer = this.getWorld().getClosestPlayer(this, 25);
        if (nearestPlayer != null) {
            Vec3d playerPos = nearestPlayer.getPos();
            double dxPlayer = this.getX() - playerPos.x;
            double dyPlayer = this.getY() - playerPos.y;
            double dzPlayer = this.getZ() - playerPos.z;
            double distanceSqPlayer = dxPlayer * dxPlayer + dyPlayer * dyPlayer + dzPlayer * dzPlayer;
            playerTooFar = distanceSqPlayer >= 25 * 25;
        }

    }

    @Override
    public void chooseRandomAngerTime() {}

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity) {
            this.angryAtPlayer = true;
        }
        return super.damage(source, amount);
    }

    class ReturnToHiveGoal extends Goal {
        private final HornetEntity hornet;
        private final double speed;

        public ReturnToHiveGoal(HornetEntity hornet, double speed) {
            this.hornet = hornet;
            this.speed = speed;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            return hornet.hiveTooFar && hornet.spawnPos != null;
        }

        @Override
        public void start() {
            hornet.getNavigation().startMovingTo(
                    hornet.spawnPos.getX() + 0.5,
                    hornet.spawnPos.getY() + 0.5,
                    hornet.spawnPos.getZ() + 0.5,
                    speed
            );
        }

        @Override
        public boolean shouldContinue() {
            return hornet.hiveTooFar && !hornet.getNavigation().isIdle();
        }

        @Override
        public void stop() {
            hornet.getNavigation().stop();
        }
    }

    class HornerRevengeGoal extends RevengeGoal {

        public HornerRevengeGoal(PathAwareEntity mob, Class<?>... noRevengeTypes) {
            super(mob, noRevengeTypes);
        }

        public boolean shouldContinue() {
            return HornetEntity.this.hasAngerTime() && !playerTooFar && super.shouldContinue();
        }

        protected void setMobEntityTarget(MobEntity mob, LivingEntity target) {
            if (mob instanceof HornetEntity && this.mob.canSee(target)) {
                mob.setTarget(target);
            }
        }
    }

    class StingTargetGoal extends ActiveTargetGoal<PlayerEntity> {

        public StingTargetGoal(MobEntity mob, Class<PlayerEntity> targetClass, boolean checkVisibility) {
            super(mob, targetClass, checkVisibility);
        }

        public boolean canStart() {
            HornetEntity hornetEntity = (HornetEntity) this.mob;
            return hornetEntity.hasAngerTime() && super.canStart();
        }

        public boolean shouldContinue() {
            HornetEntity hornetEntity = (HornetEntity) this.mob;
            if (hornetEntity.hasAngerTime() && this.mob.getTarget() != null) {
                return super.shouldContinue();
            } else {
                this.target = null;
                return false;
            }
        }
    }

}
