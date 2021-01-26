package Dakar;

public class SocorristaMoto implements Socorrer<Moto>{
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo Moto " + moto.getPatente());
    }
}
