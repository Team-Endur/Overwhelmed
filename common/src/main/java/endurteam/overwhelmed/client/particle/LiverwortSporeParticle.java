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

package endurteam.overwhelmed.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class LiverwortSporeParticle extends TextureSheetParticle {
    private final SpriteSet sprites;
    private float angularVelocity;
    private final float angularAcceleration;

    LiverwortSporeParticle(ClientLevel clientLevel, double d, double e, double f, double g, double h, double i,
                           SpriteSet spriteSet) {
        super(clientLevel, d, e, f, g, h, i);
        this.sprites = spriteSet;
        this.gravity = 0.2f;
        this.hasPhysics = true;
        this.xd = 0f;
        this.yd = 0f;
        this.zd = 0f;
        this.angularVelocity = 0.157f;
        this.angularAcceleration = 0f;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
        this.oRoll = this.roll;
        this.roll += this.angularVelocity;
        this.angularVelocity += this.angularAcceleration;
        if (!this.removed) {
            this.setSprite(this.sprites.get((this.age / 6) % 6 + 1, 6));
        }
    }


    @Environment(value=EnvType.CLIENT)
    public static class Provider
            implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double d, double e,
                                       double f, double g, double h, double i) {
            return new LiverwortSporeParticle(clientLevel, d, e, f, g, h, i, this.sprite);
        }
    }
}