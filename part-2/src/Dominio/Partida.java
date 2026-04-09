/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Dominio;

import java.io.Serializable;
import java.util.*;

public class Partida extends Observable implements Cloneable, Serializable {
    //Variables

    private Jugador jugadorB;
    private Jugador jugadorN;
    private ArrayList<Jugada> listaDeJugadas;

    //Set y Get de Jugador Blanco
    public Jugador getJugadorB() {
        return jugadorB;
    }

    public void setJugadorB(Jugador unJugadorB) {
        jugadorB = unJugadorB;
        setChanged();
        notifyObservers();
    }

    //Set y Get de Jugador2
    public Jugador getJugadorN() {
        return jugadorN;
    }

    public void setJugadorN(Jugador unJugadorN) {
        jugadorN = unJugadorN;
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }

    public Jugada ingresoJugada(int cant) {
        Tablero tablero = new Tablero(8);
        tablero.rellenar('B', cant);
        tablero.rellenar('N', cant);
        Jugada jug = new Jugada();
        jug.setTablero(tablero);
        return jug;
    }

    //Constructor
    public Partida() {
        this.setJugadorB(null);
        this.setJugadorN(null);
        this.listaDeJugadas = new ArrayList<Jugada>();
    }

    //toString de Partida
    @Override
    public String toString() {
        return this.getJugadorB().getNombre() + " VS. " + this.getJugadorN().getNombre();
    }

    //Método para Clonar.
    @Override
    public Object clone() {
        Object ob = null;
        try {
            ob = (Partida) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("NO CLONE");
        }
        return ob;
    }

    public void grabarPartida(String nombreSalida) {
        ArchivoGrabacion sal = new ArchivoGrabacion(nombreSalida+".txt");
        sal.grabarLinea("Jugador Blanco: " + this.getJugadorB() + " Jugador Negro: " + this.getJugadorN());
        sal.grabarLinea("Tablero");
        Tablero tablero = this.getListaDeJugadas().get(this.getListaDeJugadas().size() - 1).getTablero();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!tablero.getTablero()[i][j].colorPieza(' ')) {
                    sal.grabarLinea((char) (j + 65) + "" + (8 - i) + " " + tablero.getTablero()[i][j].getPieza());
                }
            }
        }
        sal.cerrar();
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
                                        //Carga como casillero de salida en la casilla en la cual se hallo la ficha negra y de llegada la casilla desde la cual pudo amenazar.
                                        res[0] = i;
                                        res[1] = j;
                                        res[3] = s * (-signo) + i + j * (signo);
                                        res[2] = s;
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

    public String[] jugar(int cant, Sistema sis, Tablero tablero, String jugada) {
        int pos[] = new int[4];
        int res[] = new int[4];
        boolean leTocaAlBlanco = true;
        boolean hayFichas = true;
        boolean computadoraNegra = false;
        String jugadaCompu = " ";
        String mensaje[] = new String[5];
        mensaje[0] = "";
        mensaje[1] = "";
        mensaje[2] = "";
        mensaje[3] = "";
        mensaje[4] = "";
        Jugador jugadorTurno = new Jugador();
        Jugada jug = new Jugada();
        Jugada jugada1 = new Jugada();
        Jugada jugadaBN = new Jugada();
        Tablero tablero1 = new Tablero(8);

        char turno = 'B';
        char noTurno = 'N';

        //Se decide el turno según la cantidad de veces que se hizo una jugada válida en la interfaz.
        if (Math.pow(-1, cant) == -1) {
            leTocaAlBlanco = false;
        }

        //Se indica que ficha es la del turno.
        if (leTocaAlBlanco) {
            turno = 'B';
            noTurno = 'N';
        } else {
            turno = 'N';
            noTurno = 'B';
        }

        //Me fijo si juega la computadora.
        if (this.getJugadorN().getNombre().equalsIgnoreCase("computadora")) {
            computadoraNegra = true;
        }

        if (cant == 0) {
            //CLONO tablero
            tablero1 = (Tablero) tablero.clone();
            jugadaBN.setTablero(tablero1);

            //Seteo y Clono la jugada y la guardo
            jugadaBN.setJugada("Primer Tablero");
            jugada1 = (Jugada) jugadaBN.clone();

            //GUARDO la jugada en la partida
            this.agregarJugada(jugada1);
        }

        //Seteo el tablero y la jugada a una jugada
        jug.setJugada(jugada);
        jug.setTablero(tablero);

        hayFichas = tablero.hayFichas(turno);

        if (!jugada.equalsIgnoreCase("FIN") && hayFichas) {
            if (!(computadoraNegra && !leTocaAlBlanco)) {
                if (jug.entradaVali().equals("BIEN")) {
                    //Una vez validada la entrada se traduce.
                    pos = jug.traductorJugada();
                    //Se verifica la lógica.
                    if (jug.logicaValida(pos, turno, noTurno).equals("BIEN")) {

                        //Seteo la jugada y CLONO jugada
                        jug.setJugada(jugada);

                        //Cambio de  Tablero
                        tablero.cambioTablero(pos, turno);
                        hayFichas = tablero.hayFichas(noTurno);

                        //Seteo el tablero y la jugada a la jugada
                        jug.setTablero(tablero);

                        //Cargo el mensaje
                        mensaje[1] = "BIEN";

                        //Cambio el turno.
                        leTocaAlBlanco = (leTocaAlBlanco == false);

                        //Seteo y Clono la jugada y la guardo
                        jugadaBN.setJugada(jugada);

                        //CLONO tablero
                        tablero1 = (Tablero) tablero.clone();
                        jugadaBN.setTablero(tablero1);

                        jugada1 = (Jugada) jugadaBN.clone();

                        //GUARDO la jugada en la partida
                        this.agregarJugada(jugada1);

                    } else {
                        //Se carga el error.
                        mensaje[2] += (jug.logicaValida(pos, turno, noTurno));
                    }
                } else {
                    //Se carga el error.
                    mensaje[2] += (jug.entradaVali());
                }
            } else {
                //Juega la computadora.
                res = Partida.juegaComputador(tablero, turno, noTurno);

                jugadaCompu = Jugada.traductorPosicion(res);

                //Cambio de Tablero
                tablero.cambioTablero(res, turno);

                //Cambio de Turno.
                leTocaAlBlanco = (leTocaAlBlanco == false);

                //Seteo el tablero y la jugada a la jugada
                jug.setTablero(tablero);
                jug.setJugada(jugadaCompu);

                //Seteo y Clono la jugada y la guardo
                jugadaBN.setJugada(jugadaCompu);

                //CLONO tablero
                tablero1 = (Tablero) tablero.clone();
                jugadaBN.setTablero(tablero1);

                jugada1 = (Jugada) jugadaBN.clone();

                //GUARDO la jugada en la partida
                this.agregarJugada(jugada1);

                //Cargo el mensaje
                mensaje[1] = "BIEN";

                //Cambio de piezas ya que cambio el turno.
                if (leTocaAlBlanco) {
                    turno = 'B';
                    noTurno = 'N';
                    mensaje[4] += turno;
                } else {
                    turno = 'N';
                    noTurno = 'B';
                    mensaje[4] += turno;
                }
                //Muestro la jugada de la computadora.
                mensaje[0] += ("\nLa jugada de la computadora fue: " + Jugada.traductorPosicion(res));
                hayFichas = tablero.hayFichas(turno);
            }

            if (hayFichas && (!(computadoraNegra && !leTocaAlBlanco))) {
                if (leTocaAlBlanco) {
                    jugadorTurno = this.getJugadorB();
                } else {
                    jugadorTurno = this.getJugadorN();
                }
                //Cargo los mensajes a mostrar en la interfaz.
                mensaje[3] += ("\nEs el turno de:" + jugadorTurno.getNombre());

                //Seteo la Jugada a la Jugada
                jug.setJugada(jugada);
            }
        }
        if (!hayFichas || jugada.equalsIgnoreCase("FIN")) {
            //Guardo quien ganó la partida
            if (leTocaAlBlanco == false) {
                this.getJugadorB().setPartidosGanados(this.getJugadorB().getPartidosGanados() + 1);
                mensaje[0] = ("JUGADOR GANADOR: \n \n" + this.getJugadorB());
                setChanged();
                notifyObservers();
            } else {
                this.getJugadorN().setPartidosGanados(this.getJugadorN().getPartidosGanados() + 1);
                mensaje[0] = ("JUGADOR GANADOR: \n \n" + this.getJugadorN());
                setChanged();
                notifyObservers();
            }
            this.getJugadorB().setJuegosJugados(this.getJugadorB().getJuegosJugados() + 1);
            this.getJugadorN().setJuegosJugados(this.getJugadorN().getJuegosJugados() + 1);
            setChanged();
            notifyObservers();

            //Cargo que la partida puede terminar.
            mensaje[1] = "FIN";
        }
        return mensaje;
    }
}
