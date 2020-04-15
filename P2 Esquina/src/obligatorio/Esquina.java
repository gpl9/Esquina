package obligatorio;

import java.io.*;
import persistencia.*;
import java.util.*;

//import static obligatorio.Obligatorio.pedirNumero;
public class Esquina implements Serializable {

    private Jugador jugador1;
    private Jugador jugador2;
    private Persistencia persistencia;
    private Tablero tablero;
    private Partida partida;
    private Ficha ficha;
    private Excel excel;
    private int cantidadSegundos;

    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Partida> listadoPartida;
    private ArrayList<String> registro;

    public Esquina() {
        registro = new ArrayList<String>();
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        cantidadSegundos = 60;
        excel = new Excel();
        persistencia = new Persistencia(this);
        partida = new Partida();
        tablero = new Tablero();
        ficha = new Ficha();
        listadoPartida = new ArrayList<Partida>();
        listaJugadores = new ArrayList<Jugador>();

    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador unJugador1) {
        this.jugador1 = unJugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador unJugador2) {
        this.jugador2 = unJugador2;
    }

    public int getCantidadSegundos() {
        return cantidadSegundos;
    }

    public void setCantidadSegundos(int cantidadSegundos) {
        this.cantidadSegundos = cantidadSegundos;
    }

    public Excel getExcel() {
        return excel;
    }

    public void setExcel(Excel unExcel) {
        this.excel = unExcel;
    }

    public Persistencia getPersistencia() {
        return persistencia;
    }

    public void setPersistencia(Persistencia unaPersistencia) {
        this.persistencia = unaPersistencia;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha unaFicha) {
        this.ficha = unaFicha;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero unTablero) {
        this.tablero = unTablero;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public ArrayList<Jugador> getListaJugadores() {
        Collections.sort(listaJugadores);
        return listaJugadores;
    }

    public void agregarListaJugadores(Jugador unJugador) {
        this.getListaJugadores().add(unJugador);
    }

    public ArrayList<Partida> getListaPartida() {
        return listadoPartida;
    }

    public void agregarRegistro(String unRegistro) {
        this.getListaRegistro().add(unRegistro);
    }

    public ArrayList<String> getListaRegistro() {
        return registro;
    }

    public void agregarListadoPartida(Partida unaPartida) {
        this.getListaPartida().add(unaPartida);
    }

    public void registroJugador(String nombre, String alias, int edad) {
        Jugador jugador = new Jugador();

        jugador.setNombre(nombre);
        jugador.setAlias(alias);
        jugador.setEdad(edad);
        agregarListaJugadores(jugador);
    }

    public void cantidadGanadas() {
        for (int i = 0; i < getListaJugadores().size(); i++) {
            if (getPartida().getJugador1().getAlias().equals(getListaJugadores().get(i).getAlias())) {
                getListaJugadores().get(i).setCantGanadas(getPartida().getJugador1().getCantGanadas() + getListaJugadores().get(i).getCantGanadas());
            } else if (getPartida().getJugador2().getAlias().equals(getListaJugadores().get(i).getAlias())) {
                getListaJugadores().get(i).setCantGanadas(getPartida().getJugador2().getCantGanadas() + getListaJugadores().get(i).getCantGanadas());
            }
        }

    }

}
