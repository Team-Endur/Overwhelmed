package endurteam.overwhelmed.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class OverwhelmedHangingSignBlockEntity extends SignBlockEntity {
    public OverwhelmedHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return OverwhelmedBlockEntities.HANGING_SIGN_BLOCK_ENTITY;
    }
}
