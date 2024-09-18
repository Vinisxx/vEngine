package com.codes.vinis.vEngine.gfx.image.animate;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class Frames implements Iterable<int[]> {

    private final @NotNull Map<@NotNull Integer, int[]> frames;

    private int totalFrames = 0;

    public Frames() {

        this.frames = new HashMap<>();
    }

    public void add(int index, int[] pixels) {

        getFrames().put(index, pixels);

        setTotalFrames(getTotalFrames() + 1);
    }

    public void remove(int index) {

        getFrames().remove(index);

        setTotalFrames(getTotalFrames() - 1);

        rearrangeFrames();
    }

    public void update(int index, int[] pixels) {

        getFrames().put(index, pixels);
    }

    public int[] get(int index) {

        return getFrames().getOrDefault(index, null);

    }

    private void rearrangeFrames() {

        @NotNull Map<Integer, int[]> newFrames = new HashMap<>();

        int newIndex = 0;

        for (int[] pixels : getFrames().values()) {

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

    public @NotNull Stream<int[]> stream() {

        return getFrames().values().stream();
    }

    public @NotNull Map<@NotNull Integer, int[]> getFrames() {

        return frames;
    }

    public void setTotalFrames(int totalFrames) {

        this.totalFrames = totalFrames;
    }

    public int getTotalFrames() {

        return totalFrames;
    }
}