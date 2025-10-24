package com.dam.project.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {
    private double x, y;
    private double speed = 300; // píxeles por segundo
    private final double size = 40;

    // estados del teclado
    private boolean up, down, left, right;

    public Player(double startX, double startY) {
        this.x = startX;
        this.y = startY;
    }

    public void update(double delta) {
        double dx = 0, dy = 0;

        if (up) dy -= speed * delta;
        if (down) dy += speed * delta;
        if (left) dx -= speed * delta;
        if (right) dx += speed * delta;

        x += dx;
        y += dy;

        // límites de pantalla (800x600)
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x + size > 800) x = 800 - size;
        if (y + size > 600) y = 600 - size;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, size, size);
    }

    // setters del estado de teclas
    public void setUp(boolean value)    { up = value; }
    public void setDown(boolean value)  { down = value; }
    public void setLeft(boolean value)  { left = value; }
    public void setRight(boolean value) { right = value; }
}
