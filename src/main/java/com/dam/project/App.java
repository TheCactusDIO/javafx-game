package com.dam.project;

import com.dam.project.engine.GameLoop;
import com.dam.project.entities.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Player player = new Player(400, 300);

        Scene scene = new Scene(new StackPane(canvas));

        // eventos de teclado
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W, UP -> player.setUp(true);
                case S, DOWN -> player.setDown(true);
                case A, LEFT -> player.setLeft(true);
                case D, RIGHT -> player.setRight(true);
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case W, UP -> player.setUp(false);
                case S, DOWN -> player.setDown(false);
                case A, LEFT -> player.setLeft(false);
                case D, RIGHT -> player.setRight(false);
            }
        });

        stage.setTitle("My DAM Game");
        stage.setScene(scene);
        stage.show();

        GameLoop loop = new GameLoop(gc, player);
        loop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
