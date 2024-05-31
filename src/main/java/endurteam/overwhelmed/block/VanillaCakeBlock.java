package endurteam.overwhelmed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class VanillaCakeBlock extends Block {
    public static final MapCodec<endurteam.overwhelmed.block.VanillaCakeBlock> CODEC =
            createCodec(endurteam.overwhelmed.block.VanillaCakeBlock::new);
    public static final int MAX_BITES = 5;
    public static final IntProperty BITES;
    public static final int DEFAULT_COMPARATOR_OUTPUT;
    protected static final float field_31047 = 1.0F;
    protected static final float field_31048 = 2.0F;
    protected static final VoxelShape[] BITES_TO_SHAPE;

    public MapCodec<endurteam.overwhelmed.block.VanillaCakeBlock> getCodec() {
        return CODEC;
    }

    public VanillaCakeBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer)state.get(BITES)];
    }

    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CANDLES) && (Integer)state.get(BITES) == 0) {
            Block var10 = Block.getBlockFromItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock)var10;
                if (!player.isCreative()) {
                    stack.decrement(1);
                }

                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, CandleCakeBlock.getCandleCakeFromCandle(candleBlock));
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ItemActionResult.SUCCESS;
            }
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        return tryEat(world, pos, state, player);
    }

    protected ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        int bites = state.get(BITES);
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else if (bites < MAX_BITES) {
            world.setBlockState(pos, state.with(BITES, bites + 1), 3);
        } else {
            world.removeBlock(pos, false);
            world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        player.incrementStat(Stats.EAT_CAKE_SLICE);
        player.getHungerManager().add(2, 0.1F);
        world.emitGameEvent(player, GameEvent.EAT, pos);
        return ActionResult.SUCCESS;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                   WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() :
                super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BITES});
    }

    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return getComparatorOutput((Integer)state.get(BITES));
    }

    public static int getComparatorOutput(int bites) {
        return (MAX_BITES - bites) * 2;
    }

    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

    static {
        BITES = Properties.BITES;
        DEFAULT_COMPARATOR_OUTPUT = getComparatorOutput(0);
        BITES_TO_SHAPE = new VoxelShape[]{
                Block.createCuboidShape(2.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F),
                Block.createCuboidShape(4.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F),
                Block.createCuboidShape(6.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F),
                Block.createCuboidShape(8.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F),
                Block.createCuboidShape(10.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F),
                Block.createCuboidShape(12.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F),
                Block.createCuboidShape(14.0F, 0.0F, 2.0F, 14.0F, 12.0F, 14.0F)
        };
    }
}