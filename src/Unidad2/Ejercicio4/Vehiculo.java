package Unidad2.Ejercicio4;


public class Vehiculo implements Runnable {

    private String nombre;
    private Pistas pistas;

    public Vehiculo(String nombre, Pistas pistas) {
        this.nombre = nombre;
        this.pistas = pistas;
    }

    @Override
    public void run() {

        int pista = pistas.ocuparPista(nombre);

        int tiempo = (int) (Math.random() * 3000) + 2000;

        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        System.out.println(
                nombre + " ha salido de la pista " + (pista + 1) + "\n" +
                        nombre + " completó la prueba en " + tiempo + " ms");

        pistas.liberarPista(pista);
    }
}