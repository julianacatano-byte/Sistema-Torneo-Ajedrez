package Estructuras;

import Modelos.Jugador;
import Modelos.Partida;

public class AdministradorTorneo {
    private ColaJugadores cola;
    private ArbolJugador ranking;
    private ListaPartidas historial;
    private int siguienteIdPartida;

    public AdministradorTorneo() {
        cola = new ColaJugadores();
        ranking = new ArbolJugador();
        historial = new ListaPartidas();
        siguienteIdPartida = 1;

    }

    public ColaJugadores getCola() {
        return cola;
    }

    public ArbolJugador getRanking() {
        return ranking;
    }

    public ListaPartidas getHistorial() {
        return historial;
    }

    public void inscribirJugador(Jugador jugador) {
        cola.encolar(jugador);
        ranking.insertar(jugador);
    }

    public Partida crearPartida() {

        if (cola.estaVacia()) {
            return null;
        }

        Jugador blancas = cola.desencolar();

        if (cola.estaVacia()) {
            cola.encolar(blancas);
            return null;
        }

        Jugador negras = cola.desencolar();

        Partida partida = new Partida(siguienteIdPartida, blancas, negras, "Pendiente");
        siguienteIdPartida++;
        historial.agregarPartida(partida);

        return partida;

    }

    public void registrarResultado(Partida partida, String resultado, int calidadBlancas, int calidadNegras) {

        partida.setResultado(resultado);

        Jugador blancas = partida.getJugadorConPiezasBlancas();
        Jugador negras = partida.getJugadorConPiezasNegras();

        int puntosBlancas = blancas.getPuntaje();
        int puntosNegras = negras.getPuntaje();

        if (resultado.equalsIgnoreCase("Blancas")) {
            puntosBlancas += 20;
            puntosNegras -= 10;
        }

        else if (resultado.equalsIgnoreCase("Negras")) {
            puntosNegras += 20;
            puntosBlancas -= 10;
        }

        else if (resultado.equalsIgnoreCase("Empate")) {
        }

        puntosBlancas += calidadBlancas;
        puntosNegras += calidadNegras;

        ranking.actualizarPuntaje(blancas, puntosBlancas);
        ranking.actualizarPuntaje(negras, puntosNegras);

    }

    public void retirarJugador(Jugador jugador) {
        ranking.eliminar(jugador);
    }

    public Partida buscarPartida(int id) {
        return historial.buscarPartida(id);
    }

    public String mostrarRanking() {
        return ranking.mostrarRanking();

    }

    public String mostrarHistorial() {
        return historial.mostrarHistorial();
    }

    public Jugador buscarJugador(String cedula) {
        return ranking.buscarCedula(cedula);
    }

    public boolean anularPartida(int idPartida) {
        return historial.eliminarPartida(idPartida);
    }

    public int jugadoresEnEspera() {
        return cola.cantidadJugadoresEnEspera();
    }

    public int totalPartidas() {
        return historial.cantidadPartidas();
    }

    public String mostrarJugadoresPorNiveles(){
        return ranking.mostrarPorNiveles();

    }
}
