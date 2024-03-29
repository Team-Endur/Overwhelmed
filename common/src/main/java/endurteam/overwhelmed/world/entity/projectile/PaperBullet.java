/**
 *  Overwhelmed, a Minecraft overhauling and adding new features to the Overworld's surface!<br>
 *  Copyright (C) 2023-2024 Endurteam<br>
 *  <br>
 *  This program is free software: you can redistribute it and/or modify<br>
 *  it under the terms of the GNU General Public License as published by<br>
 *  the Free Software Foundation, either version 3 of the License, or<br>
 *  any later version.<br>
 *  <br>
 *  This program is distributed in the hope that it will be useful,<br>
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of<br>
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the<br>
 *  GNU General Public License for more details.<br>
 *  <br>
 *  You should have received a copy of the GNU General Public License with<br>
 *  the Minecraft Linking Exception<br>
 *  along with this program.  If not, see <https://www.gnu.org/licenses/> and<br>
 *  <https://gist.github.com/triphora/588f353802a3b0ea649e4fc85f75e583/>
 */

package endurteam.overwhelmed.world.entity.projectile;

import endurteam.overwhelmed.world.entity.OverwhelmedEntityTypes;
import endurteam.overwhelmed.world.item.OverwhelmedItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class PaperBullet
        extends ThrowableItemProjectile {
    public AnimationState flyAnimationState = new AnimationState();

    public PaperBullet(EntityType<? extends PaperBullet> entityType, Level level) {
        super(entityType, level);
    }

    public PaperBullet(Level level, LivingEntity livingEntity) {
        super(OverwhelmedEntityTypes.PAPER_BULLET, livingEntity, level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return OverwhelmedItems.PAPER_BULLET;
    }

    private ParticleOptions getParticle() {
        return new ItemParticleOption(ParticleTypes.ITEM, OverwhelmedItems.PAPER_BULLET.getDefaultInstance());
    }

    @Override
    public void handleEntityEvent(byte b) {
        if (b == 3) {
            ParticleOptions particleOptions = this.getParticle();
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(particleOptions, this.getX(), this.getY(), this.getZ(),
                        0.0, 0.0, 0.0);
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        boolean bl = entity.hurt(this.damageSources().thrown(this, this.getOwner()), 0);
        if (bl) {
            if (entity instanceof LivingEntity livingEntity2) {
                livingEntity2.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0), this);
            }
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public void shoot(double d, double e, double f, float g, float h) {
        super.shoot(d, e, f, g, h);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide())
        {
            this.flyAnimationState.startIfStopped(this.tickCount);
        }
    }
}
