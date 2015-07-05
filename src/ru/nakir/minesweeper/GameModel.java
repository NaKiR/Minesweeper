package ru.nakir.minesweeper;

public class GameModel {
    private int width;
    private int height;
    private int numberOfMines;
    private Cell[][] field;

    public GameModel() {
        width = 8;
        height = 8;
        numberOfMines = 10;
        generateField();
        generateMines();
        updateField();
    }

    public void setWidth(int width) {
        this.width = width;
        generateField();
    }

    public void setHeight(int height) {
        this.height = height;
        generateField();
    }

    public int getWidth() {
        return width;
    }

    private void generateField() {
        field = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                field[i][j] = new Cell(0);
            }
        }
    }

    private void generateMines() {
        int number = numberOfMines;
        while (number > 0) {
            field[(int)(Math.random()*width)][(int)(Math.random()*height)].setMine();
            number--;
        }
    }

    private void updateField() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field[i][j].isMine()) {
                    for (int m = i - 1; m <= i + 1; m++) {
                        for (int k = j - 1; k <= j + 1; k++) {
                            if (k >= 0 && m >= 0 && k < height && m < width) {
                                field[m][k].setValue(field[m][k].getValue() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getField() {
        return field;
    }

    public int isEnd() {
        Boolean temp = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (field[i][j].isMine() && field[i][j].isOpen()) {
                    return -1;
                }
                if (!field[i][j].isMine() && !field[i][j].isOpen()) {
                    temp = false;
                }
            }
        }
        if (temp) {
            return 1;
        } else {
            return 0;
        }
    }
}
