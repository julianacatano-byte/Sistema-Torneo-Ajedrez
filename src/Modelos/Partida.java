package Modelos;

public class Partida {
    private int idPartida;
    private Jugador jugadorConPiezasBlancas;
    private Jugador jugadorConPiezasNegras;
    private String resultado;

    public Partida(int idPartida, Jugador JugadorConPiezasBlancas, Jugador JugadorConPiezasNegras, String resultado) {
        this.idPartida = idPartida;
        this.jugadorConPiezasBlancas = JugadorConPiezasBlancas;
        this.jugadorConPiezasNegras = JugadorConPiezasNegras;
        this.resultado = resultado;
    }

    public int getidPartida() {
        return idPartida;
    }

    public void setidPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public Jugador getJugadorConPiezasBlancas() {
        return jugadorConPiezasBlancas;
    }

    public void setJugadorConPiezasBlancas(Jugador jugadorConPiezasBlancas) {
        this.jugadorConPiezasBlancas = jugadorConPiezasBlancas;
    }

    public Jugador getJugadorConPiezasNegras() {
        return jugadorConPiezasNegras;
    }

    public void setJugadorConPiezasNegras(Jugador jugadorConPiezasNegras) {
        this.jugadorConPiezasNegras = jugadorConPiezasNegras;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}