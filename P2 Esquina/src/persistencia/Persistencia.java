package persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import obligatorio.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Persistencia {

    Esquina esquina;

    public Persistencia(Esquina unaEsquina) {
        this.esquina = unaEsquina;
    }

    //Guarda los jugadores registrados
    public void writeObject() throws IOException, ClassNotFoundException {
        try {
            FileOutputStream f = new FileOutputStream("jugadores.dat");
            BufferedOutputStream b = new BufferedOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.writeObject(esquina.getListaJugadores());
            o.flush();
            o.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {

        }
    }

    //Se muestran los jugadores guardados
    public void readObject()
            throws IOException, ClassNotFoundException {
        try {
            FileInputStream f = new FileInputStream("jugadores.dat");
            BufferedInputStream b = new BufferedInputStream(f);
            ObjectInputStream s = new ObjectInputStream(b);
            ArrayList<Jugador> lista = ((ArrayList<Jugador>) s.readObject());
            for (int i = 0; i < lista.size(); i++) {
                esquina.agregarListaJugadores(lista.get(i));
            }
            s.readObject();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {

        }
    }

    public void writePartida() throws IOException, ClassNotFoundException {
        try {
            FileOutputStream f = new FileOutputStream("partida.dat");
            BufferedOutputStream b = new BufferedOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.writeObject(esquina.getListaPartida());
            o.flush();
            o.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {

        }
    }

    public void readPartida()
            throws IOException, ClassNotFoundException {
        try {
            FileInputStream f = new FileInputStream("partida.dat");
            BufferedInputStream b = new BufferedInputStream(f);
            ObjectInputStream s = new ObjectInputStream(b);
            ArrayList<Partida> lista = ((ArrayList<Partida>) s.readObject());
            //esquina = ((Esquina) s.readObject());
            for (int i = 0; i < lista.size(); i++) {
                esquina.agregarListadoPartida(lista.get(i));
            }
            s.readObject();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {

        }
    }
}
