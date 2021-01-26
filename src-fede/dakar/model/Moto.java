package dakar.model;

public class Moto extends Vehiculo{

    public Moto(String patente) {
        super(patente);
        super.setPeso(300);
        super.setRuedas(2);
    }
}
