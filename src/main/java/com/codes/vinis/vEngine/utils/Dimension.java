package com.codes.vinis.vEngine.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Dimension {

    private int width, height;

    public Dimension(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Dimension dimension = (Dimension) o;

        return  dimension.getWidth() == getWidth() && dimension.getHeight() == getHeight();
    }

    @Override
    public int hashCode() {

        return Objects.hash(width, height);
    }

    @Override
    public @NotNull String toString() {

        return "{ \"Width\": " + getWidth() + ", \"Height\": " + getHeight() + " }";
    }
}