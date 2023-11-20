package com.example.exerciciodepoo;
import Aplicacao.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private AcmeEventos acmeEventos;
    private Parent painel1;
    private Parent painel2;
    private Controlador controlador1;
    private Controlador2 controlador2;
    private Scene cena;
    public AcmeEventos getAcmeEventos(){
        return acmeEventos;
    }
    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader loader1 = new FXMLLoader();
            painel1 = (Parent) loader1.load(getClass().getResource("firstScene.fxml").openStream());
            controlador1 = (Controlador)  loader1.getController();
            controlador1.setMain(this);

            FXMLLoader loader2 = new FXMLLoader();
            painel2 = (Parent) loader2.load(getClass().getResource("secondScene.fxml").openStream());
            controlador2 = (Controlador2)  loader2.getController();
            controlador2.setMain(this);
            cena = new Scene(painel1,600,500);
            stage.setTitle("Cadastra Eventos");
            stage.setScene(cena);
            stage.show();
        }
        catch (Exception e){
            System.out.println("Erro: "+ e);
        }
    }
    public void mudar(int painel) {
        switch (painel) {
            case 1:
                cena.setRoot(painel1);
                break;
            case 2:
                controlador2.mostrarDados();
                cena.setRoot(painel2);
                break;
        }
    }
    public static void main(String[] args) {
        launch();
    }
}