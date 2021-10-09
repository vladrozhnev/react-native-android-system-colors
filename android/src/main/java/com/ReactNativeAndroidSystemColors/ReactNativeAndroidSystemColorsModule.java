package com.ReactNativeAndroidSystemColors;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.view.WindowManager;

import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;

import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name = ReactNativeAndroidSystemColorsModule.NAME)
public class ReactNativeAndroidSystemColorsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "ReactNativeAndroidSystemColors";

    public ReactNativeAndroidSystemColorsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @ReactMethod(isBlockingSynchronousMethod = true)
    public void setNavigationBarColor(final String hex, final int duration) {
        final Activity activity = getCurrentActivity();
        final int color = Color.parseColor(hex);

        if (activity == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        UiThreadUtil.runOnUiThread(
            new GuardedRunnable(getReactApplicationContext()) {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void runGuarded() {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                    if (duration != 0) {
                        int current = activity.getWindow().getNavigationBarColor();
                        ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), current, color);

                        animator.addUpdateListener(
                            new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator animator) {
                                    activity.getWindow().setNavigationBarColor((Integer) animator.getAnimatedValue());
                                }
                            }
                        );

                        animator.setDuration((Integer) duration).setStartDelay(0);
                        animator.start();
                    } else {
                        activity.getWindow().setNavigationBarColor(color);
                    }
                }
            }
        );
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @ReactMethod(isBlockingSynchronousMethod = true)
    public void setStatusBarColor(final String hex, final int duration) {
        final Activity activity = getCurrentActivity();
        final int color = Color.parseColor(hex);

        if (activity == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        UiThreadUtil.runOnUiThread(
            new GuardedRunnable(getReactApplicationContext()) {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void runGuarded() {
                    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                    if (duration != 0) {
                        int current = activity.getWindow().getStatusBarColor();
                        ValueAnimator animator = ValueAnimator.ofObject(new ArgbEvaluator(), current, color);

                        animator.addUpdateListener(
                            new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator animator) {
                                    activity.getWindow().setStatusBarColor((Integer) animator.getAnimatedValue());
                                }
                            }
                        );

                        animator.setDuration((Integer) duration).setStartDelay(0);
                        animator.start();
                    } else {
                        activity.getWindow().setStatusBarColor(color);
                    }
                }
            }
        );
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @ReactMethod(isBlockingSynchronousMethod = true)
    public void setTaskDescriptionColor(final String hex) {
        final Activity activity = getCurrentActivity();

        if (activity == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        final Context context = getReactApplicationContext();
        final String name = context.getString(context.getApplicationInfo().labelRes);
        final Bitmap icon = BitmapFactory.decodeResource(activity.getResources(), context.getApplicationInfo().icon);
        final int color = Color.parseColor(hex);

        TaskDescription taskDescription = new TaskDescription(name, icon, color);
        ((Activity) activity).setTaskDescription(taskDescription);
    }
}
