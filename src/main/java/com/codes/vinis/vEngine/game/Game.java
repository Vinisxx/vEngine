package com.codes.vinis.vEngine.game;

import com.codes.vinis.vEngine.core.Core;
import com.codes.vinis.vEngine.core.Renderer;
import org.jetbrains.annotations.NotNull;

public interface Game {

    void update(@NotNull Core core, float deltaTime);

    void render(@NotNull Core core, @NotNull Renderer renderer);
}
