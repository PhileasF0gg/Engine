package main;

import map.Map;

import java.awt.*;

public class Main extends Engine {

    private static Map map;

    public static void main(String[] args) {
        map = new Map();
        map.setCurrentMap(0);
        new Main().start(); // Creates the game engine and starts it.
    }

    @Override
    public void update() {
        map.update();
    }

    @Override
    public void draw(Graphics g) {
        map.draw(g);
        if(InputHandler.isDevMode()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(getDevDetails(), 20, 50);
            g.drawString(map.getPlayerLoc(), 20, 70);
        }
    }
}
