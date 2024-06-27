package endurteam.overwhelmed.worldgen;

import endurteam.overwhelmed.Overwhelmed;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class OverwhelmedBiomeTags {
    public static final TagKey<Biome> ORE_ALTAIR = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "ore_altair"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_CABBAGE = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_cabbage"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_CHERRY = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_cherry"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_FUR = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_fur"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_LIVERWORT = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_liverwort"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_MONARCH = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_monarch"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_MORPHO = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_morpho"));
    public static final TagKey<Biome> SPAWNS_BUTTERFLY_SLEEPY = TagKey.of(RegistryKeys.BIOME, new Identifier(Overwhelmed.MOD_ID, "spawn_butterfly_sleepy"));
}
