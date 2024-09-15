package com.codes.vinis.window;

import com.codes.vinis.core.Renderer;
import com.codes.vinis.dimension.Dimension;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final @NotNull JFrame frame;

    private final @NotNull Dimension initialDimension;

    private @NotNull Dimension dimension;

    private @NotNull Renderer renderer;

    public Window(@NotNull String title, @NotNull Dimension dimension, @NotNull Renderer renderer) {

        this.frame = new JFrame(title);

        this.initialDimension = dimension;

        this.dimension = dimension;

        this.renderer = renderer;

        initialize();
    }

    private void initialize() {

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(getInitialDimension().getWidth(), getInitialDimension().getHeight());
        this.frame.setLayout(new BorderLayout());

        renderer.setPreferredSize(new java.awt.Dimension(initialDimension.getWidth(), initialDimension.getHeight()));

        this.frame.add(renderer, BorderLayout.CENTER);
        this.frame.pack();
        this.frame.add(getRenderer());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    public void update() {

        if (getFrame().getWidth() != getDimension().getWidth() || getFrame().getHeight() != getDimension().getHeight()) {

            setDimension(new Dimension(getFrame().getWidth(), getFrame().getHeight()));
        }

        getRenderer().update();
    }
    //todo: make a system of scale with this base

    public @NotNull JFrame getFrame() {

        return frame;
    }

    public @NotNull Dimension getInitialDimension() {

        return initialDimension;
    }

    public @NotNull Dimension getDimension() {

        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {

        this.dimension = dimension;
    }

    public @NotNull Renderer getRenderer() {

        return renderer;
    }

    public void setRenderer(@NotNull Renderer renderer) {

        this.renderer = renderer;
    }
}