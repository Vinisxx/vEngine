package com.codes.vinis.vEngine.colider;

import com.codes.vinis.vEngine.intefaces.Collider;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public class BoxCollider implements Collider {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    public BoxCollider(@NotNull Dimension dimension, @NotNull Location location) {

        this.dimension = dimension;

        this.location = location;
    }

    @Override
    public boolean collidesWith(@NotNull Collider other) {
        if (other instanceof @NotNull BoxCollider otherBox) {

            int thisLeft = this.getLocation().getX();
            int thisRight = this.getLocation().getX() + this.getDimension().getWidth();
            int thisTop = this.getLocation().getY();
            int thisBottom = this.getLocation().getY() + this.getDimension().getHeight();

            int otherLeft = otherBox.getLocation().getX();
            int otherRight = otherBox.getLocation().getX() + otherBox.getDimension().getWidth();
            int otherTop = otherBox.getLocation().getY();
            int otherBottom = otherBox.getLocation().getY() + otherBox.getDimension().getHeight();

            return thisRight > otherLeft && thisLeft < otherRight &&
                    thisBottom > otherTop && thisTop < otherBottom;
        }
        return false;
    }


    @Override
    public @NotNull Location getLocation() {

        return location;
    }

    @Override
    public void setLocation(@NotNull Location location) {

        this.location = location;
    }

    @Override
    public @NotNull Dimension getDimension() {

        return dimension;
    }

    @Override
    public void setDimension(@NotNull Dimension dimension) {

        this.dimension = dimension;
    }

    @Override
    public void update() {

    }
}