package Unidad2.Ejercicio2;

import java.util.concurrent.atomic.AtomicInteger;

class VariableCompartida {
    public AtomicInteger v = new AtomicInteger(0);
}

class Hilos implements Runnable {
    private VariableCompartida variableCompartida;

    public Hilos(VariableCompartida variableCompartida) {
        this.variableCompartida = variableCompartida;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            variableCompartida.v.incrementAndGet();
            System.out.println("Hilo: " + Thread.currentThread().getName() + " - Valor de v: " + variableCompartida.v.get());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VariableCompartida variableCompartida = new VariableCompartida();

        Thread hilo1 = new Thread(new Hilos(variableCompartida));
        Thread hilo2 = new Thread(new Hilos(variableCompartida));

        hilo1.start();
        hilo2.start();


    }
}