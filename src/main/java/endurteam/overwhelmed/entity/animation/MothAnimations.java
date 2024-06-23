package endurteam.overwhelmed.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class MothAnimations {
    public static final Animation FLYING = Animation.Builder.create(1.0F).looping()
            .addBoneAnimation("right_wing", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 45.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -44.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 45.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("left_wing", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -45.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 45.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -45.0F), Transformation.Interpolations.LINEAR)
            ))
            .build();
}
