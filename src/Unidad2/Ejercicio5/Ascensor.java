package Unidad2.Ejercicio5;


import java.util.LinkedList;

public class Ascensor extends Thread {

    private int pisoActual = 0;
    private final LinkedList<Usuario> cola = new LinkedList<>();

    private Usuario usuarioActual;
    private boolean puedeSubir = false;
    private boolean dentro = false;
    private boolean puedeBajar = false;
    private boolean haBajado = false;

    public synchronized void agregarUsuario(Usuario usuario) {
        cola.addLast(usuario);
    }

    public synchronized void esperarYViajar(Usuario usuario) {
        try {
            System.out.println("Usuario " + usuario.getIdUsuario()
                    + " espera en piso " + usuario.getOrigen());

            while (!puedeSubir || pisoActual != usuario.getOrigen()) {
                wait();
            }

            System.out.println("Usuario " + usuario.getIdUsuario()
                    + " sube al ascensor.");

            dentro = true;
            notifyAll();

            while (!puedeBajar || pisoActual != usuario.getDestino()) {
                wait();
            }

            System.out.println("Usuario " + usuario.getIdUsuario()
                    + " baja en piso " + usuario.getDestino());

            haBajado = true;
            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void moverHasta(int destino) throws InterruptedException {
        while (pisoActual != destino) {
            Thread.sleep(300);

            synchronized (this) {
                if (pisoActual < destino) {
                    pisoActual++;
                } else {
                    pisoActual--;
                }

                System.out.println("Ascensor en piso " + pisoActual);
                notifyAll();
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    if (cola.isEmpty()) {
                        break;
                    }

                    usuarioActual = cola.removeFirst();
                    puedeSubir = false;
                    dentro = false;
                    puedeBajar = false;
                    haBajado = false;
                }

                // Iniciar solamente el hilo del usuario actual
                usuarioActual.start();

                // Ir a recogerlo
                moverHasta(usuarioActual.getOrigen());

                synchronized (this) {
                    puedeSubir = true;
                    notifyAll();

                    while (!dentro) {
                        wait();
                    }

                    puedeSubir = false;
                }

                // Llevarlo a su destino
                moverHasta(usuarioActual.getDestino());

                synchronized (this) {
                    puedeBajar = true;
                    notifyAll();

                    while (!haBajado) {
                        wait();
                    }

                    puedeBajar = false;
                    usuarioActual = null;
                }
            }

            System.out.println("Ascensor vacío, bajando al piso -1.");
            moverHasta(-1);
            System.out.println("Programa finalizado.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
