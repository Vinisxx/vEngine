package com.codes.vinis.vEngine.core;

import com.codes.vinis.vEngine.intefaces.Element;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.window.Window;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.image.DataBufferInt;
import java.util.HashMap;
import java.util.Map;

public class Renderer extends JPanel {

    private @NotNull Dimension dimension;

    private int[] pixels;

    public Renderer(@NotNull Dimension dimension, @NotNull Window window) {

        this.dimension = dimension;

        this.pixels = ((DataBufferInt)window.getIMAGE().getRaster().getDataBuffer()).getData();
    }

    public void clear() {

        for (int i = 0; i < getPixels().length; ) {

            this.pixels[i] = 0;

            i = i + 1;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
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