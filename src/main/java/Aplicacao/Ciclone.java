package Aplicacao;

public class Ciclone extends Evento{
    private double velocidade;
    private double precipitacao;

    public double getVelocidade() {
        return velocidade;
    }

    public double getPrecipitacao() {
        return precipitacao;
    }

    public Ciclone(String codigo, String data, double longitude, double latitude, double velocidade, double precipitacao) {
        super(codigo, data, longitude, latitude);
        this.precipitacao = precipitacao;
        this.velocidade = velocidade;
    }
    public String toString(){
        return "Ciclone\n" + super.toString()+ String.format("""
                Velocidade: %.2f
                Precipitação: %.2f
                ============================\n""",velocidade, precipitacao);
    }
}
