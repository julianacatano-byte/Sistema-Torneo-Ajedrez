import Estructuras.ListaPartidas;
import Modelos.Jugador;
import Modelos.Partida;

public class Main {
    public static void main(String[] args) {
        ListaPartidas lista = new ListaPartidas();
        Jugador jugador1 = new Jugador("Ana", "123");
        Jugador jugador2 = new Jugador("Carlos", "456");
        Partida partida1 = new Partida(1, jugador1, jugador2, "Ganó blancas");
        lista.agregarPartida(partida1);
        lista.mostrarHistorial();
    }
}