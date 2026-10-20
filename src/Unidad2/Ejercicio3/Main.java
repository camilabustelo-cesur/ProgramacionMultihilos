package Unidad2.Ejercicio3;


class VariableCompartida {

    private int v;

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


public class Main {

    public static void main(String[] args) {

        VariableCompartida variable = new VariableCompartida();

        Thread escritor = new Thread(new Escritor(variable));
        Thread lector = new Thread(new Lector(variable));

        escritor.start();
        lector.start();
    }
}