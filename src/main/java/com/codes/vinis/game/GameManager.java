package com.codes.vinis.game;

import com.codes.vinis.vEngine.AbstractGame;
import com.codes.vinis.vEngine.GameContainer;
import com.codes.vinis.vEngine.Renderer;
import com.codes.vinis.vEngine.gfx.Image;
import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    private @NotNull Image image;

    public GameManager() {

        this.image = new Image("src/main/resources/person/person1.png");
    }

    @Override
    public void update(@NotNull GameContainer gameContainer, float deltaTime) {

        if (gameContainer.getInput().isKeyDown(KeyEvent.VK_A)) {
            System.out.println("A is pressed");
        }
    }

    @Override
    public void render(@NotNull GameContainer gameContainer, @NotNull Renderer renderer) {

        renderer.drawImage(image, gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY());
    }

    public static void main(String[] args) {

        @NotNull GameContainer gameContainer = new GameContainer(new GameManager());

        gameContainer.start();
    }
}
