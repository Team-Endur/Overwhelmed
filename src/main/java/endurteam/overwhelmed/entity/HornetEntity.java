package endurteam.overwhelmed.entity;

import endurteam.overwhelmed.datagen.OverwhelmedItemTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class HornetEntity extends AnimalEntity implements Angerable, Flutterer {

    private boolean angryAtPlayer;
    private boolean hiveTooFar;
    private boolean playerTooFar;
    private MoveToPreyGoal moveToPreyGoal;
    private BlockPos spawnPos;

    public HornetEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.moveToPreyGoal = new MoveToPreyGoal();
        this.goalSelector.add(1, this.moveToPreyGoal);
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

    public class MoveToPreyGoal extends Goal {
        @Override
        public boolean canStart() {
            return false;
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

}
