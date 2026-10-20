package Unidad2.Ejercicio2;

import java.util.concurrent.atomic.AtomicInteger;

class VariableCompartida {
    private int v;

    public void set(int v) {
        this.v = v;
    }

    public int get() {
        return v;
    }

    public void inc() {
        v++;
    }
}

class Hilos implements Runnable {
    private VariableCompartida variableCompartida;

    public Hilos(VariableCompartida variableCompartida) {
        this.variableCompartida = variableCompartida;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            variableCompartida.inc();
            System.out.println(
                    Thread.currentThread().getName() +
                            " -> v = " + variableCompartida.get()
            );
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        VariableCompartida variableCompartida =
                new VariableCompartida();

        Thread hilo1 = new Thread(
                new Hilos(variableCompartida), "Hilo-1");

        Thread hilo2 = new Thread(
                new Hilos(variableCompartida), "Hilo-2");

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println(
                "Valor final de v: " +
                        variableCompartida.get());
    }
}