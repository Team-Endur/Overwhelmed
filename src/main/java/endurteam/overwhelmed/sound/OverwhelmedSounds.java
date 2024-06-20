package endurteam.overwhelmed.sound;

import endurteam.overwhelmed.Overwhelmed;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class OverwhelmedSounds {

    public static final SoundEvent GOO_BLOCK_BREAK = registerSoundEvent("block.goo_block.break");
    public static final SoundEvent GOO_BLOCK_STEP = registerSoundEvent("block.goo_block.step");
    public static final SoundEvent GOO_BLOCK_PLACE = registerSoundEvent("block.goo_block.place");
    public static final SoundEvent GOO_BLOCK_HIT = registerSoundEvent("block.goo_block.hit");
    public static final SoundEvent GOO_BLOCK_FALL = registerSoundEvent("block.goo_block.fall");

    public static final SoundEvent ENTITY_PEBBLE_THROW = registerSoundEvent("entity.pebble.throw");
    public static final SoundEvent ENTITY_SNAIL_HURT = registerSoundEvent("entity.snail.hurt");
    public static final SoundEvent ENTITY_SNAIL_DEATH = registerSoundEvent("entity.snail.death");

    public static final BlockSoundGroup GOO_BLOCK =
            new BlockSoundGroup(1.0F, 1.0F,
                    GOO_BLOCK_BREAK, GOO_BLOCK_STEP, GOO_BLOCK_PLACE, GOO_BLOCK_HIT, GOO_BLOCK_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Overwhelmed.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {}

}