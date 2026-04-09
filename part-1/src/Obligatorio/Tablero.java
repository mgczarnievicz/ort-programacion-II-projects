/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */

package Obligatorio;

import java.util.Random;

public class Tablero implements Cloneable {
    //Variable
    private Casillero[][] tablero = new Casillero[8][8];
    

    //Set y Get de tablero
    public void setTablero(Casillero[][] cas) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = cas[i][j];
            }
        }
    }

    public Casillero[][] getTablero() {
        return tablero;
    }

    //Constructor
    public Tablero(int n) {
        tablero = new Casillero[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = new Casillero();
                tablero[i][j].setCoordenadaI(i);
                tablero[i][j].setCoordenadaJ(j);
            }
        }
    }

    //Método para Clonar.
    @Override
    public Object clone() {
        Tablero ob = null;
        try {
            ob = (Tablero) super.clone();
            ob.tablero = new Casillero[8][8];
            for (int i = 0; i < this.getTablero().length; i++) {
                for (int j = 0; j < this.getTablero().length; j++) {
                    ob.tablero[i][j] = (Casillero)this.tablero[i][j].clone();
                }
            }
        } catch (CloneNotSupportedException e) {
            System.out.println("NO CLONE");
        }
        return ob;
    }

    //toString de Tablero
    public String toString() {
        String[] letras = {"     A   ", "B   ", "C   ", "D   ", "E   ", "F   ", "G   ", "H   "};
        String devolucion="";
        for (int i = 0; i < 8; i++) {
            devolucion+=letras[i];
        }
        devolucion+="\n";
        for (int i = 0; i < 8; i++) {
            devolucion+="   ";
            for (int k = 0; k < 8; k++) {
                devolucion+="+---";
            }
            devolucion+="+\n";

            devolucion+=" " + (8 - i) + " ";

            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    devolucion+="| " + this.getTablero()[i][j].getPieza() + " ";
                } else {
                    devolucion+="|ooo";
                }
            }
            devolucion+="| " + (8 - i) + "\n";
        }
        devolucion+="   ";
        for (int k = 0; k < 8; k++) {
            devolucion+="+---";
        }
        devolucion+="+";
        devolucion+="\n";
        for (int i = 0; i < 8; i++) {
            devolucion+=letras[i];
        }
        devolucion+="\n";

        return devolucion;
    }


    //Método para rellenar la matriz aleatoriamente.
    public  Casillero[][] rellenar(char letra, int cant) {
        Random r = new Random();
        //La operación se realiza según la cantidad de piezas que se quieran ubicar.
        for (int i = 0; i < cant; i++) {
            boolean seColoco = false;
            while (!seColoco) {
                int x = r.nextInt(8);
                int y = r.nextInt(8);
                //Se valida que la casilla sea blanca y este vacía.
                if ((x + y) % 2 == 0 && this.getTablero()[x][y].colorPieza(' ')) {
                    this.getTablero()[x][y].setPieza(letra);
                    seColoco = true;
                }
            }
        }
        return this.getTablero();
    }

    //Método que cambia el tablero.
    public Casillero[][] cambioTablero(int[] pos, char turno) {
        //En la posición de salida lo deja vacío y en la de llegada la ficha del turno.
        this.getTablero()[pos[0]][pos[1]].setPieza(' ');
        this.getTablero()[pos[2]][pos[3]].setPieza(turno);
        return this.getTablero();
    }

    //Método que dado un String ya validado anteriormente coloca la ficha.
    public Casillero[][] colocarFicha(String ficha) {
        Jugada jug=new Jugada();
        jug.setJugada(ficha);
        //Traduce las posiciones.
        int pos[] = jug.traductorJugada();
        String[] pieza = ficha.split(" ");
        //En la posición traducida coloca la ficha.
        this.getTablero()[pos[0]][pos[1]].setPieza(pieza[1].charAt(0));
        return this.getTablero();
    }

    //Método que devuelve si hay fichas de un color o no en el tablero.
    public boolean hayFichas(char noTurno) {
        boolean hayFichas = false;
        //Recorre el tablero en busca de fichas del color indicado.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getTablero()[i][j].colorPieza(noTurno)) {
                    hayFichas = true;
                }
            }
        }
        return hayFichas;
    }

}
