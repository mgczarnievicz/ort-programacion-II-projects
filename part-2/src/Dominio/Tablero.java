/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Dominio;

import java.io.Serializable;
import java.util.Random;

public class Tablero implements Cloneable, Serializable {
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
                    ob.tablero[i][j] = (Casillero) this.tablero[i][j].clone();
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
        String devolucion = "";
        for (int i = 0; i < 8; i++) {
            devolucion += letras[i];
        }
        devolucion += "\n";
        for (int i = 0; i < 8; i++) {
            devolucion += "   ";
            for (int k = 0; k < 8; k++) {
                devolucion += "+---";
            }
            devolucion += "+\n";

            devolucion += " " + (8 - i) + " ";

            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    devolucion += "| " + this.getTablero()[i][j].getPieza() + " ";
                } else {
                    devolucion += "|ooo";
                }
            }
            devolucion += "| " + (8 - i) + "\n";
        }
        devolucion += "   ";
        for (int k = 0; k < 8; k++) {
            devolucion += "+---";
        }
        devolucion += "+";
        devolucion += "\n";
        for (int i = 0; i < 8; i++) {
            devolucion += letras[i];
        }
        devolucion += "\n";

        return devolucion;
    }

    //Método para rellenar la matriz aleatoriamente.
    public Casillero[][] rellenar(char letra, int cant) {
        Random r = new Random();
        //La operación realiza la cantidad de piezas que se quieran ubicar.
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
        Jugada jug = new Jugada();
        jug.setJugada(ficha);
        //Traduce las posiciones.
        int pos[] = jug.traductorJugada();
        String[] pieza = ficha.split(" ");
        //En la posición traducida coloca la pieza.
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

    public static String[] colocarAMano(Tablero tab, String fichas, String hayBlanco, String hayNegro, int num) {
        //Mensajes que se relacionan con la interfaz.
        String mensaje[] = new String[4];
        mensaje[0] = "";
        mensaje[1] = "";
        mensaje[2] = "";
        mensaje[3] = "";
        //Se cargan las variables segun las entradas desde la interfaz.
        boolean seColocoB = false;
        if (hayBlanco.equals("SI")) {
            seColocoB = true;
            mensaje[2] = ("SI");
        }
        boolean seColocoN = false;
        if (hayNegro.equals("SI")) {
            seColocoN = true;
            mensaje[3] = ("SI");
        }

        int cantTotal = num;
        Jugada jug = new Jugada();
        jug.setJugada(fichas);
        //Se sigue pidiendo el ingreso y validandolo mientras que no se escriba "FIN" ya habiendo colocado una pieza de cada color.
        if (!(fichas.equals("FIN") && seColocoB && seColocoN)) {
            if (!fichas.equals("FIN")) {
                //Se valida que sea de la forma correcta.
                if (jug.colocoVali().equals("BIEN")) {
                    //Se traduce y se fija si es una casilla blanca.
                    int posicion[] = jug.traductorJugada();
                    if ((posicion[0] + posicion[1]) % 2 == 0) {
                        //Valida que la casilla estuviera vacía.
                        if (tab.getTablero()[posicion[0]][posicion[1]].colorPieza(' ')) {
                            String letra[] = fichas.split(" ");
                            char pieza = letra[1].charAt(0);
                            //Marca cuando se coloca una pieza del color.
                            if (pieza == 'N') {
                                seColocoN = true;
                                //Se carga que hay una ficha negra.
                                mensaje[3] = "SI";
                                cantTotal++;
                            }
                            if (pieza == 'B') {
                                seColocoB = true;
                                //Se carga que hay una ficha blanca.
                                mensaje[2] = "SI";
                                cantTotal++;
                            }
                            //Obliga que se ingrese una ficha de cada color al comenzar.
                            if ((cantTotal > 1) && ((seColocoB && !seColocoN && pieza == 'B') || (seColocoN && !seColocoB && pieza == 'N'))) {
                                mensaje[0] += ("\nDebe ingresar una pieza de cada color al comenzar");
                            } else {
                                //Despues de todas las validaciones se coloca la ficha y se carga el tablero.
                                tab.colocarFicha(fichas);
                                mensaje[0] += (tab);
                                mensaje[1] = "BIEN";
                            }
                        } else {
                            mensaje[0] += ("\nEsa casilla ya esta ocupada");
                        }
                    } else {
                        //Se cargan los errores.
                        mensaje[0] += ("\nLa casilla no es blanca");
                    }
                } else {
                    //Se cargan los errores.
                    mensaje[0] += ("\n" + jug.colocoVali());
                }
            } else {
                //Si se escribe "FIN" sin haber colocado una ficha de cada color carga que se debe pedir el ingreso nuevamente.
                if (!seColocoB || !seColocoN) {
                    mensaje[0] += ("\nDebe ingresar al menos una ficha de cada color.");
                }
            }
        } else {
            //Carga que se puede finalizar la carga.
            mensaje[1] = "FIN";
        }
        return mensaje;
    }

    public boolean hayDeAmbosColores() {
        boolean retorno = false;
        boolean hayNegro = false;
        boolean hayBlanco = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getTablero()[i][j].colorPieza('B')) {
                    hayBlanco = true;
                }
                if (this.getTablero()[i][j].colorPieza('N')) {
                    hayNegro = true;
                }
            }
        }
        if (hayNegro && hayBlanco) {
            retorno = true;
        }
        return retorno;
    }

    public boolean esTurno(int cantidadJug, int fila, int columna) {
        boolean es = false;
        if (cantidadJug % 2 == 1) {
            if (this.getTablero()[fila][columna].colorPieza('N')) {
                es = true;
            }
        } else {
            if (this.getTablero()[fila][columna].colorPieza('B')) {
                es = true;
            }
        }
        return es;
    }

    public Casillero[] casillasPosibles(int fila, int columna, int cant) {
        Casillero devolucion[] = new Casillero[13];
        Casillero[][] tablero = this.getTablero();
        char otroColor;
        char color;
        if (cant % 2 == 0) {
            otroColor = 'N';
            color = 'B';
        } else {
            otroColor = 'B';
            color = 'N';
        }
        int contador = 0;
        Jugada jug = new Jugada();
        jug.setTablero(this);
        Casillero pos[] = jug.recorrerDiagonal(fila, columna, 1);
        Casillero pos2[] = jug.recorrerDiagonal(fila, columna, -1);
        //Valida si puede comer.
        if (pos[0].colorPieza(otroColor) || pos[1].colorPieza(otroColor) || pos2[0].colorPieza(otroColor) || pos2[1].colorPieza(otroColor)) {
            if (pos[0].colorPieza(otroColor)) {
                devolucion[contador] = pos[0];
                contador++;
            }
            if (pos[1].colorPieza(otroColor)) {
                devolucion[contador] = pos[1];
                contador++;
            }
            if (pos2[0].colorPieza(otroColor)) {
                devolucion[contador] = pos2[0];
                contador++;
            }
            if (pos2[1].colorPieza(otroColor)) {
                devolucion[contador] = pos2[1];
                contador++;
            }
        } else {


            for (int k = 0; k < 2; k++) {
                //Variable para cambiar el sentido de la búsqueda
                int signo = 2 * k - 1;
                for (int s = 0; s < 8; s++) {
                    //La variable s, es la que hace que se recorra las diagonales en la que esta la pieza negra hallada.
                    //Se valida que no se este fuera de rango.
                    if (s >= 0 && s <= 7 && (s * (-signo) + fila + columna * (signo)) >= 0 && (s * (-signo) + fila + columna * (signo)) <= 7) {
                        //Se fija en la diagonal que no esta recorriendo si hay fichas del rival.
                        Casillero cas[] = jug.recorrerDiagonal(s, fila + s * (-signo) + columna * signo, signo);
                        Casillero cas2[] = jug.recorrerDiagonal(s, fila + s * (-signo) + columna * signo, -signo);
                        //Valida que haya fichas del rival y que no haya fichas entre el casillero de salida y el de llegada.
                        if ((cas[0].colorPieza(otroColor) || cas[1].colorPieza(otroColor))) {
                            if (((cas2[0].getCoordenadaI() == fila) && (cas2[0].getCoordenadaJ() == columna)) || ((cas2[1].getCoordenadaI() == fila) && (cas2[1].getCoordenadaJ() == columna))) {
                                //Carga como casillero de salida en la casilla en la cual se hallo la ficha negra y de llegada la casilla desde la cual pudo amenazar.
                                Casillero aux = new Casillero();
                                aux.setCoordenadaJ(s * (-signo) + fila + columna * (signo));
                                aux.setCoordenadaI(s);
                                if (!tablero[aux.getCoordenadaI()][aux.getCoordenadaJ()].colorPieza(color)) {
                                    devolucion[contador] = aux;
                                    contador++;
                                }

                            }
                        }
                    }

                }
            }

            for (int k = 0; k < 2; k++) {
                //Variable para cambiar el sentido de la búsqueda
                int signo = 2 * k - 1;
                for (int s = 0; s < 8; s++) {
                    //La variable s, es la que hace que se recorra las diagonales en la que esta la pieza negra hallada.
                    //Se valida que no se este fuera de rango.
                    if (s >= 0 && s <= 7 && (s * (-signo) + columna + fila * (signo)) >= 0 && (s * (-signo) + columna + fila * (signo)) <= 7) {
                        //Se fija en la diagonal que no esta recorriendo si hay fichas del rival.
                        Casillero cas[] = jug.recorrerDiagonal(s, columna + s * (-signo) + fila * signo, signo);
                        Casillero cas2[] = jug.recorrerDiagonal(s, columna + s * (-signo) + fila * signo, -signo);
                        //Valida que haya fichas del rival y que no haya fichas entre el casillero de salida y el de llegada.
                        if ((cas[0].colorPieza(otroColor) || cas[1].colorPieza(otroColor))) {
                            if (((cas2[0].getCoordenadaI() == fila) && (cas2[0].getCoordenadaJ() == columna)) || ((cas2[1].getCoordenadaI() == fila) && (cas2[1].getCoordenadaJ() == columna))) {
                                //Carga como casillero de salida en la casilla en la cual se hallo la ficha negra y de llegada la casilla desde la cual pudo amenazar.
                                Casillero aux = new Casillero();
                                aux.setCoordenadaJ(columna + s * (-signo) + fila * signo);
                                aux.setCoordenadaI(s);
                                if (!tablero[aux.getCoordenadaI()][aux.getCoordenadaJ()].colorPieza(color)) {
                                    devolucion[contador] = aux;
                                    contador++;
                                }
                            }
                        }
                    }

                }
            }


        }
        return devolucion;
    }
}
