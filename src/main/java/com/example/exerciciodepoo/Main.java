package com.example.exerciciodepoo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Parent painel1;
    private Controlador controlador1;

    private Scene cena;
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader loader1 = new FXMLLoader();
            painel1 = (Parent) loader1.load(getClass().getResource("firstScene.fxml").openStream());
            controlador1 = (Controlador)  loader1.getController();
            controlador1.setMain(this);
            stage.getIcons().add(new Image("https://w7.pngwing.com/pngs/787/632/png-transparent-tornado-fire-wind-natural-catastrophe-weather-weather-icon.png"));
            cena = new Scene(painel1,600,700);
            stage.setTitle("Cadastra Eventos");
            stage.setScene(cena);
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