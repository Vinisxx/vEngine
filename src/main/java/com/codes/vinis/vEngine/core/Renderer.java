package com.codes.vinis.vEngine.core;

import com.codes.vinis.vEngine.gfx.image.Image;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import com.codes.vinis.vEngine.window.Window;
import org.jetbrains.annotations.NotNull;

import java.awt.image.DataBufferInt;

public class Renderer {

    private @NotNull Dimension dimension;

    private int[] pixels;

    public Renderer(@NotNull Window window) {

        this.dimension = window.getDimension();

        pixels = ((DataBufferInt)window.getIMAGE().getRaster().getDataBuffer()).getData();
    }

    public void clear() {

        for (int i= 0; i < pixels.length;) {

            pixels[i] = 0;

            i = i + 1;
        }
    }

    public void setPixel(@NotNull Location location, int value) {

        if ((location.getX() < 0 || location.getX() >= getDimension().getWidth() || location.getY() < 0 || location.getY() >= getDimension().getHeight()) || value == 0xffff00ff) {

            return;
        }

        pixels[location.getX() + location.getY() * getDimension().getWidth()] = value;
    }

    public void drawImage(@NotNull Image image) {

        @NotNull Location newLocation = new Location(0, 0);

        @NotNull Dimension newDimension = new Dimension(image.getDimension().getWidth(),image.getDimension().getHeight());

        if (image.getLocation().getX() < -newDimension.getWidth()) return;
        if (image.getLocation().getY() < -newDimension.getHeight()) return;

        if (image.getLocation().getX() >= getDimension().getWidth()) return;
        if (image.getLocation().getY() >= getDimension().getHeight()) return;

        if (image.getLocation().getX() < 0) {

            newLocation.setX(newLocation.getX() - image.getLocation().getX());
        }

        if (image.getLocation().getY() < 0) {

            newLocation.setY(newLocation.getY() - image.getLocation().getY());
        }

        if (newDimension.getWidth() + image.getLocation().getX() > getDimension().getWidth()) {

            newDimension.setWidth(newDimension.getWidth() - (newDimension.getWidth() + image.getLocation().getX() - getDimension().getWidth()));
        }

        if (newDimension.getHeight() + image.getLocation().getY() > getDimension().getHeight()) {

            newDimension.setHeight(newDimension.getHeight() - (newDimension.getHeight() + image.getLocation().getY() - getDimension().getHeight()));
        }

        for (int y = newLocation.getY(); y < newDimension.getHeight(); y++) {

            for (int x = newLocation.getX();  x < newDimension.getWidth(); x++) {

                setPixel(new Location(x + image.getLocation().getX(), y + image.getLocation().getY()), image.getPixels()[x + y * image.getDimension().getWidth()]);
            }
        }
    }

    public @NotNull Dimension getDimension() {
        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {
        this.dimension = dimension;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }
}