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

    public void clear




    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
    }
}