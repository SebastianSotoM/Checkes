package com.devssm.bl.piece;

import com.devssm.bl.CheckerType;
import com.devssm.bl.Movement;
import com.devssm.bl.PieceColor;
import com.devssm.bl.table.Table;

public class CheckersPiece extends Piece{

    CheckerType type;
    public CheckersPiece() {
    }

    public CheckersPiece(PieceColor color, int[] pos) {
        super(color, pos);
        if(color.getValue() == PieceColor.BLACK.getValue())
            type = CheckerType.NORMAL_BLACK;
        else
            type = CheckerType.NORMAL_WHITE;
        name = type.getUnicode();
    }

    public CheckerType getType() {
        return type;
    }

    public void setType(CheckerType type) {
        this.type = type;
    }

    @Override
    public void move(Movement direction, int spaces) {
        int x = direction.getX()*spaces;
        int y = direction.getY()*spaces;

        tempPos = new int [] {pos[0]+y,pos[1]+x};
        pos = tempPos;
    }

    @Override
    public void attack(Piece enemy) {

    }

    @Override
    public Piece isEnemyNear() {
        return null;
    }

    @Override
    public boolean isAllyNear() {
        return false;
    }


}
