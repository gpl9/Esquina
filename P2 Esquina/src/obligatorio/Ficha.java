package obligatorio;

import java.io.Serializable;

public class Ficha implements Serializable{

    private boolean color;
    private int ficha;

    public Ficha() {
        this.setFicha(0);
        this.setColor(true);
    }

    public Ficha(int unaFicha, boolean color) {
        this.setFicha(unaFicha);
        this.setColor(color);
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean colorRojo) {
        this.color = colorRojo;
    }

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int unaFicha) {
        this.ficha = unaFicha;
    }

    public String obtenerFichaAzul() {
        return "\033[34m" + getFicha() + "\033[30m";
    }

    public String obtenerFichaRoja() {
        return "\033[31m" + getFicha() + "\033[30m";
    }

    @Override

    public String toString() {
        if (this.isColor()) {
            return obtenerFichaRoja();
        }
        return obtenerFichaAzul();
    }
}
