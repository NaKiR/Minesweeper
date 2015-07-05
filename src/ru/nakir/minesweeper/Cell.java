package ru.nakir.minesweeper;

public class Cell {
    public static final int CELL_WIDTH = 25;
    private int value;
    private Boolean isMine = false;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Boolean isEmptyCell() {
        return value == 0;
    }

    public Boolean isMine() {
        return isMine;
    }

    public void setMine() {
        isMine = true;
    }
}
