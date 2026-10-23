package Unidad2.Ejercicio3;

// ---------- Versión SIN sincronizar ----------

class VariableCompartida {

    private int v = 0;

    public void set(int v) {
        this.v = v;
    }

    public int get() {
        return v;
    }
}

class Escritor implements Runnable {

    private VariableCompartida variable;

    public Escritor(VariableCompartida variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            variable.set(i);
        }
    }
}

class Lector implements Runnable {

    private VariableCompartida variable;

    public Lector(VariableCompartida variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Valor leído: " + variable.get());
        }
    }
}

// ---------- Versión sincronizada con wait/notify ----------

class VariableCompartidaSincronizada {

    private int v = 0;
    private boolean hayDato = false;

    public synchronized void set(int v) {
        while (hayDato) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.v = v;
        hayDato = true;
        notifyAll();
    }

    public synchronized int get() {
        while (!hayDato) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hayDato = false;
        notifyAll();
        return v;
    }
}

class EscritorSincronizado implements Runnable {

    private VariableCompartidaSincronizada variable;

    public EscritorSincronizado(VariableCompartidaSincronizada variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            variable.set(i);
        }
    }
}

class LectorSincronizado implements Runnable {

    private VariableCompartidaSincronizada variable;

    public LectorSincronizado(VariableCompartidaSincronizada variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Valor leído: " + variable.get());
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- Versión SIN sincronizar ---");
        VariableCompartida variable = new VariableCompartida();
        Thread hiloEscritor = new Thread(new Escritor(variable));
        Thread hiloLector = new Thread(new Lector(variable));

        hiloEscritor.start();
        hiloLector.start();

        hiloEscritor.join();
        hiloLector.join();

        System.out.println();
        System.out.println("--- Versión sincronizada con wait/notify ---");
        VariableCompartidaSincronizada variableSinc = new VariableCompartidaSincronizada();
        Thread hiloEscritorSinc = new Thread(new EscritorSincronizado(variableSinc));
        Thread hiloLectorSinc = new Thread(new LectorSincronizado(variableSinc));

        hiloEscritorSinc.start();
        hiloLectorSinc.start();

        hiloEscritorSinc.join();
        hiloLectorSinc.join();
    }
}
