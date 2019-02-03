package com.devssm;

import com.devssm.bl.Movement;
import com.devssm.bl.piece.CheckersPiece;
import com.devssm.bl.table.CheckersTable;
import com.devssm.exep.GameException;

public class Main {

    public static void main(String[] args) {
        CheckersTable ct = new CheckersTable(8, 8, 12);
        try {
            CheckersPiece p = (CheckersPiece) ct.getPiece(6, "a");
            if (p != null)
                p.move(Movement.BOTTOM_RIGHT, 1);
            ct.updateTable();
        } catch (GameException e) {
            e.printStackTrace();
        }
        System.out.println(ct.toString());
    }
}
