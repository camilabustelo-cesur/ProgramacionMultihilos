package Unidad2.Ejercicio4;

public class Pistas {
    private boolean[] disponibles = {true, true};

    public synchronized int ocuparPista(String nombre) {
        while (!disponibles[0] && !disponibles[1]) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        for (int i = 0; i < disponibles.length; i++) {
            if (disponibles[i]) {
                disponibles[i] = false;
                System.out.println(nombre + " ha entrado en la pista " + (i + 1));
                return i;
            }
        }

        return -1;
    }

    public synchronized void liberarPista(int pista) {

        disponibles[pista] = true;

        notify();
    }
}