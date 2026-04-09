/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Obligatorio;

public class Jugada implements Cloneable {
    //Variables
    private Tablero tablero;
    private String jugada;

    //Set y Get de TABLERO
    public void setTablero(Tablero unT) {
        tablero = unT;
    }

    public Tablero getTablero() {
        return tablero;
    }

    //Set y Get de JUGADA
    public void setJugada(String unaJugada) {
        jugada = unaJugada;
    }

    public String getJugada() {
        return jugada;
    }

    //constructor
    public Jugada() {
        this.setTablero(tablero);
        this.setJugada(jugada);

    }

    //toString
    @Override
    public String toString() {
        return "---------------------------------------------"
                + "\n" + this.getTablero()
                + "\n Jugada:" + this.getJugada()
                + "\n---------------------------------------------";
    }

    //Método para CLONAR
    @Override
    public Object clone() {
        Object ob = null;
        try {
            ob = (Jugada) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("NO CLONE");
        }
        return ob;
    }

    /*Metodo LOGICAVALIDA:
    Es el metodo que recorre la diagonal entre el casillero de salida y el de llegada, para validar que este vacío.
    Además valida si al mover el alfil se podía comer con ese.
    También valida si se amenaza en el caso de no poder comer. Devolviendo entonces si es válido el movimiento*/
    public String logicaValida(int[] pos, char turno, char noTurno) {
        boolean sePuede = true;
        int tipoDeDiagonal = 1;
        String tipoFalla = "BIEN";

        //Valida que en el casillero de salida haya una pieza del turno correspondiente.
        if (!this.getTablero().getTablero()[pos[0]][pos[1]].colorPieza(turno)) {
            sePuede = false;
            tipoFalla = "NO ESTA LA PIEZA INDICADA";
        } else {

            //Se fija en que tipo de diagonal se encuentra la jugada indicada.
            if ((pos[2] + pos[3]) == (pos[0] + pos[1])) {
                tipoDeDiagonal = -1;
            } else {
                if (!(Math.abs(pos[2] - pos[0]) == Math.abs(pos[3] - pos[1]))) {
                    tipoFalla = "NO ESTA EN LA DIAGONAL";
                    sePuede = false;
                }
            }
            //Dependiendo del tipo de diagonal, recorre para ver si está vacia entre los dos casilleros
            if (sePuede) {                
                //Tipo de diagonal: /
                if (tipoDeDiagonal == -1) {
                    for (int i = 1; i < (Math.abs(pos[2] - pos[0])); i++) {
                        if (!(this.getTablero().getTablero()[Math.max(pos[0], pos[2]) - i][Math.min(pos[1], pos[3]) + i].colorPieza(' '))) {
                            sePuede = false;
                            tipoFalla = "EL CAMINO NO ESTA VACÍO";
                        }
                    }
                    //Tipo de diagonal: \
                } else {
                    for (int i = 1; i < Math.abs(pos[2] - pos[0]); i++) {
                        if (!(this.getTablero().getTablero()[Math.max(pos[0], pos[2]) - i][Math.max(pos[1], pos[3]) - i].colorPieza(' '))) {
                            sePuede = false;
                            tipoFalla = "EL CAMINO NO ESTA VACÍO";
                        }
                    }
                }
            }
            /*Si la diagonal entre los dos casilleros está vacio.
            Valida: que en el casillero de llegada esté la pieza del turno contrario
                    que el casillero de llegada esté vacio, realizando entonces las validaciones correspondientes*/
            if (sePuede) {

                //Valida que en la posición de llegada haya una pieza del turno contrario
                if (this.getTablero().getTablero()[pos[2]][pos[3]].colorPieza(turno)) {
                    tipoFalla = "LA CASILLA YA ESTA OCUPADA";
                }

                // Si en la posición de llegada hay un espacio, primero se fija si no podia comer con esa ficha y luego se fija si donde llega amenaza.
               if (this.getTablero().getTablero()[pos[2]][pos[3]].colorPieza(' ')) {

                    //El método  recorrerDiagonal muestra que fichas hay en los extremos de las diagonales
                    //Recorre la diagonal para ver si ese alfil puede comer
                    Casillero[] comp = new Casillero[2];
                    comp[0] = new Casillero();
                    comp[1] = new Casillero();

                    comp = recorrerDiagonal(pos[0], pos[1], tipoDeDiagonal);
                    Casillero[] compB = new Casillero[2];
                    compB = recorrerDiagonal(pos[0], pos[1], tipoDeDiagonal * (-1));

                    // Se fija en las diagonales si hay alguna ficha del otro color, para ver si puede comer.
                    if (comp[0].colorPieza(noTurno) || comp[1].colorPieza(noTurno) || compB[0].colorPieza(noTurno) || compB[1].colorPieza(noTurno)) {
                        tipoFalla = "DEBE COMER SI MUEVE ESE ALFIL";

                        sePuede = false;
                    } else {
                        //Valida que la pieza en la posición de llegada pueda comer
                        Casillero[] comp2 = new Casillero[2];
                        comp2 = recorrerDiagonal(pos[2], pos[3], tipoDeDiagonal * (-1));
                        if (!comp2[0].colorPieza(noTurno) && !comp2[1].colorPieza(noTurno)) {
                            tipoFalla = "NO ESTA AMENAZANDO";
                            sePuede = false;
                        }
                    }
                }
            }
        }
        return tipoFalla;
    }


    /*Metodo RECORRERDIAGONAL
    Devuelve los primeros casilleros que se encuentran en la diagonal que no sean vacíos
    Tipo de Diagonal \ resta constante int=1 Tipo de Diagonal / suma constante int=-1 */
    public Casillero[] recorrerDiagonal(int posX, int posY, int tipoDeDiagonal) {

        //Armo matriz auxiliar con marco de valores *       
        Tablero tableroG = new Tablero(10);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tableroG.getTablero()[i + 1][j + 1] = this.getTablero().getTablero()[i][j];
            }
        }
        for (int i = 0; i < 10; i++) {
            tableroG.getTablero()[0][i].setPieza('*');
            tableroG.getTablero()[10 - 1][i].setPieza('*');
            tableroG.getTablero()[i][0].setPieza('*');
            tableroG.getTablero()[i][10 - 1].setPieza('*');
        }

        //Recorre la diagonal de la matriz auxiliar, hasta que no encuentre un espacio en blanco
        Casillero[] res = new Casillero[2];
        for (int j = 0; j < 2; j++) {
            //Variable que cambia el sentido de la búsqueda sobre la misma diagonal.
            int cambioDeSentido = 1 - 2 * j;
            int i = 1;
            while (tableroG.getTablero()[posX + cambioDeSentido * i + 1][posY + cambioDeSentido * tipoDeDiagonal * i + 1].colorPieza(' ') && (posX + cambioDeSentido * i) < 7 && (posX + cambioDeSentido * i) > 0 && 7 > (posY + cambioDeSentido * tipoDeDiagonal * i) && (posY + cambioDeSentido * tipoDeDiagonal * i) > 0) {
                i++;
            }
            res[j] = tableroG.getTablero()[posX + cambioDeSentido * i + 1][posY + cambioDeSentido * tipoDeDiagonal * i + 1];
        }
        return res;
    }

    /*El dato entrante, se debe validar.
    Se separa por el espacio cual es el alfil a mover y a donde.
    Se valida que el largo del codigo puesto a mover  y a donde, sea solo 2 caracteres.
    Valindan que ambos sean una letra y un mumero.
    Luego se valida que estos esten dentro del tablero.*/
    public String entradaVali() {
        boolean correcta = false;
        boolean largo = false;
        boolean pos = false;
        String tipoFalla = "BIEN";
        String[] piezas = this.getJugada().split(" ");

        //Validación que el código sea solo 2 caracteres
        if (piezas.length == 2) {
            if ((piezas[0].length() == 2 && piezas[1].length() == 2)) {
                largo = true;
                pos = this.existenPos().equals("BIEN");
            }
        }
        //Validación que las posiciones existan en el tablero
        //Si ambas cosas (el código es de 2 caracteres y que estos existen en el tablero, entonces el código entrante es válido.
        if (largo == true && pos == true) {
            correcta = true;
        }
        if (!correcta) {
            tipoFalla = "EL INGRESO NO ES VÁLIDO";
        }
        return tipoFalla;
    }

    //Valida que existan las posiciones
    public String existenPos() {
        String piezas[] = this.getJugada().split(" ");
        boolean bien = false;
        String tipoFalla = "BIEN";

        //Separa la letra y el número de la jugada

        char salidaLetra = piezas[0].charAt(0);
        int salidaNum = piezas[0].charAt(1);
        char llegadaLetra = piezas[1].charAt(0);
        int llegadaNum = piezas[1].charAt(1);

        boolean salida = validarPos(salidaLetra, salidaNum);
        boolean llegada = validarPos(llegadaLetra, llegadaNum);

        if (salida == true && llegada == true) {
            bien = true;
        }
        if (!bien) {
            tipoFalla = "NO EXISTE LA POSICIÓN";
        }

        return tipoFalla;

    }

    //Metodo VALIDARPOS:
    //Valida que las posiciones ingresadas esten dentro del tablero
    public boolean validarPos(char letra, int nro) {
        boolean pos = false;

        if (((int) letra >= 65 && (int) letra <= 72) && (nro >= 49 && nro <= 56)) {
            pos = true;
        }
        return pos;
    }

    /* Método que se le pasa un String Validado (ya se verifico que es correcto),
     y devuelve las posiciones x, y , x1, y1
    (las coordenadas i, j de la matriz para la casilla de salida y para la de llegada)
    en ese orden para usar el método de caminoVacio o para la Carga Manual. */
    public int[] traductorJugada() {
        int longitud = this.getJugada().length();
        int[] res = new int[longitud];
        String[] piezas = this.getJugada().split(" ");

        if (longitud == 5) {
            //Posición de la ficha a mover
            res[0] = 7 - ((int) piezas[0].charAt(1) - 49);//Este es x
            res[1] = (int) piezas[0].charAt(0) - 65;//Este es y

            //Posición a la cual se quiere llegar
            res[2] = 7 - ((int) piezas[1].charAt(1) - 49);//Este es x1
            res[3] = (int) piezas[1].charAt(0) - 65;//Este es y1
        }

        if (longitud == 4) {
            //Posición de la ficha a mover
            res[0] = 7 - ((int) piezas[0].charAt(1) - 49);//Este es x
            res[1] = (int) piezas[0].charAt(0) - 65;//Este es y
        }
        return res;
    }

    //Método COLOCOVALI:
    //Valida que la entrada de las piezas colocadas a mano, sea correcta
    public String colocoVali() {
        String tipoFalla = "BIEN";
        boolean entradaCorrecta = false;
        boolean existenPos = false;
        String[] piezas = this.getJugada().split(" ");
        //Se fija que la estructura del String sea correcta
        if (piezas.length == 2 && piezas[0].length() == 2 && piezas[1].length() == 1) {
            entradaCorrecta = true;

        } else {
            //Escribe el error
            tipoFalla = "Entrada incorrecta";
        }
        //Valida que la posición sea correcta y que el color de la pieza también lo sea.
        if (entradaCorrecta) {
            if (validarPos(piezas[0].charAt(0), (int) piezas[0].charAt(1)) && (piezas[1].charAt(0) == 'B' || piezas[1].charAt(0) == 'N')) {
                existenPos = true;

            } else {
                //Escribe el error
                tipoFalla = "No existe la posición o no ingreso una pieza Balnca o Negra";
            }
        }
        return tipoFalla;
    }
     /*Método TRADUCTORPOSICION traduce las posiciones a letra-numero*/
    public static String traductorPosicion(int[] pos) {
        String jugada;
        jugada = ((char) (pos[1] + 65) + "" + (8 - pos[0]) + " " + (char) (pos[3] + 65) + "" + (8 - pos[2]));
        return jugada;
    }
}
