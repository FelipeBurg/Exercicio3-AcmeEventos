package Aplicacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CadastroEvento {
    private ArrayList<Evento> eventos;
    private Terremoto terremoto;
    private Ciclone ciclone;
    private Seca seca;
    public CadastroEvento(){eventos = new ArrayList<Evento>();}
    public boolean addEvento(Evento evento){
        if ((consultaPorCodigo(evento.getCodigo()) == null)){
            eventos.add(evento);
            return true;
        }
        return false;
    }
    public Evento consultaPorCodigo(String codigo){
        for(Evento e : eventos){
            if (e.getCodigo().equals(codigo)){
                if (e instanceof Terremoto){
                    return (Terremoto) e;
                }
                if (e instanceof Ciclone){
                    return (Ciclone) e;
                }
                if (e instanceof Seca){
                    return (Seca) e;
                }
            }
        }
        return null;
    }
    public void ordenarEventos() {
        Collections.sort(eventos, Comparator.comparing(Evento::getCodigo));
    }
    public ArrayList<Evento> todosEventos() {
        return eventos;
    }
}
