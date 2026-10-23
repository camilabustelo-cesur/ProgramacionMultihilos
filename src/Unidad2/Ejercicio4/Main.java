package Unidad2.Ejercicio4;

public class Main {

    public static void main(String[] args) {

        Pistas pistas = new Pistas();

        Thread v1 = new Thread(new Vehiculo("Vehículo 1", pistas));
        Thread v2 = new Thread(new Vehiculo("Vehículo 2", pistas));
        Thread v3 = new Thread(new Vehiculo("Vehículo 3", pistas));
        Thread v4 = new Thread(new Vehiculo("Vehículo 4", pistas));

        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }
}