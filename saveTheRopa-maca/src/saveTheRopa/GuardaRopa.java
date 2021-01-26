package saveTheRopa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        this.contador = 1;
        this.diccionario = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.diccionario.put(this.contador,listaDePrenda);
        return this.contador++;
    }

    public void mostrarPrendas(){
        for (int key: this.diccionario.keySet()) {
            System.out.println(key + " - " + this.diccionario.get(key));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        List<Prenda> al = this.diccionario.get(numero); //obtengo el array de esa key
        this.diccionario.remove(numero);
        return al;
    }
}
