package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

public class CustomizeDIActivity extends AppCompatActivity {
    @NotNull
    private final EventBus eventBus;
    public SharedPreferences.Editor editor;
    public SeekBar seekBarY;
    public SeekBar seekBarX;

    @NotNull
    public final EventBus getEventBus() {
        return this.eventBus;
    }

    @NotNull
    public final SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor var10000 = this.editor;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editor");
        }

        return var10000;
    }

    public final void setEditor(@NotNull SharedPreferences.Editor var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.editor = var1;
    }

    @NotNull
    public final SeekBar getSeekBarY() {
        SeekBar var10000 = this.seekBarY;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
        }

        return var10000;
    }

    public final void setSeekBarY(@NotNull SeekBar var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.seekBarY = var1;
    }

    @NotNull
    public final SeekBar getSeekBarX() {
        SeekBar var10000 = this.seekBarX;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
        }

        return var10000;
    }

    public final void setSeekBarX(@NotNull SeekBar var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.seekBarX = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300002);
        View var10001 = this.findViewById(1000001);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.seekBar_y)");
        this.seekBarY = (SeekBar)var10001;
        var10001 = this.findViewById(1000000);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.seekBar_x)");
        this.seekBarX = (SeekBar)var10001;
        SharedPreferences.Editor var4 = this.getSharedPreferences("MY_DATA", 0).edit();
        Intrinsics.checkNotNullExpressionValue(var4, "getSharedPreferences(Con…ATA, MODE_PRIVATE).edit()");
        this.editor = var4;
        WindowManager var10000 = this.getWindowManager();
        Intrinsics.checkNotNullExpressionValue(var10000, "windowManager");
        Display var3 = var10000.getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(var3, "windowManager.defaultDisplay");
        Display display = var3;
        this.initY(display.getHeight());
        this.initX(display.getWidth());
    }

    private final void initX(int width) {
        SeekBar var10000 = this.seekBarX;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
        }

        var10000.setMax(width / 2);
        var10000 = this.seekBarX;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
        }

        var10000.setMin(-width / 2);
        var10000 = this.seekBarX;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
        }

        var10000.setProgress(0);
        var10000 = this.seekBarX;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
        }

        var10000.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                CustomizeDIActivity.this.getEventBus().post(new EventPositionChanged(CustomizeDIActivity.this.getSeekBarY().getProgress(), progress));
                CustomizeDIActivity.this.getEditor().putInt("X_KEY", progress).apply();
            }

            public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }
        }));
    }

    private final void initY(int height) {
        SeekBar var10000 = this.seekBarY;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
        }

        var10000.setMin(-height / 2 - 100);
        var10000 = this.seekBarY;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
        }

        var10000.setMax(height / 2);
        var10000 = this.seekBarY;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
        }

        var10000.setProgress(0);
        var10000 = this.seekBarY;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
        }

        var10000.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(@NotNull SeekBar seekBar, int progress, boolean fromUser) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                CustomizeDIActivity.this.getEventBus().post(new EventPositionChanged(progress, CustomizeDIActivity.this.getSeekBarX().getProgress()));
                CustomizeDIActivity.this.getEditor().putInt("Y_KEY", progress).apply();
            }

            public void onStartTrackingTouch(@NotNull SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            public void onStopTrackingTouch(@NotNull SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }
        }));
    }

    protected void onDestroy() {
        this.eventBus.unregister(this);
        super.onDestroy();
    }

    public CustomizeDIActivity() {
        EventBus var10001 = EventBus.getDefault();
        Intrinsics.checkNotNullExpressionValue(var10001, "EventBus.getDefault()");
        this.eventBus = var10001;
    }
}