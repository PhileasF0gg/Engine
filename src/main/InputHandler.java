package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class InputHandler extends KeyAdapter {

    private static String inputStatus = ""; // Only to be used for simple key presses. Game controls will have their own variables.
    private static boolean devMode = false,
            keyUnstuck = true,
            left = false,
            right = false,
            up = false,
            down = false,
            zoomIn = false,
            zoomOut = false;

    @Override
    public void keyPressed(KeyEvent e) {
        inputStatus = e.getKeyCode() + "_pressed";
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
            zoomIn = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_MINUS) {
            zoomOut = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputStatus = e.getKeyCode() + "_released";
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
            zoomIn = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_MINUS) {
            zoomOut = false;
        }
    }

    public static String getInputStatus() {
        return inputStatus;
    }

    public static boolean isDevMode() {
        if(getInputStatus().equals(192 + "_pressed") && keyUnstuck) {
            if(devMode) {
                devMode = false;
            }else if(!devMode) {
                devMode = true;
            }
            keyUnstuck = false;
        }
        if(getInputStatus().equals(192 + "_released")) {
            keyUnstuck = true;
        }
        return devMode;
    }

    public static boolean upPressed() {
        return up;
    }

    public static boolean downPressed() {
        return down;
    }

    public static boolean leftPressed() {
        return left;
    }

    public static boolean rightPressed() { return right; }

    public static boolean zoomInPressed() { return zoomIn; }

    public static boolean zoomOutPressed() { return zoomOut; }

}
