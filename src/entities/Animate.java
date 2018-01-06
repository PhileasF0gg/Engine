package entities;

import main.Engine;

public class Animate {

    private float fI; // The intervals at which the animation should be updated.
    private int updateCounter; // Keeps track of how many updates have occurred.
    private int animPhase; // The current frame of the animation.
    private boolean active;
    private int f; // Amount of frames shown in the animation.

    public Animate(int frames, float seconds) {
        fI = (Engine.FPS * seconds) / frames;
        f = frames;
        active = false;
    }

    public void update() {
        if(active) {
            updateCounter++;
            if (updateCounter > Engine.FPS) {
                // Resets the animation phase and update counter after a full second.
                updateCounter = 0;
                animPhase = 0;
            }
            if (updateCounter / fI >= 1 && updateCounter % fI == 0 && animPhase < Engine.FPS) {
                animPhase++;
                if(animPhase > f - 1) {
                    animPhase = 0;
                }
            }
        }
    }

    public void start() {
        updateCounter = 0;
        animPhase =  0;
        active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void stop() {
        active = false;
    }

    public int getAnimPhase() {
        return animPhase;
    }
}
