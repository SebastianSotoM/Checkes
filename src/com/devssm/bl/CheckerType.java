package com.devssm.bl;

public enum CheckerType {
    NORMAL_WHITE("⛀\t"),NORMAL_BLACK("⛂\t"),KING_WHITE("⛁\t"),KING_BLACK("⛃\t");

    String unicode;
    CheckerType(String unicode){
        this.unicode = unicode;
    }

    public String getUnicode() {
        return unicode;
    }
}
