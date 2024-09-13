package com.codes.vinis.vEngine;

import org.jetbrains.annotations.NotNull;

public abstract class AbstractGame {

    public abstract void update(@NotNull GameContainer gameContainer, float deltaTime);

    public abstract void render(@NotNull GameContainer gameContainer, @NotNull Renderer renderer);
}