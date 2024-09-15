package com.codes.vinis.core;

import com.codes.vinis.dimension.Dimension;
import com.codes.vinis.utils.Location;
import com.codes.vinis.window.ResponsivePanel;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer extends ResponsivePanel {

    private @NotNull Dimension dimension;

    private @NotNull BufferedImage bufferedImage;

    public Renderer(@NotNull Dimension dimension) {

        this.dimension = dimension;

        this.bufferedImage = new BufferedImage(this.dimension.getWidth(), this.dimension.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    @Override
    protected void paintComponent(@NotNull Graphics g) {

        super.paintComponent(g);

        g.drawImage(getBufferedImage(), 0, 0, getWidth(), getHeight(), null);
    }

    private void clear() {

        @NotNull Graphics2D g2d = getBufferedImage().createGraphics();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getDimension().getWidth(), getDimension().getHeight());
        g2d.dispose();

        repaint();
    }

    public void update() {

        if (getWidth() != getDimension().getWidth() || getHeight() != getDimension().getHeight()) {

            setDimension(new Dimension(getWidth(), getHeight()));

            setBufferedImage(new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_RGB));

            clear();
        }
    }

    public void drawImage(@NotNull BufferedImage image, @NotNull Location OFFsetLocation) {

        @NotNull Graphics2D g2d = image.createGraphics();

        g2d.drawImage(image, OFFsetLocation.getX(), OFFsetLocation.getY(), null);

        g2d.dispose();

        repaint();
    }
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

    public void setBufferedImage(@NotNull BufferedImage bufferedImage) {

        this.bufferedImage = bufferedImage;
    }
}