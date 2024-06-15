package endurteam.overwhelmed.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class OverwhelmedSignBlockEntity extends SignBlockEntity {
    public OverwhelmedSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return OverwhelmedBlockEntities.SIGN_BLOCK_ENTITY;
    }
}
