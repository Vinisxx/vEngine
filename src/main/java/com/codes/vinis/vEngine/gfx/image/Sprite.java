package com.codes.vinis.vEngine.gfx.image;

import com.codes.vinis.vEngine.intefaces.Renderable;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite implements Renderable {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    private int[] pixels;

    private int currentDirectionX = 1;

    private int currentDirectionY = 1;

    public Sprite(@NotNull String path, @NotNull Location location) {

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

    public void invertX(int direction){

        if (direction == getCurrentDirectionX()) {

            return;
        }

        for (int y = 0; y < getDimension().getHeight(); ) {

            for (int x = 0; x < getDimension().getWidth() / 2; ) {

                int oppositeX = getDimension().getWidth() - 1 - x;

                int temp = pixels[x + y * getDimension().getWidth()];

                pixels[x + y * getDimension().getWidth()] = pixels[oppositeX + y * getDimension().getWidth()];
                pixels[oppositeX + y * getDimension().getWidth()] = temp;

                x = x + 1;
            }

            y = y + 1;
        }

        setCurrentDirectionX(direction);
    }

    public void invertY(int direction) {
        if (direction == getCurrentDirectionY()) {
            return;
        }

        for (int y = 0; y < getDimension().getHeight() / 2; ) {

            for (int x = 0; x < getDimension().getWidth(); ) {

                int oppositeY = getDimension().getHeight() - 1 - y;

                int temp = pixels[x + y * getDimension().getWidth()];

                pixels[x + y * getDimension().getWidth()] = pixels[x + oppositeY * getDimension().getWidth()];
                pixels[x + oppositeY * getDimension().getWidth()] = temp;

                x = x + 1;
            }

            y = y + 1;
        }

        setCurrentDirectionY(direction);
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

    public int getCurrentDirectionY() {

        return currentDirectionY;
    }

    public void setCurrentDirectionY(int currentDirectionY) {

        this.currentDirectionY = currentDirectionY;
    }

    public int getCurrentDirectionX() {

        return currentDirectionX;
    }

    public void setCurrentDirectionX(int currentDirectionX) {

        this.currentDirectionX = currentDirectionX;
    }
}
