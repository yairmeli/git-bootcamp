package Dakar;

import java.util.ArrayList;

public class TestDakar {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(11, 500000, "A Toda Marcha xD", 4, new ArrayList<>());
        carrera.darDeAltaAuto(120, 60, 60, "253wef234");
        carrera.darDeAltaMoto(120, 78, 56, "324rer343");
        carrera.darDeAltaAuto(170, 45, 50, "234frg566");
        carrera.darDeAltaMoto(280, 80, 10, "123rtg678");
        carrera.darDeAltaMoto(189, 56, 48, "578gdr876");

//        Velocidad * 1⁄2 Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        ArrayList<Vehiculo> lista = (ArrayList<Vehiculo>) carrera.getListaVehiculos();
        System.out.println("---lista de Vehículos agregados---");
        for (Vehiculo v: lista) {
            System.out.println(v.toString());
        }

        carrera.socorrerAuto("253wef234");
        carrera.socorrerMoto("123rtg678");
        carrera.socorrerMoto("578gdr876");
        System.out.println("--GANADOR---");
        System.out.println(carrera.getGanador().toString());

        carrera.eliminarVehiculo(lista.get(1));
        carrera.eliminarVehiculoConPatente("234frg566");
        System.out.println("--despues de eliminar--");
        for (Vehiculo v: lista) {
            System.out.println(v.toString());
        }

    }
}
