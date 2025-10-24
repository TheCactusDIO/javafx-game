package com.dam.project.engine;

import com.dam.project.entities.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameLoop extends AnimationTimer {

    private final GraphicsContext gc;
    private final Player player;
    private long lastFrame = 0;

    public GameLoop(GraphicsContext gc, Player player) {
        this.gc = gc;
        this.player = player;
    }

    @Override
    public void handle(long now) {
        if (lastFrame == 0) {
            lastFrame = now;
            return;
        }

        double delta = (now - lastFrame) / 1_000_000_000.0;
        lastFrame = now;

        // actualizar jugador
        player.update(delta);

        // render
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 600);

        player.render(gc);
    }
}
