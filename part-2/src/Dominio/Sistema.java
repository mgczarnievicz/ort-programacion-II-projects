/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

public class Sistema extends Observable implements Serializable {
    //Variables

    private ArrayList<Jugador> listaDeJugadores;
    private ArrayList<Partida> listaDePartidas;

    //Constructor
    public Sistema() {
        listaDeJugadores = new ArrayList<Jugador>();
        listaDePartidas = new ArrayList<Partida>();
        ingresoJugador("Computadora", "Compu");
    }

    //Método para lista de JUGADORES
    public ArrayList<Jugador> getListaDeJugadores() {
        return listaDeJugadores;
    }

    public void eliminarJugador(Jugador unJugador) {
        this.getListaDeJugadores().remove(unJugador);
        //Notifica que cambio
        setChanged();
        notifyObservers();
    }

    //Método para lista de PARTIDAS
    public ArrayList<Partida> getListaDePartidas() {
        return listaDePartidas;
    }

    public void eliminarPartidas(Partida unPartida) {
        this.getListaDePartidas().remove(unPartida);
        //NOtifica que cambio
        setChanged();
        notifyObservers();
    }

    public void agregarPartidas(Partida unPartida) {
        this.getListaDePartidas().add(unPartida);
        //Notifica que cambio
        setChanged();
        notifyObservers();
    }

    //Método para ingresar un jugador
    public String ingresoJugador(String nombre, String alias) {
        String retorno = "BIEN";
        if (nombre.trim().equalsIgnoreCase("")) {
            retorno = "Debe Darle un Nombre al Jugador";
        } else {
            for (int i = 0; i < this.getListaDeJugadores().size(); i++) {
                if (nombre.equalsIgnoreCase(this.getListaDeJugadores().get(i).getNombre())) {
                    retorno = "Ya Existe un Jugador con ese Nombre";
                }
            }
            if (retorno.equalsIgnoreCase("BIEN")) {
                Jugador jug = new Jugador();
                jug.setAlias(alias);
                jug.setNombre(nombre);
                this.getListaDeJugadores().add(jug);
                setChanged();
                notifyObservers();
            }
        }
        return retorno;
    }

    //Método para ingresar una Partida, la cual se crea con los parámetros pasados
    public Partida ingresoPartida(Jugador jugB, Jugador jugN, int cant) {
        Partida part = new Partida();
        part.setJugadorB(jugB);
        part.setJugadorN(jugN);
        part.agregarJugada(part.ingresoJugada(cant));
        this.agregarPartidas(part);
        setChanged();
        notifyObservers();
        return part;
    }

    //Método que recupera el sistema guardado
    public static Sistema recuperarSistema() {
        Sistema sis;
        try {
            FileInputStream fff = new FileInputStream("src//Guardado//archivo");
            BufferedInputStream bbb = new BufferedInputStream(fff);
            ObjectInputStream sss = new ObjectInputStream(bbb);
            sis = (Sistema) (sss.readObject());

        } catch (Exception e1) {
            //Me creo un nuevo sistema
            sis = new Sistema();
        }
        return sis;
    }

    //Método qeu guarda al sistema
    public static void guardarSistema(Sistema sis) throws FileNotFoundException, IOException {
        FileOutputStream ff = new FileOutputStream("src//Guardado//archivo");
        BufferedOutputStream b = new BufferedOutputStream(ff);
        ObjectOutputStream ss = new ObjectOutputStream(b);
        ss.writeObject(sis);
        ss.flush();
        ss.close();
    }

    //Copio la lista para que no muestre la lista al Jugador Computadora
    public static ArrayList<Jugador> clonoLista(ArrayList<Jugador> listaJug1) {
        ArrayList<Jugador> listaCopiada = new ArrayList();
        for (int i = 1; i < listaJug1.size(); i++) {
            listaCopiada.add(listaJug1.get(i));
        }
        return listaCopiada;
    }

    //Método que ordena una lista de Jugadores
    public static ArrayList<Jugador> ordenar(ArrayList<Jugador> lista){
        Collections.sort(lista);
        return lista;
    }
}
