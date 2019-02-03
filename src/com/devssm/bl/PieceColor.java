package com.devssm.bl;

public enum PieceColor {
    BLACK(0),WHITE(1);
    int value;
    PieceColor(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
