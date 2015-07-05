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

    public void generateField() {
        field = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                field[i][j] = new Cell(0);
            }
        }
    }

    public void generateMines() {
        int number = numberOfMines;
        while (number > 0) {
            field[(int)(Math.random()*width)][(int)(Math.random()*height)].setMine();
            number--;
        }
    }

    public int getHeight() {
        return height;
    }

    public Cell[][] getField() {
        return field;
    }
}
