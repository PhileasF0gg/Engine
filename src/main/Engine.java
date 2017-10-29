package main;

import map.TileMap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Engine extends Canvas implements Runnable {

    private static final String TITLE = "Game"; // The title that is shown on the frame window.
    public static final int WIDTH = 800, HEIGHT = 600, FPS = 60; // The dimensions and frame rate of the game.
    private boolean running; // Running is true if the game is running.
    private String devDetails = "Empty";


    public Engine() {
        JFrame frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setResizable(false); // Disables the ability to resize the window.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT); // Sets the dimensions for the canvas.
        frame.add(this);
        frame.pack(); // Wraps the window around the canvas to the correct size.
        frame.setLocationRelativeTo(null); // Moves the window to the center of the screen.
        frame.setFocusable(true);
        frame.addKeyListener(new InputHandler());
        frame.setVisible(true);
    }

    protected void start() {
        new Thread(this).start(); // Creates a new thread for the game to run on.
        running = true;
    }

    private void stop() {
        running = false;
        Thread.currentThread().stop(); // Terminates the currently running thread.
    }

    @Override
    public void run() {
        double nsPerTick = 1000000000.0d/FPS; // The nano second intervals at which the game updates.
        double delta = 0; // How many updates are needed.
        double now = System.nanoTime(); // Current time in nano seconds.
        double then = now; // Keeps track of the last time the game updated.
        long lastTimer = System.currentTimeMillis();
        boolean canRender; // Keeps track of whether the game should render or not.
        int updates = 0; // Holds the updates per second.
        int frames = 0; // Holds the frames per second.

        while(running) {
            canRender = false; // Disables rendering temporarily so the game can update.
            now = System.nanoTime();
            delta += (now - then) / nsPerTick; // Calculates how many updates are needed.
            then = now;

            while(delta > 0) {
                updates++;
                delta--;
                update();
                canRender = true; // The game can now render because the updates are finished.
            }

            if(canRender) {
                frames++;
                render();
            }

            try {
                Thread.sleep(2); // Gives the computer time for other processes.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(System.currentTimeMillis() - lastTimer >= 5000) {
                lastTimer += 5000;
                updates /= 5; // Calculates the average update rate over five seconds.
                frames /= 5; // Calculates the average frame rate over five seconds.
                devDetails = "Updates: " + updates + ", Frames: " + frames;
                System.out.printf(devDetails);
                updates = 0;
                frames = 0;
            }
        }
    }

    public void update() {

    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) { // If there is no buffer strategy then one is created.
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT); // Covers the screen with a black background.
        draw(g);
        if(InputHandler.isDevMode()) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g.drawString(devDetails, 20, 50);
        }
        bs.show();
        g.dispose();
    }

    public void draw(Graphics g) {

    }

}
