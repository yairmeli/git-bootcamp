import java.util.*;

public class Carrera {
    private int Distancia;
    private int PremioEnDolares;
    private String Nombre;
    private int CantidadDeVehiculosPermitidos;
    private List<Vehiculo> ListaDeVehiculos;
    private SocorristaAuto SocorristaAuto;
    private SocorristaMoto SocorristaMoto;

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
    public int getDistancia() {
        return Distancia;
    }
    public void setDistancia(int distancia) {
        Distancia = distancia;
    }
    public int getPremioEnDolares() {
        return PremioEnDolares;
    }
    public void setPremioEnDolares(int premioEnDolares) {
        PremioEnDolares = premioEnDolares;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getCantidadDeVehiculosPermitidos() {
        return CantidadDeVehiculosPermitidos;
    }
    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }
    public List<Vehiculo> getListaDeVehiculos() {
        return ListaDeVehiculos;
    }
    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        ListaDeVehiculos = listaDeVehiculos;
    }

    public void darDeAltaUnAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        List<Vehiculo> vehiculos = getListaDeVehiculos();
        if (vehiculos.size()<getCantidadDeVehiculosPermitidos()) {
            Vehiculo auto = new Auto();
            auto.setVelocidad(velocidad);
            auto.setAceleracion(aceleracion);
            auto.setAnguloDeGiro(anguloDeGiro);
            auto.setPatente(patente);
            vehiculos.add(auto);
            this.setListaDeVehiculos(vehiculos);
            System.out.println("Vehículo agregado correctamente");
        }
        else {
            System.out.println("No hay lugar para este auto en la carrera.");
        }
    }
    public void darDeAltaUnaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        List<Vehiculo> vehiculos = getListaDeVehiculos();
        if (vehiculos.size()<getCantidadDeVehiculosPermitidos()) {
            Vehiculo moto = new Moto();
            moto.setVelocidad(velocidad);
            moto.setAceleracion(aceleracion);
            moto.setAnguloDeGiro(anguloDeGiro);
            moto.setPatente(patente);
            vehiculos.add(moto);
            this.setListaDeVehiculos(vehiculos);
            System.out.println("Vehículo agregado correctamente");
        }
        else {
            System.out.println("No hay lugar para esta moto en la carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        List<Vehiculo> vehiculos = getListaDeVehiculos();
        vehiculos.remove(vehiculo);
        this.setListaDeVehiculos(vehiculos);
    }
    public void eliminarVehiculoConPatente(String patente) {
        List<Vehiculo> vehiculos = getListaDeVehiculos();
        Vehiculo vehiculo = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findAny().get();
        if (vehiculo != null) {
            vehiculos.remove(vehiculo);
            this.setListaDeVehiculos(vehiculos);
            System.out.println("El vehículo se sacó de la carrera correctamente.");
        }
        else {
            System.out.println("No encontramos un vehículo con esa patente en esta carrera.");
        }
    }

    public Vehiculo getGanador() {
        List<Vehiculo> vehiculos = getListaDeVehiculos();
        for(Vehiculo v:vehiculos) {
            int rendimiento = (v.getVelocidad()*(v.getAceleracion()/2))/(v.getAnguloDeGiro()*(v.getPeso()-(v.getRuedas()*100)));
            v.setRendimiento(rendimiento);
        }
        vehiculos.sort(new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo v1, Vehiculo v2) {
                int byPerformance = v1.getRendimiento()-v2.getRendimiento();
                return byPerformance != 0 ? byPerformance : v1.getPatente().compareTo(v2.getPatente());
            }
        });
        return vehiculos.stream().findFirst().get();
    }

    public void SocorrerAuto(String patente) {
        this.getSocorristaAuto().Socorrer((Auto)this.getListaDeVehiculos().stream().filter(v -> v.getPatente().equals(patente)).findFirst().get());
    }
    public void SocorrerMoto(String patente) {
        this.getSocorristaMoto().Socorrer((Moto)this.getListaDeVehiculos().stream().filter(v -> v.getPatente().equals(patente)).findFirst().get());
    }
}
