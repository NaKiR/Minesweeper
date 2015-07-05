package ru.nakir.minesweeper;

public class Cell {
    public static final int CELL_WIDTH = 25;
    private int value;
    private Boolean isMine = false;
    private Boolean isOpen = false;
    private Boolean isMarked = false;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public Boolean isMarked() {
        return isMarked;
    }

    public void setMarked(Boolean isMarked) {
        this.isMarked = isMarked;
    }

    public Boolean isOpen() {
        return isOpen;
    }

    public void setOpen(Boolean isOpen) {
        if (!isMarked) {
            this.isOpen = isOpen;
        }
    }
}
