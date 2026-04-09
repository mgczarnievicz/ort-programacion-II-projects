/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */

package Dominio;

import java.io.Serializable;

public class Casillero implements Cloneable, Serializable {
    //Variables.
    private char pieza;
    private int coordenadaI;
    private int coordenadaJ;

    //ToString
    @Override
    public String toString() {
        return Character.toString(pieza)+" "+Integer.toString(coordenadaI)+" "+Integer.toString(coordenadaJ);
    }

    //Set y Get de CoordenadaI
    public int getCoordenadaI (){
        return coordenadaI;
    }

    public void setCoordenadaI(int unaCoordenadaI){
        coordenadaI=unaCoordenadaI;
    }

    //Set y Get de CoordenadaJ
    public int getCoordenadaJ (){
        return coordenadaJ;
    }

    public void setCoordenadaJ(int unaCoordenadaJ){
        coordenadaJ=unaCoordenadaJ;
    }

    //Get y Set de PIEZA
    public char getPieza() {
        return pieza;
    }

    public void setPieza(char unaPieza) {
        pieza = unaPieza;
    }

    //Constructor
    public Casillero() {
        this.setPieza(' ');
    }

    //Método que devuelve si el color de la pieza en un casillero es el indicado en el parámetro.
    public boolean colorPieza(char letra) {
        boolean color = false;
        if (this.getPieza() == letra) {
            color = true;
        }
        return color;
    }

    @Override
    //Clonar.
    public Object clone() {
        Object ob = null;
        try {
            ob = (Casillero)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("NO CLONE");
        }
        return ob;
    }



}
