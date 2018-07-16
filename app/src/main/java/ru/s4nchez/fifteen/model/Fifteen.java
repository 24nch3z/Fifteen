package ru.s4nchez.fifteen.model;

import java.util.ArrayList;
import java.util.Collections;
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

    private static final int SIDE_COUNT = 4;
    private static final int CELLS_COUNT = SIDE_COUNT * SIDE_COUNT;

    private Cell[][] mCells = new Cell[SIDE_COUNT][SIDE_COUNT];

    public Fifteen() {
        initCells();
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
            cells.add(new SimpleCell(String.valueOf(i)));
        }
        cells.add(new EmptyCell());
        Collections.shuffle(cells);
        return cells;
    }

    public void move(int i, int j) {
        if (mCells[i][j].isAvailable()) {

        }
    }

    public Cell[][] getCells() {
        return mCells;
    }
}
