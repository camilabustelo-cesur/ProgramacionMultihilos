package Unidad2.Ejercicio2;

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
    private int veces;

    public Hilos(VariableCompartida variableCompartida, int veces) {
        this.variableCompartida = variableCompartida;
        this.veces = veces;
    }

    @Override
    public void run() {
        for (int i = 0; i < veces; i++) {
            variableCompartida.inc();
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Aumentamos progresivamente el número de incrementos por hilo
        int[] incrementos = {10, 1000, 100000, 1000000};

        for (int veces : incrementos) {
            // Cada prueba empieza con una variable nueva a 0
            VariableCompartida variableCompartida = new VariableCompartida();
            variableCompartida.set(0);

            Thread hilo1 = new Thread(new Hilos(variableCompartida, veces), "Hilo-1");
            Thread hilo2 = new Thread(new Hilos(variableCompartida, veces), "Hilo-2");

            hilo1.start();
            hilo2.start();

            hilo1.join();
            hilo2.join();

            System.out.println("Valor final de v: " + variableCompartida.get());
        }
    }
}
