package endurteam.overwhelmed.item;

import endurteam.overwhelmed.sound.OverwhelmedSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PebbleBlockItem extends BlockItem {

    public PebbleBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player,
                                                           InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                OverwhelmedSoundEvents.PEBBLE_THROW, SoundSource.NEUTRAL, 0.5f,
                0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f));
        player.getCooldowns().addCooldown(this, 20);
        if (!level.isClientSide) {
            Pebble pebble = new Pebble(level, player);
            pebble.setItem(itemStack);
            pebble.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 1.0f);
            level.addFreshEntity(pebble);
        }
        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}