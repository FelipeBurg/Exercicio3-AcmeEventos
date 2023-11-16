package Aplicacao;
import com.example.exerciciodepoo.*;
import javafx.scene.control.Alert;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AcmeEventos {
    CadastroEvento cadEvent = new CadastroEvento();

    public String cadT(String codigo, String data, double longitude, double latitude, double magnitude){
        Evento evento = new Terremoto(codigo, data, longitude, latitude, magnitude);
        if (cadEvent.addEvento(evento)){
            return "Terremoto cadastrado com sucesso!";
        } else {
            return "Erro: terremoto já cadastrado!";
        }
    }
    public String cadC(String codigo, String data, double longitude, double latitude, double velocidade, double preciptacao){
        Evento evento = new Ciclone(codigo, data, longitude, latitude, velocidade, preciptacao);
        if (cadEvent.addEvento(evento)){
            return "Ciclone cadastrado com sucesso!";
        } else {
            return "Erro: ciclone já cadastrado!";
        }
    }
    public String cadS(String codigo, String data, double longitude, double latitude, int seca){
        Evento evento = new Seca(codigo, data, longitude, latitude, seca);
        if (cadEvent.addEvento(evento)){
            return "Seca cadastrada com sucesso!";
        } else {
            return "Erro: seca já cadastrada!";
        }
    }
    public void mostrarEventos(){
        System.out.println("=====Todos eventos cadastrados======");
        if (cadEvent.todosEventos() != null){
            System.out.println(cadEvent.todosEventos());
        }
        else {
            System.out.println("Nenhum evento cadastrado");
        }
    }



}
