/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */

package Obligatorio;

import java.util.ArrayList;

public class Sistema {
    //Variables
    private ArrayList<Jugador> listaDeJugadores;
    private ArrayList<Partida> listaDePartidas;

    //Constructor
    public Sistema() {
        listaDeJugadores = new ArrayList<Jugador>();
        listaDePartidas = new ArrayList<Partida>();
    }

    //Métodos para lista de JUGADORES
    public ArrayList<Jugador> getListaDeJugadores() {
        return listaDeJugadores;
    }

    public void eliminarJugador(Jugador unJugador) {
        this.getListaDeJugadores().remove(unJugador);
    }

    public void agregarJugador(Jugador unJugador) {
        this.getListaDeJugadores().add(unJugador);
    }

    

    //Metodo para lista de PARTIDAS
    public ArrayList<Partida> getListaDePartidas() {
        return listaDePartidas;
    }

    public void eliminarPartidas(Partida unPartida) {
        this.getListaDePartidas().remove(unPartida);
    }

    public void agregarPartidas(Partida unPartida) {
        this.getListaDePartidas().add(unPartida);
    }
}
