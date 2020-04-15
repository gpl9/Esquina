package obligatorio;

import java.io.Serializable;

public class Partida implements Serializable {

    private boolean terminado;
    private Jugador jugador1;
    private Jugador jugador2;
    boolean primerIngreso = true;
    boolean color = true;
    boolean partidaComputadora;
    private boolean[][] tableroBooleano;

    public Partida() {
        tableroBooleano = new boolean[6][6];
        partidaComputadora = false;
        terminado = false;
        jugador1 = new Jugador();
        jugador2 = new Jugador();
    }

    public boolean isPartidaComputadora() {
        return partidaComputadora;
    }

    public void setPartidaComputadora(boolean unaPartidaComputadora) {
        this.partidaComputadora = unaPartidaComputadora;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean unTerminado) {
        this.terminado = unTerminado;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void turnos(Tablero tablero, Ficha tableroAux[][], int fila, int columna, Ficha fichas) {

        tablero.getFicha().setFicha(1);
        insertarFichasTablero(tablero, fila, columna, tableroAux, terminado, fichas, isTerminado());
        partidaTerminada(tableroAux);
    }

    public void turnoComputadora(Tablero tablero, int fila, int columna, Ficha tableroAux[][], Ficha fichas) {
        partidaTerminada(tableroAux);
        tablero.getFicha().setFicha(1);
        insertarFichasTablero(tablero, fila, columna, tableroAux, terminado, fichas, isTerminado());
        jugadaDeComputadora(tablero, tableroAux, fichas, terminado);

    }

    public void jugadaDeComputadora(Tablero tablero, Ficha tableroAux[][], Ficha fichas, boolean terminado) {
        int contador;
        int max = Integer.MIN_VALUE;

        int fila = 0;
        int columna = 0;
        Ficha tableroAuxiliar[][] = tablero.getTablero().clone();

        for (int i = 0; i < tableroAux.length; i++) {
            for (int j = 0; j < tableroAux[0].length; j++) {
                if (movimientosPosibles(tablero, i, j, tableroAux, terminado, fichas, true)
                        && restriccionCuadrado(i, j, tableroAux, fichas) && tableroAuxiliar[i][j].getFicha() == 0) {

                    contador = contadorEsquinas(i, j, tableroAux, fichas);
                    if (contador >= max) {
                        max = contador;
                        fila = i;
                        columna = j;

                    }
                }
            }
        }
        insertarAdyacentes(tablero, fila, columna, tableroAuxiliar, terminado, fichas, color);
    }

    public void insertarFichasTablero(Tablero tablero, int filas, int columnas, Ficha[][] tableroAux, boolean terminado, Ficha fichas, boolean computadora) {
        insertarAdyacentes(tablero, filas, columnas, tableroAux, terminado, fichas, computadora);
    }

    public boolean movimientosPosibles(Tablero tablero, int filas, int columnas, Ficha tableroAux[][], boolean terminado, Ficha fichas, boolean juegaComputadora) {
        boolean entrar = false;
        boolean cuadrado;

        cuadrado = restriccionCuadrado(filas, columnas, tableroAux, fichas);

        if (validarPosicion(filas, columnas) && cuadrado && tableroAux[filas][columnas].getFicha() == 0) {

            if (primerIngreso && tableroAux[filas][columnas].getFicha() < 1) {
                entrar = true;
                primerIngreso = false;
            } else if (tableroAux[filas][columnas].getFicha() < 1 && primerIngreso == false && cuadrado) {
                if (validarPosicion(filas - 1, columnas - 1) && tableroAux[filas - 1][columnas - 1].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas - 1, columnas) && tableroAux[filas - 1][columnas].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas - 1, columnas + 1) && tableroAux[filas - 1][columnas + 1].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas, columnas - 1) && tableroAux[filas][columnas - 1].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas, columnas + 1) && tableroAux[filas][columnas + 1].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas + 1, columnas - 1) && tableroAux[filas + 1][columnas - 1].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas + 1, columnas) && tableroAux[filas + 1][columnas].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }
                if (validarPosicion(filas + 1, columnas + 1) && tableroAux[filas + 1][columnas + 1].getFicha() > 0 && tableroAux[filas][columnas].getFicha() == 0) {
                    entrar = true;
                }

            } else {
                entrar = false;
            }

        }
        return entrar;
    }

    public void insertarAdyacentes(Tablero tablero, int filas, int columnas, Ficha tableroAux[][], boolean terminado, Ficha fichas, boolean computadora) {
        if (movimientosPosibles(tablero, filas, columnas, tableroAux, terminado, fichas, computadora) && color && !primerIngreso) {
            tableroAux[filas][columnas].setColor(color);
            tableroBooleano[filas][columnas] = color;
            tableroAux[filas][columnas].setFicha((tableroAux[filas][columnas]).getFicha() + 1);
            getJugador1().setCantFichas(getJugador1().getCantFichas() - 1);
            esquina(tablero, filas, columnas, tableroAux, terminado, fichas);
            color = !color;

        } else if (movimientosPosibles(tablero, filas, columnas, tableroAux, terminado, fichas, computadora) && !color && !primerIngreso) {
            tableroAux[filas][columnas].setColor(color);
            tableroBooleano[filas][columnas] = color;
            tableroAux[filas][columnas].setFicha((tableroAux[filas][columnas]).getFicha() + 1);
            getJugador2().setCantFichas(getJugador2().getCantFichas() - 1);
            esquina(tablero, filas, columnas, tableroAux, terminado, fichas);
            color = !color;
        } else {
            movimientoIncorrecto(tablero, filas, columnas, tableroAux, color, terminado, fichas, computadora);
        }

    }

    public void movimientoIncorrecto(Tablero tablero, int filas, int columnas, Ficha tableroAux[][], boolean color, boolean terminado, Ficha fichas, boolean juegaComputadora) {

        if (!movimientosPosibles(tablero, filas, columnas, tableroAux, terminado, fichas, juegaComputadora) || !restriccionCuadrado(filas, columnas, tableroAux, fichas)) {
            tablero.getFicha().setColor(color);
            tableroAux[filas][columnas].setFicha(0);
        }
    }

    public boolean restriccionCuadrado(int filas, int columnas, Ficha tableroAux[][], Ficha fichas) {
        boolean resultado = true;

        if (validarPosicion(filas, columnas - 1) && tableroAux[filas][columnas - 1].getFicha() > 0
                && validarPosicion(filas - 1, columnas - 1) && tableroAux[filas - 1][columnas - 1].getFicha() > 0
                && validarPosicion(filas - 1, columnas) && tableroAux[filas - 1][columnas].getFicha() > 0) {
            resultado = false;
        }
        if (validarPosicion(filas, columnas + 1) && tableroAux[filas][columnas + 1].getFicha() > 0
                && validarPosicion(filas - 1, columnas) && tableroAux[filas - 1][columnas].getFicha() > 0
                && validarPosicion(filas - 1, columnas + 1) && tableroAux[filas - 1][columnas + 1].getFicha() > 0) {
            resultado = false;
        }
        if (validarPosicion(filas, columnas - 1) && tableroAux[filas][columnas - 1].getFicha() > 0
                && validarPosicion(filas + 1, columnas - 1) && tableroAux[filas + 1][columnas - 1].getFicha() > 0
                && validarPosicion(filas + 1, columnas) && tableroAux[filas + 1][columnas].getFicha() > 0) {
            resultado = false;
        }
        if (validarPosicion(filas + 1, columnas) && tableroAux[filas + 1][columnas].getFicha() > 0
                && validarPosicion(filas + 1, columnas + 1) && tableroAux[filas + 1][columnas + 1].getFicha() > 0
                && validarPosicion(filas, columnas + 1) && tableroAux[filas][columnas + 1].getFicha() > 0) {
            resultado = false;
        }

        return resultado;
    }

    public boolean validacionEsquina(int filas, int columnas, Ficha tableroAux[][], Ficha fichas) {
        boolean esquinas = false;

        if (validarPosicion(filas, columnas + 1) && tableroAux[filas][columnas + 1].getFicha() > 0
                && validarPosicion(filas + 1, columnas) && tableroAux[filas + 1][columnas].getFicha() > 0) {
            return true;
        }
        if (validarPosicion(filas, columnas - 1) && tableroAux[filas][columnas - 1].getFicha() > 0
                && validarPosicion(filas + 1, columnas) && tableroAux[filas + 1][columnas].getFicha() > 0) {
            return true;
        }
        if (validarPosicion(filas, columnas - 1) && tableroAux[filas][columnas - 1].getFicha() > 0
                && validarPosicion(filas - 1, columnas) && tableroAux[filas - 1][columnas].getFicha() > 0) {
            return true;
        }
        if (validarPosicion(filas - 1, columnas) && tableroAux[filas - 1][columnas].getFicha() > 0
                && validarPosicion(filas, columnas + 1) && tableroAux[filas][columnas + 1].getFicha() > 0) {
            return true;
        }
        return esquinas;
    }

    public void esquina(Tablero tablero, int filas, int columnas, Ficha[][] tableroAux, boolean terminado, Ficha fichas) {

        int nroEsquina;

        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                if (validacionEsquina(filas, columnas, tableroAux, fichas) && validarPosicion(filas, columnas) && tableroAux[filas][columnas].getFicha() > 0) {
                    nroEsquina = tableroAux[filas][columnas].getFicha();
                    if (color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas][columnas].setFicha((nroEsquina) + 1);
                        tableroAux[filas][columnas].setColor(color);
                        tableroBooleano[filas][columnas] = color;
                        getJugador1().setEsquina(getJugador1().getEsquina() + 1);
                        getJugador1().setCantFichas(getJugador1().getCantFichas() - 1);
                    } else if (!color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas][columnas].setFicha((nroEsquina) + 1);
                        tableroAux[filas][columnas].setColor(color);
                        tableroBooleano[filas][columnas] = color;
                        getJugador2().setEsquina(getJugador2().getEsquina() + 1);
                        getJugador2().setCantFichas(getJugador2().getCantFichas() - 1);

                    }

                }
            } else {

                if (validacionEsquina(filas + i, columnas, tableroAux, fichas) && validarPosicion(filas + i, columnas) && tableroAux[filas + i][columnas].getFicha() > 0) {
                    nroEsquina = tableroAux[filas + i][columnas].getFicha();
                    if (color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas + i][columnas].setFicha((nroEsquina) + 1);
                        tableroAux[filas + i][columnas].setColor(color);
                        tableroBooleano[filas + i][columnas] = color;
                        getJugador1().setEsquina(getJugador1().getEsquina() + 1);
                        getJugador1().setCantFichas(getJugador1().getCantFichas() - 1);
                    } else if (!color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas + i][columnas].setFicha((nroEsquina) + 1);
                        tableroAux[filas + i][columnas].setColor(color);
                        tableroBooleano[filas + i][columnas] = color;
                        getJugador2().setEsquina(getJugador2().getEsquina() + 1);
                        getJugador2().setCantFichas(getJugador2().getCantFichas() - 1);

                    }

                }

                if (validacionEsquina(filas - i, columnas, tableroAux, fichas) && validarPosicion(filas - i, columnas) && tableroAux[filas - i][columnas].getFicha() > 0) {
                    nroEsquina = tableroAux[filas - i][columnas].getFicha();
                    if (color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas - i][columnas].setFicha((nroEsquina) + 1);
                        tableroAux[filas - i][columnas].setColor(color);
                        tableroBooleano[filas - i][columnas] = color;
                        getJugador1().setEsquina(getJugador1().getEsquina() + 1);
                        getJugador1().setCantFichas(getJugador1().getCantFichas() - 1);
                    } else if (!color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas - i][columnas].setFicha((nroEsquina) + 1);
                        tableroAux[filas - i][columnas].setColor(color);
                        tableroBooleano[filas - i][columnas] = color;
                        getJugador2().setEsquina(getJugador2().getEsquina() + 1);
                        getJugador2().setCantFichas(getJugador2().getCantFichas() - 1);
                    }

                }

                if (validacionEsquina(filas, columnas + i, tableroAux, fichas) && validarPosicion(filas, columnas + i) && tableroAux[filas][columnas + i].getFicha() > 0) {

                    nroEsquina = tableroAux[filas][columnas + i].getFicha();
                    if (color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas][columnas + i].setFicha((nroEsquina) + 1);
                        tableroAux[filas][columnas + i].setColor(color);
                        tableroBooleano[filas][columnas + i] = color;
                        getJugador1().setEsquina(getJugador1().getEsquina() + 1);
                        getJugador1().setCantFichas(getJugador1().getCantFichas() - 1);
                    } else if (!color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas][columnas + i].setFicha((nroEsquina) + 1);
                        tableroAux[filas][columnas + i].setColor(color);
                        tableroBooleano[filas][columnas + i] = color;
                        getJugador2().setEsquina(getJugador2().getEsquina() + 1);
                        getJugador2().setCantFichas(getJugador2().getCantFichas() - 1);
                    }

                }
                if (validacionEsquina(filas, columnas - i, tableroAux, fichas) && validarPosicion(filas, columnas - i) && tableroAux[filas][columnas - i].getFicha() > 0) {

                    nroEsquina = tableroAux[filas][columnas - i].getFicha();
                    if (color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas][columnas - i].setFicha((nroEsquina) + 1);
                        tableroAux[filas][columnas - i].setColor(color);
                        tableroBooleano[filas][columnas - i] = color;
                        getJugador1().setCantFichas(getJugador1().getCantFichas() - 1);
                    } else if (!color && numeroEsquina(nroEsquina)) {
                        tableroAux[filas][columnas - i].setFicha((nroEsquina) + 1);
                        tableroAux[filas][columnas - i].setColor(color);
                        tableroBooleano[filas][columnas - i] = color;
                        getJugador2().setEsquina(getJugador2().getEsquina() + 1);
                        getJugador2().setCantFichas(getJugador2().getCantFichas() - 1);
                    }

                }
            }

        }

    }

    public int contadorEsquinas(int filas, int columnas, Ficha[][] tableroAux, Ficha fichas) {
        int contador = 0;
        for (int i = 0; i < 6; i++) {

            if (validacionEsquina(filas + i, columnas, tableroAux, fichas) && validarPosicion(filas + i, columnas) && tableroAux[filas + i][columnas].getFicha() != 0) {
                contador++;
            }
            if (validacionEsquina(filas + i, columnas, tableroAux, fichas) && validarPosicion(filas - i, columnas) && tableroAux[filas - i][columnas].getFicha() != 0) {
                contador++;
            }
            if (validacionEsquina(filas, columnas + i, tableroAux, fichas) && validarPosicion(filas, columnas + i) && tableroAux[filas][columnas + i].getFicha() != 0) {
                contador++;
            }
            if (validacionEsquina(filas, columnas - i, tableroAux, fichas) && validarPosicion(filas, columnas - i) && tableroAux[filas][columnas - i].getFicha() != 0) {
                contador++;
            }
            if (validacionEsquina(filas + i, columnas, tableroAux, fichas)
                    && validacionEsquina(filas + i, columnas, tableroAux, fichas)
                    && validacionEsquina(filas, columnas + i, tableroAux, fichas)
                    && validacionEsquina(filas, columnas - i, tableroAux, fichas)
                    && tableroAux[filas + i][columnas].getFicha() == 5 && tableroAux[filas - i][columnas].getFicha() == 5
                    && tableroAux[filas][columnas + i].getFicha() == 5
                    && tableroAux[filas][columnas - i].getFicha() == 5) {

                contador = 0;
            }
        }

        return contador;
    }

    public void partidaTerminada(Ficha tableroAux[][]) {
        if (getJugador1().getCantFichas() < 1 || getJugador2().getCantFichas() < 1 || isTerminado()) {
            setTerminado(true);
            validacionGanador(tableroAux);

        }
    }

    public boolean numeroEsquina(int esquina) {
        if (esquina >= 5) {
            return false;
        }
        return true;
    }

    public void validacionGanador(Ficha tableroAux[][]) {
        int contador1 = 0;
        int contador2 = 0;

        for (int i = 0; i < tableroBooleano.length; i++) {
            for (int j = 0; j < tableroBooleano[0].length; j++) {
                if (tableroBooleano[i][j] == true) {
                    if (tableroAux[i][j].getFicha() > 1) {
                        contador1 = contador1 + tableroAux[i][j].getFicha();
                    }
                } else if (tableroAux[i][j].getFicha() > 1) {
                    contador2 = contador2 + tableroAux[i][j].getFicha();
                }
            }
        }
        contador1 = contador1 - getJugador1().getCantFichas();
        contador2 = contador2 - getJugador2().getCantFichas();

        if (terminado && contador1 >= contador2) {
            jugador1.setGanadas(true);
            jugador1.setCantGanadas(getJugador1().getCantGanadas() + 1);
        } else if (terminado && contador2 >= contador1) {
            jugador2.setGanadas(true);
            jugador2.setCantGanadas(getJugador2().getCantGanadas() + 1);
        }
    }

    private boolean validarPosicion(int filas, int columnas) {
        if (filas < 0 || columnas < 0 || filas > 5 || columnas > 5) {
            return false;
        }
        return true;
    }
}
