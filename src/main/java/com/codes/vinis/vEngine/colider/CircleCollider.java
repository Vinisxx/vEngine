package com.codes.vinis.vEngine.colider;

import com.codes.vinis.vEngine.intefaces.Collider;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public class CircleCollider implements Collider {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    public CircleCollider(@NotNull Dimension dimension, @NotNull Location location) {

        this.dimension = dimension;

        this.location = location;
    }

    @Override
    public boolean collidesWith(@NotNull Collider other) {
        if (other instanceof @NotNull CircleCollider otherCircle) {

            int thisCenterX = this.getLocation().getX() + this.getRadius();
            int thisCenterY = this.getLocation().getY() + this.getRadius();
            int otherCenterX = otherCircle.getLocation().getX() + otherCircle.getRadius();
            int otherCenterY = otherCircle.getLocation().getY() + otherCircle.getRadius();

            int dx = thisCenterX - otherCenterX;
            int dy = thisCenterY - otherCenterY;
            int distanceSquared = dx * dx + dy * dy;
            int radiusSum = this.getRadius() + otherCircle.getRadius();
            int radiusSumSquared = radiusSum * radiusSum;

            return distanceSquared < radiusSumSquared;
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


    public int getRadius() {

        return Math.min(getDimension().getWidth(), getDimension().getHeight()) / 2;
    }

    @Override
    public void update() {

    }
}