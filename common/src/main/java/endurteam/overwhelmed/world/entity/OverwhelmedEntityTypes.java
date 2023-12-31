/**
 *  Overwhelmed, a Minecraft overhauling and adding new features to the Overworld's surface!<br>
 *  Copyright (C) 2023  Endurteam<br>
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

package endurteam.overwhelmed.world.entity;

import endurteam.overwhelmed.world.entity.animal.ButterflyEntity;
import endurteam.overwhelmed.world.entity.projectile.PaperBulletEntity;
import endurteam.overwhelmed.world.entity.projectile.PebbleEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import endurteam.overwhelmed.world.entity.animal.SnailEntity;

import static endurteam.overwhelmed.Overwhelmed.MOD_ID;

public class OverwhelmedEntityTypes {
    public static EntityType<SnailEntity> FLAT_SNAIL;
    public static EntityType<SnailEntity> GARDEN_SNAIL;
    public static EntityType<SnailEntity> GARY_SNAIL;
    public static EntityType<SnailEntity> GLASS_SNAIL;
    public static EntityType<SnailEntity> LIMESTONE_SNAIL;
    public static EntityType<SnailEntity> LIVERWORT_SNAIL;
    public static EntityType<SnailEntity> ROMAN_SNAIL;

    public static EntityType<ButterflyEntity> CABBAGE_BUTTERFLY;
    public static EntityType<ButterflyEntity> CHERRY_BUTTERFLY;
    public static EntityType<ButterflyEntity> LIVERWORT_BUTTERFLY;
    public static EntityType<ButterflyEntity> MONARCH_BUTTERFLY;
    public static EntityType<ButterflyEntity> MORPHO_BUTTERFLY;
    public static EntityType<ButterflyEntity> SLEEPY_BUTTERFLY;

    public static EntityType<PaperBulletEntity> PAPER_BULLET;
    public static EntityType<PebbleEntity> PEBBLE;

    public static final TagKey<Biome> SPAWNS_FLAT_SNAILS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_flat_snails"));
    public static final TagKey<Biome> SPAWNS_GARDEN_SNAILS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_garden_snails"));
    public static final TagKey<Biome> SPAWNS_GLASS_SNAILS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_glass_snails"));
    public static final TagKey<Biome> SPAWNS_LIMESTONE_SNAILS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_limestone_snails"));
    public static final TagKey<Biome> SPAWNS_LIVERWORT_SNAILS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_liverwort_snails"));
    public static final TagKey<Biome> SPAWNS_ROMAN_SNAILS = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_roman_snails"));

    public static final TagKey<Biome> SPAWNS_CABBAGE_BUTTERFLIES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_cabbage_butterflies"));
    public static final TagKey<Biome> SPAWNS_CHERRY_BUTTERFLIES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_cherry_butterflies"));
    public static final TagKey<Biome> SPAWNS_LIVERWORT_BUTTERFLIES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_liverwort_butterflies"));
    public static final TagKey<Biome> SPAWNS_MONARCH_BUTTERFLIES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_monarch_butterflies"));
    public static final TagKey<Biome> SPAWNS_MORPHO_BUTTERFLIES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_morpho_butterflies"));
    public static final TagKey<Biome> SPAWNS_SLEEPY_BUTTERFLIES = TagKey.create(Registries.BIOME,
            new ResourceLocation(MOD_ID, "spawns_sleepy_butterflies"));
}
