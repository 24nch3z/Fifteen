package ru.s4nchez.fifteen.model;

/**
 * Created by S4nchez on 16.07.2018.
 */

public class SimpleCell extends Cell {

    public SimpleCell(String name) {
        super(name);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
