package ru.nakir.minesweeper;

import javax.swing.*;
import java.awt.*;

public class Minesweeper {

    public Minesweeper() {}

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Minesweeper minesweeper = new Minesweeper();
            }
        });
    }
}
