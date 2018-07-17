package ru.s4nchez.fifteen.model;

/**
 * Created by S4nchez on 16.07.2018.
 */

public class SimpleCell extends Cell {

    public SimpleCell(String name, int value) {
        super(name, value);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
