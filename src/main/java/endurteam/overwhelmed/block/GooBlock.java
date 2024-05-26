package endurteam.overwhelmed.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GooBlock extends TransparentBlock {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 14.0, 14.0, 14.0);

    public GooBlock(Settings settings) {
        super(settings);
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public static void addRegularParticles(Entity entity) {
        addParticles(entity, 5);
    }

    public static void addRichParticles(Entity entity) {
        addParticles(entity, 10);
    }

    private static void addParticles(Entity entity, int count) {
        if (entity.getWorld().isClient) {
            BlockState blockState = OverwhelmedBlocks.GOO_BLOCK.getDefaultState();

            for(int i = 0; i < count; ++i) {
                entity.getWorld().addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, blockState), entity.getX(), entity.getY(), entity.getZ(), 0.0, 0.0, 0.0);
            }

        }
    }

}