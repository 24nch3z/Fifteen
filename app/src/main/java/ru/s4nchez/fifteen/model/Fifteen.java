package ru.s4nchez.fifteen.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by S4nchez on 16.07.2018.
 */

/*
    1    2   3   4
    5    6   7   8
    9   10  11  12
    13  14  15
*/

public class Fifteen {

    private static Fifteen sFifteen;

    private static final int SIDE_COUNT = 4;
    private static final int CELLS_COUNT = SIDE_COUNT * SIDE_COUNT;

    private Cell[][] mCells = new Cell[SIDE_COUNT][SIDE_COUNT];
    private int[][] mWinMatrix = new int[SIDE_COUNT][SIDE_COUNT];

    public static Fifteen get() {
        if (sFifteen == null) {
            sFifteen = new Fifteen();
        }
        return sFifteen;
    }

    private Fifteen() {
        initWinMatrix();
        initCells();
    }

    private void initWinMatrix() {
        int k = 1;
        for (int i = 0; i < SIDE_COUNT; i++) {
            for (int j = 0; j < SIDE_COUNT; j++, k++) {
                mWinMatrix[i][j] = k == (CELLS_COUNT - 1) ? 0 : k;
            }
        }
    }

    private void initCells() {
        List<Cell> cells = getShuffleListOfCells();
        int k = 0;

        for (int i = 0; i < SIDE_COUNT; i++) {
            for (int j = 0; j < SIDE_COUNT; j++, k++) {
                mCells[i][j] = cells.get(k);
            }
        }
    }

    private List<Cell> getShuffleListOfCells() {
        List<Cell> cells = new ArrayList<>(CELLS_COUNT);
        for (int i = 1; i <= CELLS_COUNT - 1; i++) {
            cells.add(new SimpleCell(String.valueOf(i), i));
        }
        cells.add(new EmptyCell());
        Collections.shuffle(cells);
        return cells;
    }

    public void move(int i, int j) {
        if (mCells[i][j].isAvailable()) {
            int[] emptyCellPosition = getEmptyCellPosition();
            if (checkTheNeighborhood(new int[] { i, j }, emptyCellPosition)) {
                changeCells(new int[] { i, j }, emptyCellPosition);
            }
        }
    }

    private boolean checkTheNeighborhood(int[] cell, int[] emptyCellPosition) {
        if ((cell[0] == emptyCellPosition[0] && Math.abs(cell[1] - emptyCellPosition[1]) == 1) ||
                (cell[1] == emptyCellPosition[1] && Math.abs(cell[0] - emptyCellPosition[0]) == 1)) {
            return true;
        }

        return false;
    }

    private int[] getEmptyCellPosition() {
        for (int i = 0; i < SIDE_COUNT; i++) {
            for (int j = 0; j < SIDE_COUNT; j++) {
                if (mCells[i][j] instanceof EmptyCell) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private void changeCells(int[] cell, int[] empty) {
        Cell buf = mCells[cell[0]][cell[1]];
        mCells[cell[0]][cell[1]] = mCells[empty[0]][empty[1]];
        mCells[empty[0]][empty[1]] = buf;
    }

    public Cell[][] getCells() {
        return mCells;
    }

    public int[][] getWinMatrix() {
        return mWinMatrix;
    }
}