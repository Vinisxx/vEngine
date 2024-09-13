package com.codes.vinis.vEngine.gfx;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private int width, height;

    private int[] pixels;

    public Image(@NotNull String path) {

        @NotNull BufferedImage image = null;

        try {

            image = ImageIO.read(new File(path));

        } catch (IOException e) {

            e.printStackTrace();
        }

        this.width = image.getWidth();
        this.height = image.getHeight();

        this.pixels = image.getRGB(0, 0, width, height, null, 0, width);

        image.flush();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }
}
