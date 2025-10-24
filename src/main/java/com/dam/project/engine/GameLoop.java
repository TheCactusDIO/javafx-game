package com.dam.project.engine;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameLoop extends AnimationTimer {

    private final GraphicsContext gc;

    private long lastFrame = 0;

    // ejemplo de "estado del mundo": un cuadrado rojo que se mueve
    private double x = 100;
    private double speed = 200; // píxeles por segundo

    public GameLoop(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void handle(long now) {
        if (lastFrame == 0) {
            lastFrame = now;
            return;
        }

        // delta time en segundos (tiempo entre frames)
        double delta = (now - lastFrame) / 1_000_000_000.0;
        lastFrame = now;

        // lógica de juego
        x += speed * delta;
        if (x > 800) {
            x = 0;
        }

        // render
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 600);

        gc.setFill(Color.RED);
        gc.fillRect(x, 300, 50, 50);
    }
}
