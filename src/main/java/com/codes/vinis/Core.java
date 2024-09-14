package com.codes.vinis;

import com.codes.vinis.dimension.Dimension;
import com.codes.vinis.window.Window;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class Core implements Runnable{

    private @NotNull Thread thread;

    private @NotNull Window window;

    private boolean running;

    public Core(@NotNull String title, @NotNull Dimension windowDimension) {

        this.window = new Window(title, windowDimension, new JPanel());
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
                
                if (frameTime >= 1.0) {

                    frameTime = 0;
                    fps = frames;
                    frames = 0;

                    System.out.println("FPS: " + fps);
                }

                if (render) {

                    //todo: create render

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

    public static void main(String[] args) {

        @NotNull Core core = new Core("my window", new Dimension(720, 640));

        core.start();
    }
}