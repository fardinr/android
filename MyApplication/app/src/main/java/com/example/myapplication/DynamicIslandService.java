package com.example.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

public final class DynamicIslandService extends AccessibilityService {
    public View floatingView;
    private final EventBus eventBus = EventBus.getDefault();
    public WindowManager windowManager;
    public WindowManager.LayoutParams params;
    private int y;
    private int x;

    @NotNull
    public final View getFloatingView() {
        View var10000 = this.floatingView;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        }

        return var10000;
    }

    public final void setFloatingView(@NotNull View var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.floatingView = var1;
    }

    public final EventBus getEventBus() {
        return this.eventBus;
    }

    @NotNull
    public final WindowManager getWindowManager() {
        WindowManager var10000 = this.windowManager;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        }

        return var10000;
    }

    public final void setWindowManager(@NotNull WindowManager var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.windowManager = var1;
    }

    @NotNull
    public final WindowManager.LayoutParams getParam() {
        WindowManager.LayoutParams var10000 = this.params;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }

        return var10000;
    }

    public final void setParams(@NotNull WindowManager.LayoutParams var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.params = var1;
    }

    public final int getY() {
        return this.y;
    }

    public final void setY(int var1) {
        this.y = var1;
    }

    public final int getX() {
        return this.x;
    }

    public final void setX(int var1) {
        this.x = var1;
    }

    public void onAccessibilityEvent(@Nullable AccessibilityEvent p0) {
    }

    public void onInterrupt() {
    }

    public void onCreate() {
        super.onCreate();
        this.eventBus.register(this);
        SharedPreferences preferences = this.getSharedPreferences("MY_DATA", 0);
        this.y = preferences.getInt("Y_KEY", 0);
        this.x = preferences.getInt("X_KEY", 0);
    }

    protected void onServiceConnected() {
        super.onServiceConnected();
        this.showTheIsland();
    }

    private final void showTheIsland() {
        View var10001 = LayoutInflater.from((Context)this).inflate(R.layout.view_dynamic_island, (ViewGroup)null);
        Intrinsics.checkNotNullExpressionValue(var10001, "LayoutInflater.from(this…iew_dynamic_island, null)");
        this.floatingView = var10001;
        this.params = new WindowManager.LayoutParams(-2, -2, 2032, 520, -3);
        WindowManager.LayoutParams var10000 = this.params;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }

        var10000.x = this.x;
        var10000 = this.params;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }

        var10000.y = this.y;
        Object var5 = this.getSystemService(Context.WINDOW_SERVICE);
        if (var5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        } else {
            this.windowManager = (WindowManager)var5;
            WindowManager var3 = this.windowManager;
            if (var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            }

            var10001 = this.floatingView;
            if (var10001 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            }

            WindowManager.LayoutParams var10002 = this.params;
            if (var10002 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("params");
            }

            var3.addView(var10001, (android.view.ViewGroup.LayoutParams)var10002);
            View var4 = this.floatingView;
            if (var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            }

            ImageView open = (ImageView)var4.findViewById(R.id.imageView_open);
            var4 = this.floatingView;
            if (var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            }

            ImageView notification = (ImageView)var4.findViewById(R.id.imageView_notification);
            open.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
                public final void onClick(View it) {
                    Toast.makeText(DynamicIslandService.this.getApplicationContext(), (CharSequence)"Open", Toast.LENGTH_SHORT).show();
                }
            }));
        }
    }

    @Subscribe(
            threadMode = ThreadMode.MAIN
    )
    public final void onEvent(@NotNull EventPositionChanged event) {
        Intrinsics.checkNotNullParameter(event, "event");
        WindowManager.LayoutParams var10000 = this.params;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }

        var10000.y = event.getY();
        var10000 = this.params;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }

        var10000.x = event.getX();
        WindowManager var2 = this.windowManager;
        if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        }

        View var10001 = this.floatingView;
        if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        }

        WindowManager.LayoutParams var10002 = this.params;
        if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
        }

        var2.updateViewLayout(var10001, (android.view.ViewGroup.LayoutParams)var10002);
    }
}
