package Unidad2.Ejercicio5;


public class Main {

    public static void main(String[] args) {

        Ascensor ascensor = new Ascensor();

        ascensor.agregarUsuario(new Usuario(1, 0, 3, ascensor));
        ascensor.agregarUsuario(new Usuario(2, 2, -1, ascensor));
        ascensor.agregarUsuario(new Usuario(3, 1, 4, ascensor));

        ascensor.start();
    }
}
