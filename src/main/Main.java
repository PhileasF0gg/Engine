package main;

import map.Map;

import java.awt.*;

public class Main extends Engine {

    private static Map map;

    public static void main(String[] args) {
        new Main().start(); // Creates the game engine and starts it.
        map = new Map();
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        map.draw(g);
    }
}
