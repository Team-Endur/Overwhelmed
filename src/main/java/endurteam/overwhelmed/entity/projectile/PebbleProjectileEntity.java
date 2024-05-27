package endurteam.overwhelmed.entity.projectile;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.entity.OverwhelmedEntities;
import endurteam.overwhelmed.entity.damage.OverwhelmedDamageTypes;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class PebbleProjectileEntity extends ThrownItemEntity {

    private int touchWater;

    public PebbleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
        this.touchWater = new Random().nextInt(4) + 1;
    }

    public PebbleProjectileEntity(LivingEntity livingEntity, World world) {
        super(OverwhelmedEntities.PEBBLE_PROJECTILE, livingEntity, world);
        this.touchWater = new Random().nextInt(4) + 1;
    }

    @Override
    protected Item getDefaultItem() {
        return OverwhelmedItems.PEBBLE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().setBlockState(getBlockPos(), OverwhelmedBlocks.PEBBLE.getDefaultState(), 3);
        }

        this.kill();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        if (entity instanceof LivingEntity) {
            DamageSource damageSource = new DamageSource(
                    entity.getRegistryManager()
                            .get(RegistryKeys.DAMAGE_TYPE)
                            .entryOf(OverwhelmedDamageTypes.PEBBLE));
            entity.damage(damageSource, 1.0f);
        }
        this.kill();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.touchWater < 5) {
            BlockPos blockPos = this.getBlockPos();
            if (this.getWorld().getBlockState(blockPos).isOf(Blocks.WATER)) {
                this.bounce();
                this.touchWater += 1;
            }
        }
    }

    private void bounce() {
        this.setVelocity(this.getVelocity().x, -this.getVelocity().y, this.getVelocity().z);
        this.setVelocity(this.getVelocity().multiply(1.0, 0.9, 1.0));
    }

}
