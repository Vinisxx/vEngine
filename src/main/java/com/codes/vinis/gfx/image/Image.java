package com.codes.vinis.gfx.image;

import com.codes.vinis.utils.Dimension;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {

    private @NotNull Dimension dimension;

    private @NotNull BufferedImage bufferedImage;

    public Image(@NotNull String URL, @NotNull Dimension dimension) {

        try {

            this.bufferedImage = ImageIO.read(new File(URL));

            this.dimension = dimension;
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public @NotNull Dimension getDimension() {

        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {

        this.dimension = dimension;
    }

    public @NotNull BufferedImage getBufferedImage() {

        return bufferedImage;
    }

    public void setBufferedImage(@NotNull BufferedImage bufferedImage) {

        this.bufferedImage = bufferedImage;
    }
}
