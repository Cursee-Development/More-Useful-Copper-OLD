package net.jason13.moreusefulcopper.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class GolemAnimationsRE {
	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(4f).looping()
		.addAnimation("body",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 2.5f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 0f, -2.5f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("legRight",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(3f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("legLeft",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(3f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("armRight",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(3f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("armLeft",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(-10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(2f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(3f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
	
	public static final AnimationDefinition ATTACK = AnimationDefinition.Builder.withLength(1f).looping()
		.addAnimation("armRight",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.5f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.75f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR)))
		.addAnimation("armLeft",
			new AnimationChannel(AnimationChannel.Targets.ROTATION,
				new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.5f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(0.75f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR),
				new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
					AnimationChannel.Interpolations.LINEAR))).build();
}