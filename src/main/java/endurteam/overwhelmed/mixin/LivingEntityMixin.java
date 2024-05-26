package endurteam.overwhelmed.mixin;

import endurteam.overwhelmed.block.OverwhelmedBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	@Shadow
	private Optional<BlockPos> climbingPos;

	private long lastClimbingSoundTime = 0; // Track the last time the sound was played

	protected LivingEntityMixin(EntityType<?> entityType, World world) {
		super(entityType, world);
	}

	@Inject(method = "isClimbing", at = @At("TAIL"), cancellable = true)
	private void onClimableMixin(CallbackInfoReturnable<Boolean> cir) {
		BlockPos blockPos = this.getBlockPos();
		World world = this.getWorld();
		long currentTime = System.currentTimeMillis();
		for (Direction direction : Direction.Type.HORIZONTAL) {
			BlockPos offsetPos = blockPos.offset(direction);
			BlockState state = world.getBlockState(offsetPos);
			if (state.isOf(OverwhelmedBlocks.GOO_BLOCK)) {
				this.climbingPos = Optional.of(offsetPos);
				cir.setReturnValue(true);
				if (currentTime - lastClimbingSoundTime > 500 && (this.getVelocity().y > 0 || this.getVelocity().y < 0)) {
					world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					lastClimbingSoundTime = currentTime;
				}
				return;
			}
		}
		cir.setReturnValue(cir.getReturnValue());
	}
}
