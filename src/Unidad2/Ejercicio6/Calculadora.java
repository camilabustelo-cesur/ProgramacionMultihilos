package Unidad2.Ejercicio6;

public class Calculadora extends Thread {

    private final int posicion;
    private final Sucesion sucesion;

    public Calculadora(int posicion, Sucesion sucesion) {
        this.posicion = posicion;
        this.sucesion = sucesion;
    }

    @Override
    public void run() {
        if (posicion < 2) {
            sucesion.guardar(posicion, posicion);
            return;
        }

        int previo1 = posicion - 1;
        int previo2 = posicion - 2;

        // Espera activa hasta que los dos términos anteriores estén listos
        while (!(sucesion.disponible(previo1) && sucesion.disponible(previo2))) {
            Thread.onSpinWait();
        }

        long suma = sucesion.obtener(previo2) + sucesion.obtener(previo1);
        System.out.println("Término F(" + posicion + ") = " + suma);
        sucesion.guardar(posicion, suma);
    }
}
