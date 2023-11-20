package Aplicacao;

public class Terremoto extends Evento{
    private double magnitude;
    public Terremoto(String codigo, String data, double longitude, double latitude, double magnitude){
        super(codigo, data, longitude, latitude);
        this.magnitude = magnitude;
    }
    public double getMagnitude(){
        return magnitude;
    }

    @Override
    public String toString() {
        return "Terremoto\n" + super.toString()+ String.format("Magnitude: %.2f\n" +
                "====================\n",magnitude);
    }
}
