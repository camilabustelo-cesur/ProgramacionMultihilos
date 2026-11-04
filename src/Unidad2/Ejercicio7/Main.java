package Unidad2.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List lista = new ArrayList();
        Nodo lista2 = new Nodo(lista);


        int items = new Random().nextInt(97) +2;

        for (int i = 1; i <= items; i++) {
            lista.add(new Random().nextInt(100));
        }



        System.out.println("Tamaño de la lista: " + lista.size());
        System.out.println("Lista desordenada:" + "\n" +lista);

        lista2.start();

        try{
            lista2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Lista ordenada:" + "\n" +lista);
    }

}
