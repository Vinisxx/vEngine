package com.codes.vinis.vEngine.core;

import com.codes.vinis.vEngine.input.Input;
import com.codes.vinis.vEngine.utils.Dimension;
import com.codes.vinis.vEngine.window.Window;
import game.GameManager;
import org.jetbrains.annotations.NotNull;

public class Core implements Runnable{

    private @NotNull Thread thread;

    private final @NotNull Window WINDOW;

    private final @NotNull Input INPUT;

    private final @NotNull GameManager GAME_MANAGER;

    private boolean running;

    public Core(@NotNull Window window) {

        this.WINDOW = window;

        this.INPUT = new Input(getWindow());

        this.GAME_MANAGER = new GameManager();
    }

    public void start() {

        setRunning(true);

        this.thread = new Thread(this);

        this.thread.start();
    }

    public void stop() {

        setRunning(false);

        this.thread.stop();
    }

    public void run() {

        double update_cap = 1.0 / 60.0;
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

            while (unprocessedTime >= update_cap) {

                unprocessedTime = unprocessedTime - update_cap;
                
                render = true;

                this.GAME_MANAGER.update(this, (float) update_cap);

                this.INPUT.update();

                if (frameTime >= 1.0) {

                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println(fps);
                }

                if (render) {

                    this.GAME_MANAGER.render(this, this.getWindow().getRenderer());
                    this.WINDOW.update();

                    frames = frames + 1;
                } else {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }

        dispose();
    }

    public void dispose() {

        //todo: create dispose logic
    }

    public @NotNull Thread getThread() {
        return thread;
    }

    public void setThread(@NotNull Thread thread) {
        this.thread = thread;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public @NotNull Window getWindow() {
        return WINDOW;
    }

    public @NotNull GameManager getGAME_MANAGER() {
        return GAME_MANAGER;
    }

    public @NotNull Input getINPUT() {
        return INPUT;
    }

    public @NotNull Window getWINDOW() {
        return WINDOW;
    }
}