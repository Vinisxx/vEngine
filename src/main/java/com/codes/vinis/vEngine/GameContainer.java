package com.codes.vinis.vEngine;

import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameContainer implements Runnable{

    private @NotNull Thread thread;

    private @NotNull Window window;

    private @NotNull Renderer renderer;

    private @NotNull Input input;

    private @NotNull AbstractGame game;

    private boolean running = false;

    private final double UPDATE_CAP = 1.0 / 60.0;

    private int width = 320, height = 320;

    private float scale = 1.5f;

    private @NotNull String title = "vEngine v0.0.1";

    public GameContainer(@NotNull AbstractGame game) {

        this.game = game;
    }

    public void start() {

        this.window = new Window(this);

        this.renderer = new Renderer(this);

        this.input = new Input(this);

        this.thread = new Thread(this);

        this.thread.run();
    }

    public void stop() {

        this.thread.stop();

        this.running = false;
    }

    public void run() {

        this.running = true;

        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (running) {

            boolean render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime = unprocessedTime + passedTime;

            frameTime = frameTime + passedTime;

            while (unprocessedTime >= UPDATE_CAP) {

                unprocessedTime = unprocessedTime - UPDATE_CAP;

                render = true;

                this.game.update(this, (float) UPDATE_CAP);
                this.input.update();

                if (frameTime >= 1.0) {

                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println( "FPS: " + fps);
                }
            }

            if (render) {

                this.renderer.clear();

                this.game.render(this, renderer);

                this.window.update();

                frames = frames + 1;
            } else {

                try {

                    Thread.sleep(1);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }

        dispose();
    }

    private void dispose() {

        //todo: create a code of dispose
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public @NotNull Window getWindow() {
        return window;
    }

    public @NotNull Input getInput() {
        return input;
    }
}
