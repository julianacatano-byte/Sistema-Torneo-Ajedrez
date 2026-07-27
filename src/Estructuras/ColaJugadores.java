package Estructuras;

import Modelos.Jugador;

public class ColaJugadores {
    private NodoCola frente;
    private NodoCola finalCola;


    public ColaJugadores() {
        frente = null;
        finalCola = null;
    }
    public void encolar(Jugador jugador) {
        NodoCola nuevoNodo = new NodoCola(jugador);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
    }
    public boolean estaVacia() {
        return frente == null;
    }
    public Jugador desencolar() {
        if (estaVacia()) {
            return null;
        }
        Jugador jugador = frente.getJugador();
        frente = frente.getSiguiente();
        if (frente == null) {
            finalCola = null;
        }
        return jugador;
    }

    public void mostrarCola() {
        NodoCola actual = frente;

        while (actual != null) {
            System.out.println(actual.getJugador().getNombre() + " - " + actual.getJugador().getCedula());
            actual = actual.getSiguiente();
        }
    }

    // Devuelve la (cantidad de jugadores) en espera
    public int cantidadJugadoresEnEspera() {
        int contador = 0;
        NodoCola actual = frente;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    // Buscar un jugador por cédula
    public Jugador buscarJugador(String cedula) {
        NodoCola actual = frente;
        while (actual != null) {
            if (actual.getJugador().getCedula().equals(cedula)) {
                return actual.getJugador();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    // Elimina un jugador de la cola
    public boolean eliminarJugador(String cedula) {
        if (estaVacia()) {
            return false;
        }

        if (frente.getJugador().getCedula().equals(cedula)) {
            desencolar();
            return true;
        }

        NodoCola anterior = frente;
        NodoCola actual = frente.getSiguiente();
        while (actual != null) {
            if (actual.getJugador().getCedula().equals(cedula)) {
                anterior.setSiguiente(actual.getSiguiente());
                if (actual == finalCola) {
                    finalCola = anterior;
                }
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }
}