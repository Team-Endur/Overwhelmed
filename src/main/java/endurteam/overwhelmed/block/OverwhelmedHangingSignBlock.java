package endurteam.overwhelmed.block;

import endurteam.overwhelmed.block.entity.OverwhelmedHangingSignBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class OverwhelmedHangingSignBlock extends HangingSignBlock {

    public OverwhelmedHangingSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OverwhelmedHangingSignBlockEntity(pos, state);
    }
}
