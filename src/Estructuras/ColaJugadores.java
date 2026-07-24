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
}