/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Dominio;

import java.io.Serializable;
import java.util.Observable;

public final class Jugador extends Observable implements Comparable<Jugador>, Cloneable, Serializable  {
    //Variables
    private String nombre;
    private String alias;
    private int juegosJugados;
    private int partidosGanados;

    //Get y Set de NOMBRE
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
        setChanged();
        notifyObservers();
    }

    //Get y Set de ALIAS
    public String getAlias() {
        return alias;
    }

    public void setAlias(String unAlias) {
        alias = unAlias;
        setChanged();
        notifyObservers();
    }

    //Get y Set de JUEGOSJUGADOS
    public int getJuegosJugados() {
        return juegosJugados;


    }

    public void setJuegosJugados(int unosJuegosJugados) {
        juegosJugados = unosJuegosJugados;
        setChanged();
        notifyObservers();
    }

    //Get y Set de PARTIDOSGANADOS
    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int unosPartidosGanados) {
        partidosGanados = unosPartidosGanados;
        setChanged();
        notifyObservers();
    }

    //2 jugadores son iguales si tienen el mismo nombre.
    @Override
    public boolean equals(Object jugador) {
        return this.getNombre().equalsIgnoreCase(((Jugador) jugador).getNombre());
    }

//toString
    @Override
    public String toString() {
        return   getNombre();                
    }

//Constructor
    public Jugador() {
        this.setNombre("Sin nombre");
        this.setAlias("Sin alias");
        this.setPartidosGanados(0);
        this.setJuegosJugados(0);
    }

    //CompareTo que ordena según la cantidad de juegos jugados en forma decreciente.
    public int compareTo(Jugador j) {
        return j.getJuegosJugados() - this.getJuegosJugados();
    }
    //Método CLONAR
    @Override
    public Object clone() {
        Object ob = null;
        try {
            ob = (Jugador) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("NO CLONE");
        }
        return ob;
    }

}

