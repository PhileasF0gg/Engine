package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {

    private static String inputStatus = "";
    private static boolean devMode = false, keyUnstuck = true;

    @Override
    public void keyPressed(KeyEvent e) {
        inputStatus = e.getKeyCode() + "_pressed";
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputStatus = e.getKeyCode() + "_released";
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
}
