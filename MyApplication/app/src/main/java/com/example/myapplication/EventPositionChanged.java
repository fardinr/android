package com.example.myapplication;

public class EventPositionChanged {
    private final int y;
    private final int x;

    public final int getY() {
        return this.y;
    }

    public final int getX() {
        return this.x;
    }

    public EventPositionChanged(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
