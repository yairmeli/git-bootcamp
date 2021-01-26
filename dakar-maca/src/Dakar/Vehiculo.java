package Dakar;

public class Vehiculo {
    private double velocidad;
    private double asceleracion;
    private double anguloGiro;
    private String patente;
    private double peso;
    private int ruedas;

    public Vehiculo(double velocidad, double asceleracion, double anguloGiro, String patente, double peso, int ruedas) {
        this.velocidad = velocidad;
        this.asceleracion = asceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.ruedas = ruedas;
    }

    public Vehiculo() {
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAsceleracion() {
        return asceleracion;
    }

    public void setAsceleracion(double asceleracion) {
        this.asceleracion = asceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    @Override
    public String toString() {
        return "velocidad=" + velocidad +
                ", asceleracion=" + asceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", ruedas=" + ruedas;
    }
}
