package com.codes.vinis.vEngine.gfx.image.animate;

import com.codes.vinis.vEngine.intefaces.Renderable;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.utils.Location;
import org.jetbrains.annotations.NotNull;

public class AnimateSprite implements Renderable {

    private @NotNull Location location;

    private final @NotNull Frames frames;

    private int currentFrame = 0;

    private int frameDuration;

    private long lastFrameTime = 0;

    public AnimateSprite(int fps, @NotNull Location location) {

        this.frames = new Frames();

        this.location = location;

        this.frameDuration = 1000 / fps;
    }

    public @NotNull Frames getFrames() {

        return frames;
    }

    public void update(long currentTime) {

        if (currentTime - getLastFrameTime() >= getFrameDuration()) {

            setCurrentFrame((getCurrentFrame() + 1) % getFrames().getTotalFrames());

            setLastFrameTime(currentTime);
        }
    }

    @Override
    public @NotNull Dimension getDimension() {

        return getFrames().getDimension();
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

        return getFrames().get(getCurrentFrame());
    }

    @Override
    public void update() {}

    public int getCurrentFrame() {

        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {

        this.currentFrame = currentFrame;
    }

    public int getFrameDuration() {

        return frameDuration;
    }

    public void setFrameDuration(int frameDuration) {

        this.frameDuration = 1000 / frameDuration;
    }

    public long getLastFrameTime() {

        return lastFrameTime;
    }

    public void setLastFrameTime(long lastFrameTime) {

        this.lastFrameTime = lastFrameTime;
    }

    public void invertX(int direction) {

        getFrames().invertX(direction);
    }

    public void invertY(int direction) {

        getFrames().invertY(direction);
    }
}