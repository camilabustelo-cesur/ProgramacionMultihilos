package Unidad2.Ejercicio6;

public class Sucesion {
    private final long[] terminos;
    private final boolean[] listos;

    public Sucesion(int limite) {
        terminos = new long[limite + 1];
        listos = new boolean[limite + 1];
    }

    public synchronized void guardar(int posicion, long resultado) {
        terminos[posicion] = resultado;
        listos[posicion] = true;
    }

    public synchronized long obtener(int posicion) {
        return terminos[posicion];
    }

    public synchronized boolean disponible(int posicion) {
        return listos[posicion];
    }
}
