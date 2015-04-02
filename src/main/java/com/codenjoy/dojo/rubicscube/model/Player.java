package com.codenjoy.dojo.rubicscube.model;

import com.codenjoy.dojo.rubicscube.services.RubicsCubeEvents;
import com.codenjoy.dojo.services.EventListener;
import com.codenjoy.dojo.services.Joystick;

public class Player {

    private EventListener listener;
    private int maxScore;
    private int score;
    private Joystick joystick;

    public Player(EventListener listener) {
        this.listener = listener;
        clearScore();
    }

    private void increaseScore() {
        score = score + 1;
        maxScore = Math.max(maxScore, score);
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getScore() {
        return score;
    }

    public void event(RubicsCubeEvents event) {
        switch (event) {
            case FAIL: gameOver(); break;
            case SUCCESS: increaseScore(); break;
        }

        if (listener != null) {
            listener.event(event);
        }
    }

    private void gameOver() {
        score = 0;
    }

    public void clearScore() {
        score = 0;
        maxScore = 0;
    }

    public Joystick getJoystick() {
        return joystick;
    }

    public void newHero(Field field) {
        joystick = field.getJoystick();
    }
}