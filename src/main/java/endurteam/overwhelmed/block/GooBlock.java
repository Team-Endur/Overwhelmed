package endurteam.overwhelmed.block;

import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GooBlock extends TransparentBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 14.0, 14.0, 14.0);

    public GooBlock(Settings settings) {
        super(settings);
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            double distance = player.squaredDistanceTo(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F);
            double threshold = 1.0F * 1.0F;
            if (distance <= threshold && (player.getY() - pos.getY()) > 0.1) {
                world.playSound(null, pos, OverwhelmedSounds.GOO_BLOCK_DRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

}