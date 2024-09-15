package com.codes.vinis.vEngine.core;

import com.codes.vinis.vEngine.gfx.image.Image;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import com.codes.vinis.vEngine.window.ResponsivePanel;
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

    public void update() {

        if (getWidth() != getDimension().getWidth() || getHeight() != getDimension().getHeight()) {

            setDimension(new Dimension(getWidth(), getHeight()));
        }

        @NotNull BufferedImage newImage = new BufferedImage(dimension.getWidth(), dimension.getHeight(), BufferedImage.TYPE_INT_ARGB);
        @NotNull Graphics2D g2d = newImage.createGraphics();

        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, dimension.getWidth(), dimension.getHeight());
        g2d.setComposite(AlphaComposite.SrcOver);

        g2d.drawImage(bufferedImage, 0, 0, null);
        g2d.dispose();

        setBufferedImage(newImage);
    }

    public void drawImage(@NotNull Image image, @NotNull Location offsetLocation) {

        @NotNull Graphics2D g2d = bufferedImage.createGraphics();

        g2d.drawImage(image.getBufferedImage(), offsetLocation.getX(), offsetLocation.getY(), image.getDimension().getWidth(), image.getDimension().getHeight(), null);

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