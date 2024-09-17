package com.codes.vinis.vEngine.gfx.image;

import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    private int[] pixels;

    public Image(@NotNull String path, @NotNull Location location) {

        @NotNull BufferedImage image = null;

        try {

            image = ImageIO.read(new File(path));
        } catch (IOException e) {

            e.printStackTrace();
        }

        assert image != null;

        this.dimension = new Dimension(image.getWidth(), image.getHeight());

        this.location = location;

        this.pixels = image.getRGB(0, 0, getDimension().getWidth(), getDimension().getHeight(), null, 0, getDimension().getWidth());

        image.flush();
    }

    public @NotNull Dimension getDimension() {
        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {
        this.dimension = dimension;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }
}
