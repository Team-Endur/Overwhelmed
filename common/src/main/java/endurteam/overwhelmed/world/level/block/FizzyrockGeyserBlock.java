package endurteam.overwhelmed.world.level.block;

import endurteam.overwhelmed.core.particles.OverwhelmedParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class FizzyrockGeyserBlock extends Block {

    public FizzyrockGeyserBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        VoxelShape voxelShape = this.getShape(blockState, level, blockPos, CollisionContext.empty());
        Vec3 vec3 = voxelShape.bounds().getCenter();
        double d = (double)blockPos.getX() + vec3.x;
        double e = (double)blockPos.getZ() + vec3.z;

         int spawnDelay = 20 / 2;

        for (int i = 0; i < 2; ++i) {
            if (level.getGameTime() % spawnDelay == 0) {
                for (i = 0; i < 2; ++i) {
                    if (randomSource.nextBoolean()) {
                        double yOffset = (double) blockPos.getY() + 1.25 + (0.5 - randomSource.nextDouble());
                        level.addParticle((ParticleOptions) OverwhelmedParticleTypes.FIZZY_BUBBLE,
                                d + randomSource.nextDouble() / 5.0,
                                yOffset,
                                e + randomSource.nextDouble() / 5.0,
                                0.0, 0.0, 0.0);
                    }
                }
            }
        }
    }


    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(4.0f, 0.0f, 4.0f, 12.0f, 16.0f, 12.0f);
    }

}
