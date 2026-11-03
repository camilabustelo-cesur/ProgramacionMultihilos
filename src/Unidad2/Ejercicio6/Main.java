package Unidad2.Ejercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce hasta qué término calcular: ");
        int limite = teclado.nextInt();

        System.out.println("Calculando Fibonacci hasta el término " + limite);
        Sucesion sucesion = new Sucesion(limite);
        Calculadora[] trabajadores = new Calculadora[limite + 1];

        for (int i = 0; i <= limite; i++) {
            trabajadores[i] = new Calculadora(i, sucesion);
        }
        for (int i = 0; i <= limite; i++) {
            trabajadores[i].start();
        }
        for (int i = 0; i <= limite; i++) {
            trabajadores[i].join();
        }

        System.out.println("--------------------");
        System.out.println("Resultado final -> F(" + limite + ") = " + sucesion.obtener(limite));
    }
}
