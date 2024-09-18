package com.codes.vinis.vEngine.gfx.image.animate;

import com.codes.vinis.vEngine.utils.Dimension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Frames implements Iterable<int[]> {

    private final @NotNull Map<@NotNull Integer, int[]> frames;

    private @NotNull Dimension dimension;

    private int totalFrames = 0;

    public Frames() {

        this.frames = new HashMap<>();
    }

    private @NotNull BufferedImage loadImage(@NotNull String path) {

        @Nullable BufferedImage image = null;

        try {

            image = ImageIO.read(new File(path));
        } catch (IOException e) {

            e.printStackTrace();
        }

        assert image != null;

        return image;
    }

    public void add(int index, @NotNull String path) {

        @NotNull BufferedImage image = loadImage(path);

        setDimension(new Dimension(image.getWidth(), image.getHeight()));

        int[] pixels = image.getRGB(0, 0, getDimension().getWidth(), getDimension().getHeight(), null, 0, getDimension().getWidth());

        getFrames().put(index, pixels);

        setTotalFrames(getTotalFrames() + 1);

        image.flush();
    }

    public void remove(int index) {

        getFrames().remove(index);

        setTotalFrames(getTotalFrames() - 1);

        rearrangeFrames();
    }

    public void update(int index, @NotNull String path) {

        @NotNull BufferedImage image = loadImage(path);

        setDimension(new Dimension(image.getWidth(), image.getHeight()));

        int[] pixels = image.getRGB(0, 0, getDimension().getWidth(), getDimension().getHeight(), null, 0, getDimension().getWidth());

        getFrames().put(index, pixels);

        image.flush();
    }

    public int[] get(int index) {

        return getFrames().getOrDefault(index, null);
    }

    private void rearrangeFrames() {

        @NotNull Map<Integer, int[]> newFrames = new HashMap<>();

        int newIndex = 0;

        for (int[] pixels : frames.values()) {

            newFrames.put(newIndex++, pixels);
        }

        getFrames().clear();

        getFrames().putAll(newFrames);
    }

    @Override
    public @NotNull Iterator<int[]> iterator() {

        return getFrames().values().iterator();
    }

    public void clear() {

        getFrames().clear();

        setTotalFrames(0);
    }

    public @NotNull Map<@NotNull Integer, int[]> getFrames() {

        return frames;
    }

    public void setDimension(@NotNull Dimension dimension) {

        this.dimension = dimension;
    }

    public @NotNull Dimension getDimension() {

        return dimension;
    }

    public void setTotalFrames(int totalFrames) {

        this.totalFrames = totalFrames;
    }

    public int getTotalFrames() {

        return totalFrames;
    }
}
