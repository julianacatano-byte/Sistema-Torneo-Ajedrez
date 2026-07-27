package Estructuras;
import Modelos.Partida;
public class ListaPartidas {
    public NodoLista inicio;
    public ListaPartidas(){
        inicio = null;
    }
    public void agregarPartida( Partida partida){
        NodoLista nuevoNodo = new NodoLista(partida);
        if (inicio == null){
            inicio = nuevoNodo;
        }else{
            NodoLista actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public void mostrarHistorial() {
        NodoLista actual = inicio;
        while (actual != null) {
            System.out.println("Partida: " + actual.getPartida().getidPartida() + " Resultado: " + actual.getPartida().getResultado());
            actual = actual.getSiguiente();
        }
    }

    public Partida buscarPartida(int idPartida){
        NodoLista actual = inicio;
        while (actual != null) {
            if (actual.getPartida().getidPartida() == idPartida) {
                return actual.getPartida();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int cantidadPartidas(){
        int contador = 0;
        NodoLista actual = inicio;
        while(actual != null){
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    // Eliminar una partida del historial
    public boolean eliminarPartida(int idPartida) {
        if (inicio == null) {
            return false;
        }

        if (inicio.getPartida().getidPartida() == idPartida) {
            inicio = inicio.getSiguiente();
            return true;
        }
        NodoLista anterior = inicio;
        NodoLista actual = inicio.getSiguiente();

        while (actual != null) {
            if (actual.getPartida().getidPartida() == idPartida) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean isEmpty() {
        return inicio == null;
    }
}