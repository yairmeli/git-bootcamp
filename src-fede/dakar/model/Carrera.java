package dakar.model;

import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto SocorristaAuto;
    private SocorristaMoto SocorristaMoto;


    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    /**
     * El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
     * Velocidad * 1⁄2 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
     * @return Vehiculo ganador
     */
    public Vehiculo simularGanador(){
        List<Vehiculo> competidores = this.getVehiculos();
        Vehiculo vGanador = competidores.get(0);
        double ptsCompetidor = 0, ptsGanador = calcularFormula(vGanador);

        for(Vehiculo v: competidores){
            ptsCompetidor = calcularFormula(v);
            if(ptsCompetidor > ptsGanador) {
                vGanador = v;
                ptsGanador = ptsCompetidor;
            }
        }

        System.out.println("El ganador es " + vGanador.getPatente() + " con " + ptsGanador +" puntos de carrera");
        return vGanador;
    }

    private double calcularFormula(Vehiculo v){
        return v.getVelocidad() * (v.getAceleracion() / 2) / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
    }

    public void darDeAltaAuto(double vel, double acel, double anguloDeGiro, String patente){
        Vehiculo v = new Auto(patente);
        v.setAceleracion(acel);
        v.setVelocidad(vel);
        v.setAnguloDeGiro(anguloDeGiro);

        if(cantidadDeVehiculos > this.vehiculos.size()){
            this.vehiculos.add(v);
        } else{
            System.out.println("No hay cupo para el vehiculo");
        }
    }

    public void darDeAltaMoto(double vel, double acel, double anguloDeGiro, String patente){
        Vehiculo v = new Moto(patente);
        v.setAceleracion(acel);
        v.setVelocidad(vel);
        v.setAnguloDeGiro(anguloDeGiro);

        if(cantidadDeVehiculos > vehiculos.size()){
            this.vehiculos.add(v);
        } else{
            System.out.println("No hay cupo para el vehiculo");
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        if(this.vehiculos.remove(v)){
            System.out.println("Se removio el vehiculo patente: " + v.getPatente());
        } else {
            System.out.println("El vehiculo de patente: " + v.getPatente() + " no existe en la carrera");
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        List<Vehiculo> list = this.vehiculos;

        for (Vehiculo v: list) {
            if(v.getPatente().equals(patente)){
                this.vehiculos.remove(v);
            }
        }
    }

    public void SocorrerAuto(String patente) {
        this.getSocorristaAuto().Socorrer((Auto)this.getVehiculos().stream().filter(v -> v.getPatente().equals(patente)).findFirst().get());
    }
    public void SocorrerMoto(String patente) {
        this.getSocorristaMoto().Socorrer((Moto)this.getVehiculos().stream().filter(v -> v.getPatente().equals(patente)).findFirst().get());
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }

    public void setCantidadDeVehiculos(int cantidadDeVehiculos) {
        this.cantidadDeVehiculos = cantidadDeVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return SocorristaAuto;
    }
    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        SocorristaAuto = socorristaAuto;
    }
    public SocorristaMoto getSocorristaMoto() {
        return SocorristaMoto;
    }
    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        SocorristaMoto = socorristaMoto;
    }
}
