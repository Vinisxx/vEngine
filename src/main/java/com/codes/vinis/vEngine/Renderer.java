package com.codes.vinis.vEngine;

import com.codes.vinis.vEngine.gfx.Image;
import org.jetbrains.annotations.NotNull;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int width, height;

    private int[] pixels;

    public Renderer(@NotNull GameContainer gameContainer) {

        this.width = gameContainer.getWidth();
        this.height = gameContainer.getHeight();

        pixels = ((DataBufferInt)gameContainer.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear() {

        for (int i= 0; i < pixels.length;) {

            pixels[i] = 0;

            i = i + 1;
        }
    }

    public void setPixel(int x, int y, int value) {

        if ((x < 0 || x >= width || y < 0 || y >= height) || value == 0xffff00ff) {

            return;
        }

        pixels[x + y * width] = value;
    }

    public void drawImage(@NotNull Image image, int offX, int offY) {

        for (int y = 0; y < image.getHeight(); y++) {

            for (int x = 0;  x < image.getWidth(); x++) {

                setPixel(x + offX, y + offY, image.getPixels()[x + y * image.getWidth()]);
            }
        }
    }
}
