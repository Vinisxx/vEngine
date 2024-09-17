package com.codes.vinis.vEngine.input;

import com.codes.vinis.vEngine.window.Window;
import org.jetbrains.annotations.NotNull;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private final @NotNull Window WINDOW;
    private final int NUMBERS_KEY = 256;
    private boolean[] keys = new boolean[NUMBERS_KEY];
    private boolean[] keysLast = new boolean[NUMBERS_KEY];

    private final int NUMBERS_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUMBERS_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUMBERS_BUTTONS];

    private int mouseX, mouseY;
    private int mouseScroll;

    public Input(@NotNull Window window) {

        this.WINDOW = window;

        this.mouseX = 0;
        this.mouseY = 0;
        this.mouseScroll = 0;

        this.WINDOW.getFRAME().addKeyListener(this);
        this.WINDOW.getFRAME().addMouseListener(this);
        this.WINDOW.getFRAME().addMouseMotionListener(this);
        this.WINDOW.getFRAME().addMouseWheelListener(this);
    }

    public void update() {

        setMouseScroll(0);

        for (int i = 0; i < getNUMBERS_KEY();) {

            keysLast[i] = keys[i];

            i = i + 1;
        }

        for (int i = 0; i < NUMBERS_BUTTONS;) {

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

        setMouseX((e.getX() / WINDOW.getDimension().getWidth()));
        setMouseY((e.getY() / WINDOW.getDimension().getHeight()));
    }

    @Override
    public void mouseMoved(@NotNull MouseEvent e) {

        setMouseX((e.getX() / WINDOW.getDimension().getWidth()));
        setMouseY((e.getY() / WINDOW.getDimension().getHeight()));
    }

    @Override
    public void mouseWheelMoved(@NotNull MouseWheelEvent e) {

         setMouseScroll(e.getWheelRotation());
    }

    public int getNUMBERS_KEY() {

        return NUMBERS_KEY;
    }

    public boolean[] getKeys() {

        return keys;
    }

    public void setKeys(boolean[] keys) {

        this.keys = keys;
    }

    public boolean[] getKeysLast() {

        return keysLast;
    }

    public void setKeysLast(boolean[] keysLast) {

        this.keysLast = keysLast;
    }

    public int getNUMBERS_BUTTONS() {

        return NUMBERS_BUTTONS;
    }

    public boolean[] getButtons() {

        return buttons;
    }

    public void setButtons(boolean[] buttons) {

        this.buttons = buttons;
    }

    public boolean[] getButtonsLast() {

        return buttonsLast;
    }

    public void setButtonsLast(boolean[] buttonsLast) {

        this.buttonsLast = buttonsLast;
    }

    public int getMouseX() {

        return mouseX;
    }

    public void setMouseX(int mouseX) {

        this.mouseX = mouseX;
    }

    public int getMouseY() {

        return mouseY;
    }

    public void setMouseY(int mouseY) {

        this.mouseY = mouseY;
    }

    public int getMouseScroll() {

        return mouseScroll;
    }

    public void setMouseScroll(int mouseScroll) {

        this.mouseScroll = mouseScroll;
    }
}
