package com.devssm.bl.table;

import com.devssm.bl.PieceColor;
import com.devssm.bl.piece.CheckersPiece;
import com.devssm.bl.piece.Piece;
import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;

public class CheckersTable extends Table {

    public CheckersTable() {
        super();
    }

    public CheckersTable(int width, int height, int pieceAmount) {
        super(width, height, pieceAmount);
    }

    @Override
    public void initPlayers() {
//        FILLS THE TABLEMAP WITH THE ACCORDING CHECKER PIECE
        int x = tableMap.length;
        int y = tableMap[0].length;
        ArrayList<CheckersPiece> blacks = new ArrayList<>();
        ArrayList<CheckersPiece> whites = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            PieceColor color = null;
            if (i < 3) {
                color = PieceColor.BLACK;
            } else if (i > tableMap.length - 4) {
                color = PieceColor.WHITE;
            }
            for (int j = 0; j < y; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    if (color != null) {
                        CheckersPiece p = new CheckersPiece(color, new int[]{i, j}, this);
                        if(color == PieceColor.BLACK){
                            blacks.add(p);
                        }else{
                            whites.add(p);
                        }
                    }
                }
            }
        }
        for(int i =0;i<p1.length;i++){
            p1[i] = whites.get(i);
            p2[i] = blacks.get(i);

            int row1,row2,col1,col2;
            row1 = p1[i].getPos()[0];
            row2 = p2[i].getPos()[0];
            col1 = p1[i].getPos()[1];
            col2 = p1[i].getPos()[1];

            tableMap[row1][col1] = p1[i];
            tableMap[row2][col2] = p2[i];
        }
    }
}
