package Unidad2.Ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Nodo extends Thread{
    private List<Integer> lista;


    public Nodo(List<Integer> lista) {
        this.lista = lista;

    }

    @Override
    public void run() {

        if (lista.size() <= 1) {
            return;
        }

        int mitad = lista.size() / 2;

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        anadir(l1, 0, mitad);
        anadir(l2, mitad, lista.size());

        Nodo n1 = new Nodo(l1);

        Nodo n2 = new Nodo(l2);

        n1.start();
        n2.start();

        try {
            n1.join();
            n2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        mezclar(n1.lista, n2.lista);

    }

    public void anadir(List<Integer> l, int desde, int hasta) {
        l.addAll(lista.subList(desde, hasta));
    }

    public void mezclar(List<Integer> l1, List<Integer> l2) {
        lista.clear();
        int i = 0;
        int j = 0;

        while (i < l1.size() && j < l2.size()) {

            if (l1.get(i) <= l2.get(j)) {
                lista.add(l1.get(i));
                i++;
            } else {
                lista.add(l2.get(j));
                j++;
            }
        }

        while (i < l1.size()) {
            lista.add(l1.get(i));
            i++;
        }

        while (j < l2.size()) {
            lista.add(l2.get(j));
            j++;
        }
    }



}
