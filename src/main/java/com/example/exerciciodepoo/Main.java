package com.example.exerciciodepoo;
import Aplicacao.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("firstScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 500);
            stage.setTitle("Cadastra Eventos");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}