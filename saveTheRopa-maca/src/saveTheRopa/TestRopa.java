package saveTheRopa;

import java.util.ArrayList;

public class TestRopa {
    public static void main(String[] args) {
        Prenda p1 = new Prenda("adidas", "2017");
        Prenda p2 = new Prenda("nike", "2019");

        ArrayList<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(p1);
        listaPrendas.add(p2);

        System.out.println(listaPrendas.toString());

        Prenda p3 = new Prenda("gucci", "2015");
        Prenda p4 = new Prenda("nose xD", "2020");

        ArrayList<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(p3);
        listaPrendas2.add(p4);

        System.out.println(listaPrendas2.toString());

        GuardaRopa gr = new GuardaRopa();

        System.out.println(gr.guardarPrendas(listaPrendas));
        System.out.println(gr.guardarPrendas(listaPrendas2));
        System.out.println("---Prendas Guardadas---");
        gr.mostrarPrendas();
        gr.devolverPrendas(1);
        System.out.println("---Prendas Guardadas---");
        gr.mostrarPrendas();

    }
}
