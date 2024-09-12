package com.vinis.vEngine;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {

    private @NotNull JFrame jframe;

    private @NotNull BufferedImage image;

    private @NotNull BufferStrategy bufferStrategy;

    private @NotNull Canvas canvas;

    private @NotNull Graphics graphics;

    public Window(int width, int height, @NotNull String title) {

        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();

        Dimension s = new Dimension((int) (width * 3f), (int) (height * 3f));

        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        jframe = new JFrame(title);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new BorderLayout());
        jframe.add(canvas, BorderLayout.CENTER);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();

        graphics = bufferStrategy.getDrawGraphics();
    }

    public void update() {

        graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

        bufferStrategy.show();
    }
}
