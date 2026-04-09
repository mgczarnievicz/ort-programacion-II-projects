/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */

package Obligatorio;

import java.util.*;

public class Partida implements Cloneable {
    //Variables
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Jugada> listaDeJugadas;

    //Set y Get de Jugador1
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador unJugador1) {
        jugador1 = unJugador1;
    }

    //Set y Get de Jugador2
    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador unJugador2) {
        jugador2 = unJugador2;
    }

    //Métodos para lista de JUGADORES
    public ArrayList<Jugada> getListaDeJugadas() {
        return listaDeJugadas;
    }

    public void eliminarJugadada(Jugada unaJugada) {
        this.getListaDeJugadas().remove(unaJugada);
    }

    public void agregarJugada(Jugada unaJugada) {
        this.getListaDeJugadas().add(unaJugada);
    }

   
    //Constructor
    public Partida() {
        this.setJugador1(null);
        this.setJugador2(null);       
        this.listaDeJugadas = new ArrayList<Jugada>();
    }

    //toString de Partida
    @Override
    public String toString(){
        return "PARTIDA ENTRE:\n"+this.getJugador1().getNombre()+"\n VS. \n"+this.getJugador2().getNombre()+"\n";
    }

    //Método para Clonar.
     @Override
    public Object clone() {
        Object ob = null;
        try {
            ob = (Partida)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("NO CLONE");
        }
        return ob;
    }
      public static int[] juegaComputador(Tablero tablero, char colorComputadora, char otroColor) {
        int[] res = new int[4];
        res[3] = -1;

        Jugada jug = new Jugada();
        jug.setTablero(tablero);

        //Recorre el tablero viendo si puede comer
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero.getTablero()[i][j].getPieza() == colorComputadora) {

                    Casillero pos[] = jug.recorrerDiagonal(i, j, 1);
                    Casillero pos2[] = jug.recorrerDiagonal(i, j, -1);
                    //Valida si puede comer.
                    if (pos[0].colorPieza(otroColor) || pos[1].colorPieza(otroColor) || pos2[0].colorPieza(otroColor) || pos2[1].colorPieza(otroColor)) {
                        res[0] = i;
                        res[1] = j;

                        //Si puede comer entonces la posición de la pieza es la de salida y la posición de la pieza rival es la de llegada.
                        //Se fija cual de los 4 casilleros es el que tiene la pieza rival y carga su posición.
                        if (pos[0].colorPieza(otroColor)) {
                            res[2] = pos[0].getCoordenadaI();
                            res[3] = pos[0].getCoordenadaJ();
                        }
                        if (pos[1].colorPieza(otroColor)) {
                            res[2] = pos[1].getCoordenadaI();
                            res[3] = pos[1].getCoordenadaJ();
                        }


                        if (pos2[0].colorPieza(otroColor)) {
                            res[2] = pos2[0].getCoordenadaI();
                            res[3] = pos2[0].getCoordenadaJ();
                        }
                        if (pos2[1].colorPieza(otroColor)) {
                            res[2] = pos2[1].getCoordenadaI();
                            res[3] = pos2[1].getCoordenadaJ();
                        }

                    }
                }
            }
        }
        //Al no poder comer debe amenazar.
        if (res[3] == -1) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    //Busca una ficha Negra.
                    if (tablero.getTablero()[i][j].colorPieza('N')) {

                        for (int k = 0; k < 2; k++) {
                            //Variable para cambiar el sentido de la búsqueda
                            int signo = 2 * k - 1;
                            for (int s = 0; s < 8; s++) {
                                //La variable s, es la que hace que se recorra las diagonales en la que esta la pieza negra hallada.
                                //Se valida que no se este fuera de rango.
                                if (s >= 0 && s <= 7 && (s * (-signo) + i + j * (signo)) >= 0 && (s * (-signo) + i + j * (signo)) <= 7) {
                                    //Se fija en la diagonal que no esta recorriendo si hay fichas del rival.
                                    Casillero cas[] = jug.recorrerDiagonal(s, i + s * (-signo) + j * signo, signo);
                                    Casillero cas2[] = jug.recorrerDiagonal(s, i + s * (-signo) + j * signo, -signo);
                                    //Valida que haya fichas del rival y que no haya fichas entre el casillero de salida y el de llegada.
                                    if ((cas[0].colorPieza(otroColor) || cas[1].colorPieza(otroColor)) && (((cas2[0].getCoordenadaI() == i) && (cas2[0].getCoordenadaJ() == j)) || ((cas2[1].getCoordenadaI() == i) && (cas2[1].getCoordenadaJ() == j)))) {
                                        //Carga como casillero de salida la casilla en la cual se hallo la ficha negra y de llegada la casilla desde la cual pudo amenazar.
                                        res[0] = i;
                                        res[1] = j;
                                        res[3] = s * (-signo) + i + j * (signo);
                                        res[2] = s;
                                        //Una vez que encuentra una, que juegue.                                    
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
