package com.devssm.bl.table;

import com.devssm.bl.Movement;
import com.devssm.bl.piece.Piece;
import com.devssm.exep.GameException;
import com.devssm.exep.GameExceptionType;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Table {
    protected Piece[][] tableMap;
    protected Piece[] p1;
    protected Piece[] p2;

    int[] rowName;
    char[] colName;

    //    CONSTRUCTORS
    public Table() {
        tableMap = new Piece[8][8];
        p1 = new Piece[16];
        p2 = new Piece[16];
        rowName = new int[tableMap.length];
        colName = new char[tableMap[0].length];
        fillNullTable();
        initPlayers();
    }

    public Table(int width, int height, int pieceAmount) {
        tableMap = new Piece[height][width];
        p1 = new Piece[pieceAmount];
        p2 = new Piece[pieceAmount];
        rowName = new int[tableMap.length];
        colName = new char[tableMap[0].length];

        //        INITIALIZES THE COLUMN NAMES
        int unicode = 0x41;
        for (int i = 0; i < colName.length; i++) {
            colName[i] = (char) (unicode + i);
        }
//        INITIALIZED THE ROW NUMBERS
        for (int i = rowName.length - 1; i >= 0; i--) {
            rowName[(i - (rowName.length - 1)) * -1] = i + 1;
        }

        fillNullTable();
        initPlayers();
    }


    //    GETTERS AND SETTERS
    public Piece[][] getTableMap() {
        return tableMap;
    }

    public void setTableMap(Piece[][] tableMap) {
        this.tableMap = tableMap;
    }

    public Piece[] getP1() {
        return p1;
    }

    public void setP1(Piece[] p1) {
        this.p1 = p1;
    }

    public Piece[] getP2() {
        return p2;
    }

    public void setP2(Piece[] p2) {
        this.p2 = p2;
    }


    //  ABSTRACT METHODS
    public abstract void initPlayers();

    //  CLASS UTILITIES
    public void movePiece(int row, String scol, Movement direction, int spaces) throws GameException {
        HashMap<String, Object> pieceInfo = getPieceInfo(row, scol);
        if (pieceInfo != null) {
            Piece[] actualArray = (Piece[]) pieceInfo.get("array");
            actualArray[(int) pieceInfo.get("index")].move(direction, spaces);
        }
    }

    private HashMap<String, Object> getPieceInfo(int row, String scol) throws GameException {
        int[] coords = getPieceFromTable(row, scol);
        HashMap<String, Object> info = new HashMap<>();

        for (int i = 0; i < this.p1.length; i++) {
            if (p1[i].getPos()[0] == coords[0] && p1[i].getPos()[1] == coords[1]) {
                info.put("player", 1);
                info.put("index", i);
                info.put("array", p1);
                return info;
            }
            if (p2[i].getPos()[0] == coords[0] && p2[i].getPos()[1] == coords[1]) {
                info.put("player", 2);
                info.put("index", i);
                info.put("array", p2);
                return info;
            }
        }
        return null;
    }

    private int[] getPieceFromTable(int row, String scol) throws GameException {
        char col = scol.toUpperCase().charAt(0);
        int ixRow = rowName.length - row;
        int ixCol = (int) col - 65;
        if (ixRow > -1 && ixCol > -1) {
            return new int[]{ixRow, ixCol};
        } else {
            throw new GameException(GameExceptionType.OUT_MAP);
        }
    }

    private void fillNullTable() {
        for (Piece[] row : tableMap) {
            for (int i = 0; i < row.length; i++) {
                row[i] = null;
            }
        }
    }

    public void updateTable() {
        fillNullTable();
        if (p1.length > 0 && p2.length == p1.length) {

            for (int i = 0; i < p1.length; i++) {
                updateCurrentPlayer(i, p1);
                updateCurrentPlayer(i, p2);
            }
        }
    }

    private void updateCurrentPlayer(int i, Piece[] player) {
        if (player[i] != null) {
            Piece current = player[i];
            int row = current.getPos()[0];
            int col = current.getPos()[1];
            if (current.isState()) {
                tableMap[row][col] = current;
            } else {
                tableMap[row][col] = null;
            }
        }
    }

    @Override
    public String toString() {
        String tableView = "";
//        FOR EACH ROW PRINTS THE NUMBER
        for (int i = 0; i < tableMap.length; i++) {
            tableView += rowName[i] + "\t";
//            FOR EACH COLUMN
            for (int j = 0; j < tableMap[i].length; j++) {
//                IF THERE IS AN OBJECT THERE AND IT IS ALIVE (STATE TRUE) THEN PRINTS ITS NAME, ELSE -1
                if (tableMap[i][j] != null && tableMap[i][j].isState()) {
                    tableView += tableMap[i][j].getName();
                } else {
                    tableView += "_\t";
                }
            }
            tableView += "\n";
        }
        tableView += "\t";
        String line = "  ";
        for (int i = 0; i < colName.length; i++) {
            tableView += colName[i] + "\t";
            line += "-___";
        }
        tableView += "\n" + line + "-\n";
        return tableView;
    }
}
