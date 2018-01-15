package com.wz.pack.weight;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.wz.pack.R;

/**
 * Created by wang_zhen1 on 2018/1/15 0015.
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    private static final android.view.animation.Interpolator INTERPOLATOR =
            new FastOutSlowInInterpolator();
    private boolean mIsAnimatingOut = false;

    private void animateOut(final FloatingActionButton button) {
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(button).scaleX(0.0F).scaleY(0.0F).alpha(0.0F)
                    .setInterpolator(INTERPOLATOR).withLayer()
                    .setListener(new ViewPropertyAnimatorListener() {
                        @Override
                        public void onAnimationStart(View view) {
                            ScrollAwareFABBehavior.this.mIsAnimatingOut = true;
                        }
                        @Override
                        public void onAnimationCancel(View view) {
                            ScrollAwareFABBehavior.this.mIsAnimatingOut = false;
                        }
                        @Override
                        public void onAnimationEnd(View view) {
                            ScrollAwareFABBehavior.this.mIsAnimatingOut = false;
                            view.setVisibility(View.GONE);
                        }
                    }).start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(button.getContext(), R.anim.fab_out);
            anim.setInterpolator(INTERPOLATOR);
            anim.setDuration(200L);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    ScrollAwareFABBehavior.this.mIsAnimatingOut = true;
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    ScrollAwareFABBehavior.this.mIsAnimatingOut = false;
                    button.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(final Animation animation) {
                }
            });
            button.startAnimation(anim);
        }
    }

    private void animateIn(FloatingActionButton button) {
        button.setVisibility(View.VISIBLE);
        if (Build.VERSION.SDK_INT >= 14) {
            ViewCompat.animate(button).scaleX(1.0F).scaleY(1.0F).alpha(1.0F)
                    .setInterpolator(INTERPOLATOR).withLayer().setListener(null)
                    .start();
        } else {
            Animation anim = AnimationUtils.loadAnimation(button.getContext(), R.anim.fab_in);
            anim.setDuration(200L);
            anim.setInterpolator(INTERPOLATOR);
            button.startAnimation(anim);
        }
    }
}