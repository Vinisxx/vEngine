package com.codes.vinis.core;

import com.codes.vinis.dimension.Dimension;
import com.codes.vinis.window.ResponsivePanel;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Render extends ResponsivePanel {

    private @NotNull Dimension dimension;

    private final @NotNull BufferedImage bufferedImage;

    public Render(@NotNull Dimension dimension) {

        this.dimension = dimension;

        this.bufferedImage = new BufferedImage(this.dimension.getWidth(), this.dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    @Override
    protected void paintComponent(@NotNull Graphics g) {

        super.paintComponent(g);

        g.drawImage(getBufferedImage(), 0, 0, getWidth(), getHeight(), null);
    }

    public void clear() {

        @NotNull Graphics2D g2d = getBufferedImage().createGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getDimension().getWidth(), getDimension().getHeight());
        g2d.dispose();

        repaint();
    }

    //todo: create plus methods and create some annotations in some methods

    @Override
    public void resizeComponents() {

        //todo: implements the logic of resize components
    }

    public @NotNull Dimension getDimension() {
        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {
        this.dimension = dimension;
    }

    public @NotNull BufferedImage getBufferedImage() {
        return bufferedImage;
    }
}