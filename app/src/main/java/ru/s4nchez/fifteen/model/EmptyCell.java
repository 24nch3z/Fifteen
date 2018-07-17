package ru.s4nchez.fifteen.model;

/**
 * Created by S4nchez on 16.07.2018.
 */

public class EmptyCell extends Cell {

    public EmptyCell() {
        super("", 0);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }
}
