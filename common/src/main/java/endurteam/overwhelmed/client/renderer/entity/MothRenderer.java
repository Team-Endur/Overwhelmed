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

package endurteam.overwhelmed.client.renderer.entity;

import endurteam.overwhelmed.Overwhelmed;
import endurteam.overwhelmed.client.model.entity.MothModel;
import endurteam.overwhelmed.client.model.entity.SnailLimestoneModel;
import endurteam.overwhelmed.client.model.geom.OverwhelmedModelLayers;
import endurteam.overwhelmed.world.entity.animal.Moth;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Environment(EnvType.CLIENT)
public class MothRenderer extends MobRenderer<Moth, MothModel<Moth>> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Overwhelmed.MOD_ID, "textures/entity/moth.png");

    public MothRenderer(EntityRendererProvider.Context context) {
        super(context, new MothModel<>(context.bakeLayer(OverwhelmedModelLayers.MOTH_MODEL_LAYER)), 0.2f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(Moth entity) {
        return TEXTURE;
    }
}
