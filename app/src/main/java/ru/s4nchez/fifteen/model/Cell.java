package ru.s4nchez.fifteen.model;

/**
 * Created by S4nchez on 16.07.2018.
 */

public abstract class Cell {

    private String mName;

    public Cell(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public abstract boolean isAvailable();
}
