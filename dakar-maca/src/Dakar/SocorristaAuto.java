package Dakar;

public class SocorristaAuto implements Socorrer<Auto> {
    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo Auto " + auto.getPatente());
    }
}
