package Aplicacao;

public abstract class Evento {
    private String codigo;
    private String data;
    private double longitude;
    private double latitude;
    public Evento(String codigo, String data, double longitude, double latitude){
        this.codigo = codigo;
        this.data = data;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return String.format("""
                Código: %s
                Data: %s
                Longitude: %.2f
                Latitude: %.2f
                """, codigo, data, longitude, latitude);

    }
}
