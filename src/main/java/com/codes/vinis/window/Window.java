package com.codes.vinis.window;

import com.codes.vinis.dimension.Dimension;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final @NotNull JFrame frame;

    private final @NotNull Dimension initialDimension;

    private @NotNull Dimension dimension;

    public Window(@NotNull String title, @NotNull Dimension dimension) {

        this.frame = new JFrame(title);

        this.initialDimension = dimension;

        this.dimension = dimension;

        initialize();
    }

    private void initialize() {

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(getInitialDimension().getWidth(), getInitialDimension().getHeight());
        this.frame.setLayout(new BorderLayout());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    public void update() {

        setDimension(new Dimension(getFrame().getWidth(), getFrame().getHeight()));
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
}