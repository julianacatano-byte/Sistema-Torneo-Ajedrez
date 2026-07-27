package Estructuras;

import Modelos.Jugador;

public class ArbolJugador {

    private NodoArbol raiz;

    public NodoArbol getRaiz() {
        return raiz;
    }

/*
    INSERTAR
 */

    public void insertar(Jugador jugador) {

        NodoArbol nuevo = new NodoArbol(jugador);

        if (raiz == null) {
            raiz = nuevo;
            return;
        }

        NodoArbol actual = raiz;

        while (true) {


            if (jugador.getPuntaje() < actual.getJugador().getPuntaje()) {

                if (actual.getIzquierda() == null) {
                    actual.setIzquierda(nuevo);
                    return;
                }

                actual = actual.getIzquierda();

            } else if (jugador.getPuntaje() > actual.getJugador().getPuntaje()) {

                if (actual.getDerecha() == null) {
                    actual.setDerecha(nuevo);
                    return;
                }

                actual = actual.getDerecha();

            } else {

                // Si tienen el mismo puntaje desempata por cédula

                if (jugador.getCedula().compareTo(actual.getJugador().getCedula()) < 0) {

                    if (actual.getIzquierda() == null) {
                        actual.setIzquierda(nuevo);
                        return;
                    }

                    actual = actual.getIzquierda();

                } else {

                    if (actual.getDerecha() == null) {
                        actual.setDerecha(nuevo);
                        return;
                    }

                    actual = actual.getDerecha();

                }

            }

        }

    }

    public Jugador buscarCedula(String cedula) {

        return buscarRecursivo(raiz, cedula);

    }

    private Jugador buscarRecursivo(NodoArbol nodo, String cedula) {

        if (nodo == null) {
            return null;
        }

        if (nodo.getJugador().getCedula().equals(cedula)) {
            return nodo.getJugador();
        }

        Jugador izquierda = buscarRecursivo(nodo.getIzquierda(), cedula);

        if (izquierda != null) {
            return izquierda;
        }

        return buscarRecursivo(nodo.getDerecha(), cedula);

    }

/*
    IMPRIMIR EN ORDEN
 */

    public void mostrarRanking() {

        inOrden(raiz);

    }

    private void inOrden(NodoArbol nodo) {

        if (nodo == null) {
            return;
        }

        inOrden(nodo.getIzquierda());

        System.out.println(
                nodo.getJugador().getNombre()
                        + "  Puntaje: "
                        + nodo.getJugador().getPuntaje());

        inOrden(nodo.getDerecha());

    }

/*
    BUSCAR NODO MENOR
 */

    private NodoArbol menor(NodoArbol nodo) {

        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }

        return nodo;

    }

    public void eliminar(Jugador jugador) {
        raiz = eliminarRecursivo(raiz, jugador);
    }

    private NodoArbol eliminarRecursivo(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) {
            return null;
        }
        if (jugador.getPuntaje() < nodo.getJugador().getPuntaje()) {
            nodo.setIzquierda(eliminarRecursivo(nodo.getIzquierda(), jugador));
        }
        else if (jugador.getPuntaje() > nodo.getJugador().getPuntaje()) {
            nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), jugador));
        } else {
            if (!jugador.getCedula().equals(nodo.getJugador().getCedula())) {
                nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), jugador));
                return nodo;
            }

            // No tiene hijos
            if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                return null;
            }

            // Tiene hijo derecho
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            }

            // Tiene hijo izquierdo
            if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }

            // Dos hijos
            NodoArbol menor = menor(nodo.getDerecha());
            nodo.setJugador(menor.getJugador());
            nodo.setDerecha(eliminarRecursivo(nodo.getDerecha(), menor.getJugador()));
        }
        return nodo;
    }

    public void actualizarPuntaje(Jugador jugador, int nuevoPuntaje) {
        eliminar(jugador);
        jugador.setPuntaje(nuevoPuntaje);
        insertar(jugador);

    }

}

