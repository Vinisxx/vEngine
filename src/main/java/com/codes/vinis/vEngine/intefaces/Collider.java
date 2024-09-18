package com.codes.vinis.vEngine.intefaces;

import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public interface Collider {

    boolean collidesWith(@NotNull Collider other);

    @NotNull Location getLocation();
    void setLocation(@NotNull Location location);

    @NotNull Dimension getDimension();
    void setDimension(@NotNull Dimension dimension);

    void update();
}