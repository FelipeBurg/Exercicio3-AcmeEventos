package Aplicacao;

public class Seca extends Evento{
    private int seca;
    public Seca(String codigo, String data, double longitude, double latitude, int seca) {
        super(codigo, data, longitude, latitude);
        this.seca = seca;
    }
    public int getSeca(){
        return seca;
    }
    public String toString() {
        return "Seca\n" + super.toString()+ String.format("""
                Seca: %d
                ==================================""",seca);
    }
}
