package Dakar;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double asceleracion, double anguloGiro, String patente) {
        super(velocidad, asceleracion, anguloGiro, patente, 300, 2);
    }

    @Override
    public String toString() {
        return "Moto: " + super.toString();
    }
}
