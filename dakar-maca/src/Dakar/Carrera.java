package Dakar;

import java.util.List;

public class Carrera {
    private double distancia;
    private int premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaMoto socorristaMoto = new SocorristaMoto();
    private SocorristaAuto socorristaAuto = new SocorristaAuto();

    public Carrera(double distancia, int premioDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> listaVehiculos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(int premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion,double anguloGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloGiro, patente);
            listaVehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(double velocidad, double aceleracion,double anguloGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Vehiculo moto = new Moto(velocidad, aceleracion, anguloGiro, patente);
            listaVehiculos.add(moto);
        } else {
            System.out.println("Solo pueden agregarse "+this.cantidadVehiculosPermitidos+" Vehículos a la Carrera "+this.nombre);
            System.out.println("El vehiculo "+patente+" no pudo ser agregado");
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        listaVehiculos.remove(v);
        System.out.println("El vehículo "+v.getPatente()+" ha sido eliminado");

    }
    public void eliminarVehiculoConPatente(String patente){
        listaVehiculos.removeIf(v -> v.getPatente().equals(patente));
        System.out.println("El vehículo "+patente+" ha sido eliminado");
    }

    public Vehiculo getGanador(){
        Vehiculo ganador = listaVehiculos.get(0);
        double resultadoGanador = this.calcularResultadoGanador(ganador);
        for (Vehiculo g: listaVehiculos) {
//            System.out.println(ganador.getClass().getName()+" "+ganador.getPatente()+" - "+resultadoGanador);
//            System.out.println(this.calcularResultadoGanador(g) + " calculo resultado "+g.getClass().getName());
            if(this.calcularResultadoGanador(g) > resultadoGanador) {
                ganador = g;
                resultadoGanador = this.calcularResultadoGanador(g);
            }
        }
        return ganador;
    }

    private double calcularResultadoGanador(Vehiculo g){
//        Velocidad * 1⁄2 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        return (g.getVelocidad() * g.getAsceleracion() * 0.5) / g.getAnguloGiro() * (g.getPeso() - (g.getRuedas() * 100));
    }

    public void socorrerAuto(String patente){
        for (Vehiculo v: this.listaVehiculos) {
            if(v.getPatente() == patente && v instanceof Auto){
                this.socorristaAuto.socorrer((Auto) v);
            }
        }
    }
    public void socorrerMoto(String patente){
        for (Vehiculo v: this.listaVehiculos) {
            if(v.getPatente() == patente && v instanceof Moto){
                this.socorristaMoto.socorrer((Moto) v);
            }
        }
    }

    @Override
    public String toString() {
        return "Carrera: " +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos;
    }
}
