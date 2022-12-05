package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public class MainActivity extends AppCompatActivity {
    public Button buttonChangePosition;
    public Button buttonCheck;

    @NotNull
    public final Button getButtonChangePosition() {
        Button var10000 = this.buttonChangePosition;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonChangePosition");
        }

        return var10000;
    }

    public final void setButtonChangePosition(@NotNull Button var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.buttonChangePosition = var1;
    }

    @NotNull
    public final Button getButtonCheck() {
        Button var10000 = this.buttonCheck;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonCheck");
        }

        return var10000;
    }

    public final void setButtonCheck(@NotNull Button var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.buttonCheck = var1;
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(1300000);
        View var10001 = this.findViewById(1000006);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.button_position)");
        this.buttonChangePosition = (Button)var10001;
        var10001 = this.findViewById(1000005);
        Intrinsics.checkNotNullExpressionValue(var10001, "findViewById(R.id.button_check)");
        this.buttonCheck = (Button)var10001;
        Button var10000 = this.buttonCheck;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonCheck");
        }

        var10000.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                MainActivity.this.checkPermissions();
            }
        }));
        var10000 = this.buttonChangePosition;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonChangePosition");
        }

        var10000.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                MainActivity.this.startActivity(new Intent((Context)MainActivity.this, CustomizeDIActivity.class));
            }
        }));
    }

    private final void checkPermissions() {
        if (!Settings.canDrawOverlays((Context)this)) {
            this.requestOverlayPermission();
        } else if (!this.isAccessibilitySettingsOn((Context)this)) {
            this.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
        }

    }

    private final void requestOverlayPermission() {
        Intent permissionIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + this.getPackageName()));
        permissionIntent.setFlags(268435456);
        this.startActivityForResult(permissionIntent, 8);
    }

    private final boolean isAccessibilitySettingsOn(Context mContext) {
        int accessibilityEnabled = 0;
        String service = this.getPackageName() + "/" + DynamicIslandService.class.getCanonicalName();

        Context var10000;
        try {
            var10000 = mContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "mContext.applicationContext");
            accessibilityEnabled = Settings.Secure.getInt(var10000.getContentResolver(), "accessibility_enabled");
        } catch (Settings.SettingNotFoundException var7) {
            var7.printStackTrace();
        }

        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');
        if (accessibilityEnabled == 1) {
            var10000 = mContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(var10000, "mContext.applicationContext");
            String settingValue = Settings.Secure.getString(var10000.getContentResolver(), "enabled_accessibility_services");
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);

                while(mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();
                    if (StringsKt.equals(accessibilityService, service, true)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}