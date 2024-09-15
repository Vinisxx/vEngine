package com.codes.vinis.vEngine.window;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class ResponsivePanel extends JPanel{

    public ResponsivePanel() {

        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                resizeComponents();
                revalidate();
                repaint();
            }
        });
    }

    public abstract void resizeComponents();

    //thanks G4MER :3
}