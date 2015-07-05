package ru.nakir.minesweeper;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private int lengthY;
    private int lengthX;
    private int indent = 1;
    private GameModel model;
    private Cell[][] field;

    public Field(GameModel model) {
        this.model = model;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        lengthY = model.getHeight() * 25 + model.getHeight() + 1;
        lengthX = model.getWidth() * 25 + model.getWidth() + 1;
        setBackground(Color.darkGray);
        setSize(new Dimension(lengthX, lengthY));
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        field = model.getField();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                g.fillRect();
            }
        }
    }
}
