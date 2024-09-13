package com.codes.vinis.vEngine;

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

            pixels[i] += i;

            i = i + 1;
        }
    }
}
