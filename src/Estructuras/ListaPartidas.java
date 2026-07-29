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

    public String mostrarHistorial() {
        StringBuilder sb = new StringBuilder();
        NodoLista actual = inicio;

        if(actual == null){
            return "No existen partidas registradas.";

        }

        while(actual != null){
            sb.append("Partida: ").append(actual.getPartida().getidPartida()).append("\n");
            sb.append("Jugador Blancas: ").append(actual.getPartida().getJugadorConPiezasBlancas().getNombre()).append("\n");
            sb.append("Jugador Negras: ").append(actual.getPartida().getJugadorConPiezasNegras().getNombre()).append("\n");
            sb.append("Resultado: ").append(actual.getPartida().getResultado()).append("\n");
            sb.append("--------------------------------------\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
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