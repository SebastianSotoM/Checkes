package com.devssm.bl.piece;

import com.devssm.bl.Movement;
import com.devssm.bl.PieceColor;
import com.devssm.bl.table.Table;

import java.util.Vector;

public abstract class Piece {

    protected String name;
    protected PieceColor color;
    protected int[] pos;
    protected Table table;
    protected int[] tempPos;
    protected boolean state;

    public Piece() {
    }

    public Piece(PieceColor color, int[] pos, Table table) {
        this.color = color;
        this.pos = pos;
        this.table = table;
        this.state = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int[] getTempPos() {
        return tempPos;
    }

    public void setTempPos(int[] tempPos) {
        this.tempPos = tempPos;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public abstract void move(Movement direction, int spaces);
    public abstract Piece isEnemyNear();
    public abstract boolean isAllyNear();
}