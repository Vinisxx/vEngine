package com.codes.vinis.vEngine;

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

    public Window(@NotNull GameContainer gameContainer) {

        this.image = new BufferedImage(gameContainer.getWidth(), gameContainer.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();

        Dimension s = new Dimension((int) (gameContainer.getWidth() * gameContainer.getScale()), (int) (gameContainer.getHeight() * gameContainer.getScale()));

        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        jframe = new JFrame(gameContainer.getTitle());
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

    public @NotNull BufferedImage getImage() {
        return image;
    }

    public @NotNull BufferStrategy getBufferStrategy() {
        return bufferStrategy;
    }

    public @NotNull Canvas getCanvas() {
        return canvas;
    }

    public @NotNull Graphics getGraphics() {
        return graphics;
    }

    public @NotNull JFrame getJframe() {
        return jframe;
    }
}
