package endurteam.overwhelmed.item;

import endurteam.overwhelmed.sound.OverwhelmedSounds;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

public class CandyItem extends Item {
    public CandyItem(Settings settings) {
        super(settings);
    }

    public SoundEvent getEatSound() {
        return OverwhelmedSounds.ITEM_CANDY_EAT;
    }

}
