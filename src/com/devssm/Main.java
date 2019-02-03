package com.devssm;

import com.devssm.bl.Movement;
import com.devssm.bl.piece.CheckersPiece;
import com.devssm.bl.piece.Piece;
import com.devssm.bl.table.CheckersTable;
import com.devssm.bl.table.Table;
import com.devssm.exep.GameException;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CheckersTable ct = new CheckersTable(8, 8, 12);
        try {
            CheckersPiece p = (CheckersPiece) ct.getPiece(6, "b");
            if (p != null)
                p.move(Movement.BOTTOM_RIGHT, 2);
        } catch (GameException e) {
            e.printStackTrace();
        }
        System.out.println(ct.toString());
    }
}
