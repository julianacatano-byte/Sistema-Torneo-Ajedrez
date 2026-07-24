package Estructuras;
import Modelos.Partida;

public class NodoLista {
    private Partida partida;
    private NodoLista siguiente;

    public NodoLista(Partida partida){
        this.partida = partida;
        this.siguiente = null;
    }
    public Partida getPartida(){
        return partida;
    }
    public void setPartida(Partida partida){
        this.partida = partida;
    }
    public NodoLista getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoLista siguiente){
        this.siguiente = siguiente;
    }
}
