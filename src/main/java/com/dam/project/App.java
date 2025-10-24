package com.dam.project;

import com.dam.project.engine.GameLoop;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Creamos el canvas del juego
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Fondo inicial
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 600);

        // Texto inicial
        gc.setFill(Color.WHITE);
        gc.fillText("JavaFX Game Engine Init OK", 20, 40);

        // Escena JavaFX normal
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        stage.setTitle("My DAM Game");
        stage.setScene(scene);
        stage.show();

        // 🔥 Arrancamos el bucle de juego
        GameLoop loop = new GameLoop(gc);
        loop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
