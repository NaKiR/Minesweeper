package ru.nakir.minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Field extends JPanel {
    private int lengthY;
    private int lengthX;
    private int indent = 1;
    private GameModel model;
    private Cell[][] field;

    public Field(GameModel model) {
        this.model = model;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        lengthY = model.getHeight() * Cell.CELL_WIDTH + (model.getHeight() + 1) * 2;
        lengthX = model.getWidth() * Cell.CELL_WIDTH + (model.getWidth() + 1) * 2;
        setBackground(Color.darkGray);
        setSize(new Dimension(lengthX, lengthY));
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        field = model.getField();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (!field[i][j].isOpen()) {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect((i + 1) * 2 + i * Cell.CELL_WIDTH, (j + 1) * 2 + j * Cell.CELL_WIDTH, Cell.CELL_WIDTH, Cell.CELL_WIDTH);
                } else if (field[i][j].isMine()) {
                    g.setColor(Color.black);
                    g.fillRect((i + 1) * 2 + i * Cell.CELL_WIDTH, (j + 1) * 2 + j * Cell.CELL_WIDTH, Cell.CELL_WIDTH, Cell.CELL_WIDTH);
                } else {
                    if (field[i][j].getValue() == 0) {
                        for (int m = i - 1; m <= i + 1; m++) {
                            for (int k = j - 1; k <= j + 1; k++) {
                                if (k >= 0 && m >= 0 && k < field[i].length && m < field.length) {
                                    field[m][k].setOpen(true);
                                }
                            }
                        }
                    }
                    Font font = g.getFont();
                    FontRenderContext frc = new FontRenderContext(null, true, true);
                    BufferedImage image = createImage(font, frc, Cell.CELL_WIDTH, field[i][j].getValue());

                    g.drawImage(image, (i + 1) * 2 + i * Cell.CELL_WIDTH, (j + 1) * 2 + j * Cell.CELL_WIDTH, null);
                }
            }
        }
    }

    public Dimension getFrameSize() {
        return new Dimension(lengthX + 6, lengthY + 49);
    }

    private BufferedImage createImage(Font font, FontRenderContext frc,
                                      int width, int i) {
        String s = Integer.toString(i);
        Font largeFont = font.deriveFont((float) (width / 2));
        Rectangle2D r = largeFont.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r.getWidth());
        int rHeight = (int) Math.round(r.getHeight());
        int rX = (int) Math.round(r.getX());
        int rY = (int) Math.round(r.getY());

        BufferedImage image = new BufferedImage(width, width,
                BufferedImage.TYPE_INT_RGB);

        Graphics gg = image.getGraphics();
        gg.setColor(Color.WHITE);
        gg.fillRect(0, 0, image.getWidth(), image.getHeight());

        int x = (width / 2) - (rWidth / 2) - rX;
        int y = (width / 2) - (rHeight / 2) - rY;

        gg.setFont(largeFont);
        switch (i) {
            case 0: gg.setColor(Color.WHITE);
                break;
            case 1: gg.setColor(Color.BLUE);
                break;
            case 2: gg.setColor(Color.GREEN);
                break;
            case 3: gg.setColor(Color.RED);
                break;
            case 4: gg.setColor(Color.MAGENTA);
                break;
            case 5: gg.setColor(Color.ORANGE);
                break;
            case 6: gg.setColor(Color.DARK_GRAY);
                break;
            case 7: gg.setColor(Color.BLACK);
                break;
            case 8: gg.setColor(Color.BLACK);
                break;
        }
        gg.drawString(s, x, y);
        gg.dispose();
        return image;
    }
}
