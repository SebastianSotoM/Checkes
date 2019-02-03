package com.devssm.bl;

public enum Movement {
    TOP_LEFT(0,-1,-1), TOP_RIGHT(2,1,-1), BOTTOM_LEFT(4,-1,1), BOTTOM_RIGHT(6,1,1);

    int value;
    int x;
    int y;

    Movement(int value,int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
