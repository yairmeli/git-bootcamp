package saveTheRopa.model;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private int contador;
    private HashMap<Integer, List<Prenda>> diccionario;

    public GuardaRopa() {
        this.contador = 0;
        this.diccionario = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.diccionario.put(contador, listaDePrenda);
        this.contador++;
        return contador-1;
    }

    public void mostrarPrendas(){
        for (int i = 0; i < this.diccionario.size(); i++) {
            List<Prenda> list = devolverPrenda(i);
            System.out.println("Prendas del ropero ID: " + i);
            for (Prenda p: list) {
                System.out.println("Marca: " + p.getMarca() + " | Modelo: " + p.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrenda(Integer num){
        return this.diccionario.get(num);
    }
}
