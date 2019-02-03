package com.devssm;

import com.devssm.bl.Movement;
import com.devssm.bl.piece.CheckersPiece;
import com.devssm.bl.table.CheckersTable;
import com.devssm.exep.GameException;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        CheckersTable ct = new CheckersTable(8, 8, 12);
        try {
            ct.movePiece(8,"a",Movement.BOTTOM_RIGHT,3);
            ct.movePiece(3,"b",Movement.TOP_LEFT,1);
            ct.updateTable();
            System.out.println(ct.toString());
        } catch (GameException e) {
            e.printStackTrace();
        }
    }
}
