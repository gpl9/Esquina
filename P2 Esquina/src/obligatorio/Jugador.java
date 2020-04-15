package obligatorio;

import java.io.Serializable;

public class Jugador implements Comparable<Jugador>, Serializable {

    private String jugador;
    private String nombre;
    private String alias;
    private int edad;
    private int esquina;
    public int cantGanadas;
    private boolean ganadas;
    private int cantFichas;

    public Jugador() {
        this.setNombre("Sin nombre");
        this.setAlias("Sin alias");
        this.setEdad(0);
        this.setEsquina(0);
        this.setCantFichas(25);
        this.setGanadas(false);
        this.setCantGanadas(0);
    }

    public Jugador(String unNombre, String unAlias, int unaEdad) {
        this.setNombre(unNombre);
        this.setAlias(unAlias);
        this.setEdad(unaEdad);
    }

    public int getCantGanadas() {
        return cantGanadas;
    }

    public void setCantGanadas(int unaCantGanadas) {
        this.cantGanadas = unaCantGanadas;
    }

    public int getEsquina() {
        return esquina;
    }

    public void setEsquina(int unaEsquina) {
        this.esquina = unaEsquina;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String unJugador) {
        this.jugador = unJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String unAlias) {
        this.alias = unAlias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }

    public int getCantFichas() {
        return cantFichas;
    }

    public void setCantFichas(int unCantFichas) {
        this.cantFichas = unCantFichas;
    }

    public boolean isGanadas() {
        return ganadas;
    }

    public void setGanadas(boolean unaGanadas) {
        this.ganadas = unaGanadas;
    }

    @Override

    public String toString() {
        return "Nombre: " + this.getNombre() + "\nAlias: " + this.getAlias() + "\nEdad: " + this.getEdad() + "\nPartidas Ganadas: " + this.getCantGanadas();
    }

    public boolean equals(Object o) {
        return this.getAlias().equals(o);
    }

    @Override
    public int compareTo(Jugador o) {
        return (o.getCantGanadas()) - this.getCantGanadas();
    }
}
