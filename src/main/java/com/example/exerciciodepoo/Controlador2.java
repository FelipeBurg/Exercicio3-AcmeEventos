package com.example.exerciciodepoo;
import Aplicacao.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controlador2 {
    private Main main;
    @FXML
    private Label labelEventos;
    AcmeEventos acmeEventos = new AcmeEventos();

    public void setMain(Main main){
        this.main = main;
    }
    public void mostrarDados() {
        String eventosStr = acmeEventos.mostrarEventos();
        labelEventos.setText(eventosStr);
    }
    public void mudarCena(ActionEvent actionEvent) {
        main.mudar(1);
    }
}
