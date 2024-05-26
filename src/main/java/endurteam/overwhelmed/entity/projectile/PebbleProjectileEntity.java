package endurteam.overwhelmed.entity.projectile;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import endurteam.overwhelmed.entity.OverwhelmedEntities;
import endurteam.overwhelmed.item.OverwhelmedItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class PebbleProjectileEntity extends ThrownItemEntity {
    public PebbleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public PebbleProjectileEntity(LivingEntity livingEntity, World world) {
        super(OverwhelmedEntities.PEBBLE_PROJECTILE, livingEntity, world);
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

        this.discard();
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
    }
}
