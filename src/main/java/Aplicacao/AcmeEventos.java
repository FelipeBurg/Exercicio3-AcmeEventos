package Aplicacao;

import com.example.exerciciodepoo.Controlador2;

import java.util.ArrayList;

public class AcmeEventos {
    CadastroEvento cadEvent = new CadastroEvento();

    public String cadT(String codigo, String data, double longitude, double latitude, double magnitude){
        Evento evento = new Terremoto(codigo, data, longitude, latitude, magnitude);
        if (cadEvent.addEvento(evento)){
            cadEvent.ordenarEventos();
            return "Terremoto cadastrado com sucesso!";
        } else {
            return "Erro: terremoto já cadastrado!";
        }
    }
    public String cadC(String codigo, String data, double longitude, double latitude, double velocidade, double preciptacao){
        Evento evento = new Ciclone(codigo, data, longitude, latitude, velocidade, preciptacao);
        if (cadEvent.addEvento(evento)){
            cadEvent.ordenarEventos();
            return "Ciclone cadastrado com sucesso!";
        } else {
            return "Erro: ciclone já cadastrado!";
        }
    }
    public String cadS(String codigo, String data, double longitude, double latitude, int seca){
        Evento evento = new Seca(codigo, data, longitude, latitude, seca);
        if (cadEvent.addEvento(evento)){
            cadEvent.ordenarEventos();
            return "Seca cadastrada com sucesso!";
        } else {
            return "Erro: seca já cadastrada!";
        }
    }
    public String mostrarEventos(){
        ArrayList<Evento> eventos = cadEvent.todosEventos();
        if (eventos != null && !eventos.isEmpty()){
            StringBuilder eventosStr = new StringBuilder();
            for (Evento evento: eventos) {
                eventosStr.append(evento.toString()).append("\n");
            }
            return eventosStr.toString();
        }
        return "Nenhum evento cadastrado";
    }
}
