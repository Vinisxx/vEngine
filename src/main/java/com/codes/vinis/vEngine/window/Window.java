package com.codes.vinis.vEngine.window;

import com.codes.vinis.vEngine.core.Renderer;
import com.codes.vinis.vEngine.utils.Dimension;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final @NotNull JFrame FRAME;

    private final @NotNull Dimension INITIAL_DIMENSION;

    private @NotNull Dimension dimension;

    private @NotNull Renderer renderer;

    public Window(@NotNull String title, @NotNull Dimension dimension) {

        this.FRAME = new JFrame(title);

        this.INITIAL_DIMENSION = dimension;

        this.dimension = dimension;

        this.renderer = new Renderer(getInitialDimension());

        initialize();
    }

    private void initialize() {

        this.FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.FRAME.setSize(getInitialDimension().getWidth(), getInitialDimension().getHeight());
        this.FRAME.setLayout(new BorderLayout());

        renderer.setPreferredSize(new java.awt.Dimension(INITIAL_DIMENSION.getWidth(), INITIAL_DIMENSION.getHeight()));

        this.FRAME.add(renderer, BorderLayout.CENTER);
        this.FRAME.pack();
        this.FRAME.add(getRenderer());
        this.FRAME.setLocationRelativeTo(null);
        this.FRAME.setVisible(true);
    }

    public void update() {

        if (getFrame().getWidth() != getDimension().getWidth() || getFrame().getHeight() != getDimension().getHeight()) {

            setDimension(new Dimension(getFrame().getWidth(), getFrame().getHeight()));
        }

        getRenderer().update();
    }

    public @NotNull JFrame getFrame() {

        return FRAME;
    }

    public @NotNull Dimension getInitialDimension() {

        return INITIAL_DIMENSION;
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