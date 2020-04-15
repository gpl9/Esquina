package obligatorio;

import java.io.Serializable;

public class Tablero implements Serializable{

    private Ficha ficha;
    private Ficha[][] tablero;

    public Tablero() {

        this.setFicha(new Ficha());
        tablero = new Ficha[6][6];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                Ficha nuevaFicha = new Ficha();
                tablero[i][j] = nuevaFicha;

            }
        }
    }

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] unTablero) {
        this.tablero = unTablero;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha unaFicha) {
        this.ficha = unaFicha;
    }

}
