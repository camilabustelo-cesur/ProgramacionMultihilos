package Unidad2.Ejercicio1;

import java.util.concurrent.atomic.AtomicInteger;

public class Hilos implements Runnable {

    private String mensaje;
    private int i;

    public Hilos(String mensaje, int i) {
        this.mensaje = mensaje;
        this.i = i;
    }

    public void run() {
        for (int j = 0; j < i; j++) {
            System.out.println("Hilo: " + Thread.currentThread().getName() + " - Mensaje: " + mensaje );
        }
    }
}
