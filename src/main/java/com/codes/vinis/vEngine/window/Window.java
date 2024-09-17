package com.codes.vinis.vEngine.window;

import com.codes.vinis.vEngine.utils.Dimension;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window {

    private final @NotNull JFrame FRAME;

    private final @NotNull BufferedImage IMAGE;

    private @NotNull BufferStrategy bufferStrategy;

    private final @NotNull Canvas CANVAS;

    private @NotNull Graphics graphics;

    private @NotNull Dimension dimension;

    private final float SCALE;

    public Window(@NotNull String title, @NotNull Dimension dimension, float scale) {

        this.dimension = dimension;

        this.SCALE = scale;

        this.IMAGE = new BufferedImage(getDimension().getWidth(), getDimension().getHeight(), BufferedImage.TYPE_INT_RGB);

        this.CANVAS = new Canvas();

        @NotNull java.awt.Dimension size = new java.awt.Dimension((int) (dimension.getWidth() * getSCALE()), (int) (dimension.getHeight() * getSCALE()));

        getCANVAS().setPreferredSize(size);
        getCANVAS().setMaximumSize(size);
        getCANVAS().setMinimumSize(size);

        this.FRAME = new JFrame(title);

        getFRAME().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFRAME().setLayout(new BorderLayout());
        getFRAME().add(getCANVAS(), BorderLayout.CENTER);
        getFRAME().pack();
        getFRAME().setLocationRelativeTo(null);
        getFRAME().setResizable(true);
        getFRAME().setVisible(true);

        getCANVAS().createBufferStrategy(2);

        this.bufferStrategy = getCANVAS().getBufferStrategy();

        this.graphics = getBufferStrategy().getDrawGraphics();
    }

    public void update() {
        if (getFRAME().getWidth() != getDimension().getWidth() || getFRAME().getHeight() != getDimension().getHeight()) {
            setDimension(new Dimension(getFRAME().getWidth(), getFRAME().getHeight()));

            java.awt.Dimension size = new java.awt.Dimension((int) (getDimension().getWidth() * getSCALE()), (int) (getDimension().getHeight() * getSCALE()));
            getCANVAS().setPreferredSize(size);
            getCANVAS().setSize(size);

            // Recriar BufferStrategy após redimensionamento
            getCANVAS().createBufferStrategy(2);
            this.bufferStrategy = getCANVAS().getBufferStrategy();
            this.graphics = getBufferStrategy().getDrawGraphics();
        }

        getGraphics().drawImage(getIMAGE(), 0, 0, getCANVAS().getWidth(), getCANVAS().getHeight(), null);
        getBufferStrategy().show();
    }

    public @NotNull JFrame getFRAME() {
        return FRAME;
    }

    public @NotNull BufferedImage getIMAGE() {
        return IMAGE;
    }

    public @NotNull BufferStrategy getBufferStrategy() {
        return bufferStrategy;
    }

    public @NotNull Canvas getCANVAS() {
        return CANVAS;
    }

    public @NotNull Graphics getGraphics() {
        return graphics;
    }

    public @NotNull Dimension getDimension() {
        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {
        this.dimension = dimension;
    }

    public float getSCALE() {
        return SCALE;
    }
}