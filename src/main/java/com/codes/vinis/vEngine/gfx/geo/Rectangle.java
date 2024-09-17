package com.codes.vinis.vEngine.gfx.geo;

import com.codes.vinis.vEngine.intefaces.Renderable;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public class Rectangle implements Renderable {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    private int[] pixels;

    public Rectangle(@NotNull Dimension dimension, @NotNull Location location, int color) {

        this.dimension = dimension;

        this.location = location;

        this.pixels = new int[getDimension().getWidth() * dimension.getHeight()];


        for (int i = 0; i < getPixels().length; ) {

            pixels[i] = color;

            i = i + 1;
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

    public void setPixels(int[] pixels) {

        this.pixels = pixels;
    }
}
