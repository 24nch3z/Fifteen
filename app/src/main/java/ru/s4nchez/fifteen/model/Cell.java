package ru.s4nchez.fifteen.model;

/**
 * Created by S4nchez on 16.07.2018.
 */

public abstract class Cell {

    private String mName;
    private int mValue;

    public Cell(String name, int value) {
        mName = name;
        mValue = value;
    }

    public String getName() {
        return mName;
    }

    public int getValue() {
        return mValue;
    }

    public abstract boolean isAvailable();
}