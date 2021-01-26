package dakar.model;

public class Auto extends Vehiculo{

    public Auto(String patente) {
        super(patente);
        super.setRuedas(4);
        super.setPeso(1000);
    }
}
