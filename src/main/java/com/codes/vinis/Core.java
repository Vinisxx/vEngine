package com.codes.vinis;

import org.jetbrains.annotations.NotNull;

public class Core implements Runnable{

    private @NotNull Thread thread;

    private boolean running;

    public Core() {

    }

    public void start() {

        setRunning(true);

        this.thread = new Thread(this);

        this.thread.run();
    }

    public void stop() {


        setRunning(false);

        this.thread.stop();
    }

    public void run() {

        double update_cap = 1.0 / 60.0;
        double firstTime = 0;
        double lastTime = System.nanoTime();
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

        }
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
}
