package com.codes.vinis.window;

import com.codes.vinis.dimension.Dimension;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window {

    private @NotNull JFrame frame;

    private @NotNull JPanel panel;

    private @NotNull Dimension dimension;

    public Window(@NotNull String title, @NotNull Dimension dimension, @NotNull JPanel panel) {

        this.frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(dimension.getWidth(), dimension.getHeight());
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);

    }

    //todo: make a system of scale with this base
}
