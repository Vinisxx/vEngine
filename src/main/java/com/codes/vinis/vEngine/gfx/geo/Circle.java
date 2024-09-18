package com.codes.vinis.vEngine.gfx.geo;

import com.codes.vinis.vEngine.intefaces.Renderable;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public class Circle implements Renderable {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    private int[] pixels;

    private int radius;

    public Circle(int radius, @NotNull Location location, int color) {

        this.radius = radius;

        this.location = location;

        this.dimension = new Dimension(radius * 2, radius * 2);

        this.pixels = new int[getDimension().getWidth() * getDimension().getHeight()];

        for (int y = 0; y < getDimension().getHeight(); ) {

            for (int x = 0; x < getDimension().getWidth();) {

                int centerX = radius, centerY = radius;

                double dx = x - centerX + 0.5;
                double dy = y - centerY + 0.5;

                if (Math.pow(dx, 2) + Math.pow(dy, 2) <= Math.pow(radius, 2)) {

                    pixels[x + y * dimension.getWidth()] = color;
                }  else {

                    pixels[x + y * dimension.getWidth()] = 0xffff00ff;
                }

                x = x + 1;
            }

            y = y + 1;
        }

    }

    @Override
    public @NotNull Dimension getDimension() {

        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {

        this.dimension = dimension;
    }

    @Override
    public @NotNull Location getLocation() {

        return location;
    }

    public void setLocation(@NotNull Location location) {

        this.location = location;
    }

    @Override
    public int[] getPixels() {

        return pixels;
    }

    @Override
    public void update() {}

    public void setPixels(int[] pixels) {

        this.pixels = pixels;
    }

    public int getRadius() {

        return radius;
    }

    public void setRadius(int radius) {

        this.radius = radius;
    }
}
