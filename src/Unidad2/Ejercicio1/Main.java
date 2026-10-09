package Unidad2.Ejercicio1;
public class Main {

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Hilos("A", 5));
        Thread hilo2 = new Thread(new Hilos("B", 2));
        Thread hilo3 = new Thread(new Hilos("C", 4));

        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
