package com.codes.vinis.vEngine;

import com.codes.vinis.vEngine.intefaces.Collider;
import com.codes.vinis.vEngine.intefaces.Renderable;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Entity {

    private @NotNull Dimension dimension;

    private @NotNull Location location;

    private @Nullable Collider collider;

    private @Nullable Renderable sprite;

    public Entity(@NotNull Dimension dimension, @NotNull Location location) {

        this.dimension = dimension;
        this.location = location;
    }

    public void update() {

        if (getSprite() != null) {

            getSprite().update();

            getSprite().setLocation(getLocation());

            setDimension(getSprite().getDimension());
        }

        if (getCollider() != null) {

            getCollider().setLocation(getLocation());

            getCollider().setDimension(getDimension());
        }
    }

    public @NotNull Dimension getDimension() {
        return dimension;
    }

    public void setDimension(@NotNull Dimension dimension) {
        this.dimension = dimension;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
    }

    public @Nullable Collider getCollider() {
        return collider;
    }

    public void setCollider(@Nullable Collider collider) {
        this.collider = collider;
    }

    public @Nullable Renderable getSprite() {
        return sprite;
    }

    public void setSprite(@Nullable Renderable sprite) {
        this.sprite = sprite;
    }
}
