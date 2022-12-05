package com.example.myapplication;

import org.jetbrains.annotations.NotNull;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class Constants {
    @NotNull
    public static final String MY_DATA = "MY_DATA";
    @NotNull
    public static final String Y_KEY = "Y_KEY";
    @NotNull
    public static final String X_KEY = "X_KEY";
    @NotNull
    public static final Constants.Companion Companion = new Constants.Companion((DefaultConstructorMarker)null);

    @Metadata(
            mv = {1, 6, 0},
            k = 1,
            d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
            d2 = {"Lcom/osamaalek/dynamicisland/Constants$Companion;", "", "()V", "MY_DATA", "", "X_KEY", "Y_KEY", "app_debug"}
    )
    public static final class Companion {
        private Companion() {
        }

        // $FF: synthetic method
        public Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
