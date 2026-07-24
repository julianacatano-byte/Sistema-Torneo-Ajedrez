package Modelos;

public class Jugador {
    private String nombre;
    private String cedula;
    private int puntaje;

public Jugador(String nombre, String cedula) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.puntaje = 0;
}

        public String getNombre () {
            return nombre;
        }
        public void setNombre (String nombre){
            this.nombre = nombre;
        }
        public String getCedula () {
            return cedula;
        }
        public void setCedula (String cedula){
            this.cedula = cedula;
        }
        public int getPuntaje () {
            return puntaje;
        }
        public void setPuntaje ( int puntaje){
            this.puntaje = puntaje;
        }
    }
