package Dakar;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double asceleracion, double anguloGiro, String patente) {
        super(velocidad, asceleracion, anguloGiro, patente, 1000, 4);
    }

    @Override
    public String toString() {
        return "Auto: " + super.toString();
    }
}
