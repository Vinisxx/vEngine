package com.codes.vinis.vEngine.intefaces;

import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public interface Renderable {

    @NotNull Dimension getDimension();

    @NotNull Location getLocation();

    int[] getPixels();
}
