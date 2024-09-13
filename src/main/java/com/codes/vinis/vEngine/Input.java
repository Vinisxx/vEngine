package com.codes.vinis.vEngine;

import org.jetbrains.annotations.NotNull;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private @NotNull GameContainer gameContainer;
    private final int NUMBERS_KEYS = 256;
    private boolean[] keys = new boolean[NUMBERS_KEYS];
    private boolean[] keysLast = new boolean[NUMBERS_KEYS];

    private final int NUMBERS_BUUTTONS = 5;
    private boolean[] buttons = new boolean[NUMBERS_KEYS];
    private boolean[] buttonsLast = new boolean[NUMBERS_KEYS];

    private int mouseX, mouseY;
    private int scroll;

    public Input(@NotNull GameContainer gameContainer) {

        this.gameContainer = gameContainer;

        this.mouseX = 0;
        this.mouseY = 0;
        this.scroll = 0;

        gameContainer.getWindow().getCanvas().addKeyListener(this);
        gameContainer.getWindow().getCanvas().addMouseListener(this);
        gameContainer.getWindow().getCanvas().addMouseMotionListener(this);
        gameContainer.getWindow().getCanvas().addMouseWheelListener(this);
    }

    public void update() {

        scroll = 0;

        for (int i = 0; i < NUMBERS_KEYS;) {

            keysLast[i] = keys[i];

            i = i + 1;
        }

        for (int i = 0; i < NUMBERS_BUUTTONS;) {

            buttonsLast[i] = buttons[i];

            i = i + 1;
        }
    }

    public boolean isKey(int keyCode) {

        return keys[keyCode];
    }

    public boolean isKeyUp(int keyCode) {

        return !keys[keyCode] && keysLast[keyCode];
    }

    public boolean isKeyDown(int keyCode) {

        return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isButton(int button) {

        return buttons[button];
    }

    public boolean isButtonUp(int button) {

        return !buttons[button] && buttonsLast[button];
    }

    public boolean isButtonDown(int button) {

        return buttons[button] && !buttonsLast[button];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(@NotNull KeyEvent e) {

        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(@NotNull KeyEvent e) {

        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(@NotNull MouseEvent e) {

        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(@NotNull MouseEvent e) {

        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(@NotNull MouseEvent e) {

        mouseX = (int) (e.getX() / gameContainer.getScale());
        mouseY = (int) (e.getY() / gameContainer.getScale());
    }

    @Override
    public void mouseMoved(@NotNull MouseEvent e) {

        mouseX = (int) (e.getX() / gameContainer.getScale());
        mouseY = (int) (e.getY() / gameContainer.getScale());
    }

    @Override
    public void mouseWheelMoved(@NotNull MouseWheelEvent e) {

        scroll = e.getWheelRotation();
    }

    public int getScroll() {

        return scroll;
    }

    public int getMouseX() {

        return mouseX;
    }

    public int getMouseY() {

        return mouseY;
    }
}