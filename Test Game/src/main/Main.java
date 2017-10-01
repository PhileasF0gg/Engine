package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main extends Canvas implements Runnable {

    private static final int WIDTH = 800, HEIGHT = 600, FPS = 60;
    private boolean running = false;

    private Main() {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        this.setSize(WIDTH, HEIGHT);
        frame.add(this);
        frame.pack();
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void start() {
        new Thread(this).start();
        running = true;
    }

    private void stop() {
        running = false;
    }

    public static void main(String[] args) {
        new Main().start();
    }

    @Override
    public void run() {
        double delta = 0, nsPerTick = 1000000000.0d/FPS,
                now = System.nanoTime(), then = now;
        long lastTime = System.currentTimeMillis();
        int updates = 0, frames = 0;
        boolean canRender;
        while(running) {
            canRender = false;
            now = System.nanoTime();
            delta += (now - then) / nsPerTick;
            then = now;

            while(delta > 0) {
                delta--;
                updates++;
                update();
                canRender = true;
            }

            if(canRender) {
                frames++;
                render();
            }

            if(System.currentTimeMillis() - lastTime >= 5000) {
                lastTime += 5000;
                updates /= 5;
                frames /=5;
                System.out.printf("Updates: %d, Frames: %d\n", updates, frames);
                updates = 0;
                frames = 0;
            }
        }
    }

    private void update() {
        System.out.println("Hello_world");
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        draw(g);
        bs.show();
        g.dispose();
    }

    private void draw(Graphics g) {

    }
}
