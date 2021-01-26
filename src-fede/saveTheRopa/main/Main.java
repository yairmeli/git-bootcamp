package saveTheRopa.main;

import saveTheRopa.model.GuardaRopa;
import saveTheRopa.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Se inicia el sistema..");
        GuardaRopa gp = new GuardaRopa();

        System.out.println("Llego Pepe y trajo dos prendas");
        Prenda p1 = new Prenda("Tommy", "Remera");
        Prenda p2 = new Prenda("Nike", "Buzo");

        List<Prenda> canastoPepe = new ArrayList<Prenda>();

        canastoPepe.add(p1);
        canastoPepe.add(p2);

        System.out.println("Se guarda la ropa.. ");
        Integer numPepe = gp.guardarPrendas(canastoPepe);

        System.out.println("El num de Pepe es : " + numPepe);

        Thread.sleep(3000);
        System.out.println("Pepe vuelve por su ropa.. con su numero");
        System.out.println("Buscando ropa de pepe..");
        Thread.sleep(5000);
        gp.mostrarPrendas();





    }
}
