package com.codes.vinis.vEngine;

import org.jetbrains.annotations.NotNull;

public class GameContainer implements Runnable{

    private @NotNull Thread thread;

    private @NotNull Window window;

    private boolean running = false;

    private final double UPDATE_CAP = 1.0 / 60.0;

    private int width = 320, height = 240;

    private float scale = 2f;

    private @NotNull String title = "vEngine v0.0.1";

    public GameContainer() {

    }

    public void start() {

        this.thread = new Thread(this);

        this.window = new Window(this);

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

                //todo: update game

                if (frameTime >= 1.0) {

                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println( "FPS: " + fps);
                }
            }

            if (render) {

                this.window.update();
                frames = frames + 1;

                //todo: render game
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

    public static void main(String[] args) {

        @NotNull GameContainer gc = new GameContainer();

        gc.start();
    }
}
