/*
 * Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Consola;

import java.util.*;
import Obligatorio.*;

public class Interfaz {

    public static void main(String[] args) {

        Sistema sis = new Sistema();

        //Creo el jugador Computadora
        Jugador computadora = new Jugador();
        computadora.setAlias("Compu");
        computadora.setNombre("Computadora");
        sis.agregarJugador(computadora);

        Scanner in = new Scanner(System.in);
        int opcion = -1;

        System.out.println("           ---------------------------------------------\n"
                + "           |          BIENVENIDO A SÓLO ALFILES        |\n"
                + "           ---------------------------------------------\n");

        //Se despliega el menú principal.
        while (opcion != 6) {
            System.out.println("\n --------------------------------------------------"
                    + "\n|                 MENÚ PRINCIPAL                   |"
                    + "\n| 1-Ingresar Jugador                               |"
                    + "\n| 2-Jugar a Sólo Alfiles                           |"
                    + "\n| 3-Carga Manual para Pruebas                      |"
                    + "\n| 4-Repetición de partida                          |"
                    + "\n| 5-Consulta Jugadores                             |"
                    + "\n| 6-Salir                                          |"
                    + "\n---------------------------------------------------");
            opcion = pedirNum(1, 6, "la opción deseada");

            switch (opcion) {
                case 1:
                    //Ingreso Jugador
                    Jugador jug = new Jugador();
                    boolean yaExiste = true;
                    String nombre = " ";
                    while (yaExiste) {
                        boolean hayOtro = false;
                        //Pido el ingreso del nombre
                        System.out.println("Ingrese el Nombre del Jugador. Recuerde que este no se podrá nombrar Computadora");
                        nombre = in.nextLine();
                        jug.setNombre(nombre);
                        //Busco si hay algún jugador con ese nombre.
                        for (int i = 0; i < sis.getListaDeJugadores().size(); i++) {
                            if (sis.getListaDeJugadores().get(i).equals(jug)) {
                                hayOtro = true;
                                System.out.println("YA EXISTE UN JUGADOR CON ESE NOMBRE");
                            }
                        }
                        yaExiste = hayOtro;
                    }
                    //Pido el alias del jugador.
                    System.out.println("Ingrese el Alias del Jugador");
                    String alias = in.nextLine();

                    jug.setNombre(nombre);
                    jug.setAlias(alias);

                    sis.agregarJugador(jug);
                    break;

                case 2:
                    //Opción para Jugar a Sólo Alfiles.
                    int opcion2 = -1;
                    Tablero tablero = new Tablero(8);
                    while (opcion2 != 3) {
                        //Validación de que la lista no tenga únicamente al jugador Computadora.
                        if (sis.getListaDeJugadores().size() == 1) {
                            System.out.println("La lista de jugadores esta vacía recuerda que para jugar al menos necesita un jugador contra la computadora");
                            opcion2 = 3;
                        } else {
                            //Despliego el sub-menú y juego.
                            opcion2 = subMenu(tablero, sis, false);
                        }
                    }
                    break;


                case 3:
                    //Colocar piezas a mano
                    Tablero tablero2 = new Tablero(8);
                    int opcion3 = -1;
                    //Validación de que la lista no tenga únicamente al jugador Computadora.
                    if (sis.getListaDeJugadores().size() == 1) {
                        System.out.println("La lista de jugadores esta vacía recuerda que para jugar al menos necesita un jugador para jugar contra la computadora");
                        opcion3 = 3;
                    } else {
                        //Se llena el tablero a mano.
                        System.out.println(tablero2);
                        colocarAMano(tablero2);
                    }
                    while (opcion3 != 3) {
                        //Se juega con el tablero recién llenado.
                        opcion3 = subMenu(tablero2, sis, true);
                    }
                    break;


                case 4:
                    //Seleccionar Partidas
                    //Valida que la lista de partidas no este vacía.
                    if (!(sis.getListaDePartidas().isEmpty())) {
                        for (int i = 0; i < sis.getListaDePartidas().size(); i++) {
                            System.out.println((i + 1) + ")\n" + sis.getListaDePartidas().get(i));
                        }
                        int num2 = pedirNum(1, sis.getListaDePartidas().size(), "ELIJA UNA PARTIDA\n");
                        Partida part = sis.getListaDePartidas().get(num2 - 1);

                        //Muestra la partida avanzando con cada vez que se presione ENTER.
                        for (int i = 0; i < part.getListaDeJugadas().size(); i++) {
                            if (part.getListaDeJugadas().get(i).getJugada() == null) {
                                System.out.println(part.getListaDeJugadas().get(i).getTablero());
                                System.out.println("Jugada: FIN");
                            } else {
                                System.out.println(part.getListaDeJugadas().get(i));
                            }
                            System.out.println("PRESIONE ENTER PARA CONTINUAR");
                            in.nextLine();
                        }
                    } else {
                        System.out.println("LA LISTA DE PARTIDAS ESTA VACIA");
                    }
                    break;

                case 5:
                    if (sis.getListaDeJugadores().size() == 1) {
                        System.out.println("Debes Ingresar al menos un Jugador");
                    } else {
                        //Se clona la lista de jugadores.
                        ArrayList<Jugador> cloJ = (ArrayList<Jugador>) sis.getListaDeJugadores().clone();
                        Collections.sort(cloJ);
                        //Se ordena la lista clonada.
                        System.out.println("LISTA DE JUGADORES");
                        for (int i = 0; i < cloJ.size(); i++) {
                            System.out.println((i + 1) + ") \n" + cloJ.get(i));
                        }
                    }
                    break;
            }
        }
    }

    //Metodo para valorizar
    public static int pedirNum(int min, int max, String texto) {
        Scanner on = new Scanner(System.in);
        int numero = -1;
        boolean ok = false;
        boolean primeraVez = true;
        while (!ok) {

            while (numero > max || numero < min) {
                if (primeraVez) {
                    System.out.println("Ingrese " + texto);
                } else {

                    System.out.println("Ingrese " + texto + " de vuelta");
                    if (min == max) {
                        System.out.println("El único número que puede ingresar es " + min);
                    } else {

                        System.out.println("Recuerde que debe ser un número entre " + min + " y " + max + " inclusive");
                    }
                }
                try {
                    numero = on.nextInt();
                } catch (InputMismatchException e) {
                    on.nextLine();
                }
                primeraVez = false;
            }
            ok = true;
            on.nextLine();
        }
        return numero;
    }

    public static int subMenu(Tablero tablero, Sistema sis, boolean rellenoAMano) {
        int cant;
        int opcion2;
        Jugador jug1 = new Jugador();
        Jugador jug2 = new Jugador();


        System.out.println("\n --------------------------------------------------"
                + "\n|                      SUB-MENÚ                    |"
                + "\n| 1- 1 Jugador                                     |"
                + "\n| 2- 2 Jugadores                                   |"
                + "\n| 3-Salir                                          |"
                + "\n---------------------------------------------------");
        opcion2 = pedirNum(1, 3, "la opción deseada");
        switch (opcion2) {
            case 1:
                System.out.println("ELIJA AL JUGADOR");
                for (int i = 1; i < sis.getListaDeJugadores().size(); i++) {
                    System.out.println((i) + ")\n" + sis.getListaDeJugadores().get(i));
                }
                int num1 = pedirNum(1, sis.getListaDeJugadores().size() - 1, "el número del jugador que jugará con las piezas Blancas");
                jug1 = sis.getListaDeJugadores().get(num1);
                jug2 = sis.getListaDeJugadores().get(0);

                System.out.println("JUGADOR DE BLANCAS\n" + jug1);
                System.out.println("JUGADOR DE NEGRAS\n" + jug2);
                if (!rellenoAMano) {
                    cant = pedirNum(2, 12, "la cantidad de piezas con la que desea jugar");
                    tablero.rellenar('B', cant);
                    tablero.rellenar('N', cant);
                }
                jugar(sis, jug1, jug2, tablero);
                opcion2 = 3;
                break;

            case 2:
                if (sis.getListaDeJugadores().size() < 3) {
                    System.out.println("La lista de jugadores debe tener 2 jugadores");
                    opcion2 = 3;
                } else {
                    System.out.println("ELIJA LOS JUGADORES");
                    for (int i = 1; i < sis.getListaDeJugadores().size(); i++) {
                        System.out.println((i) + "\n " + sis.getListaDeJugadores().get(i));
                    }
                    int num2 = pedirNum(1, sis.getListaDeJugadores().size() - 1, "el número del jugador que jugará con las piezas Blancas");
                    jug1 = sis.getListaDeJugadores().get(num2);
                    for (int i = 1; i < sis.getListaDeJugadores().size(); i++) {
                        if (i < num2) {
                            System.out.println((i) + "\n " + sis.getListaDeJugadores().get(i));
                        }
                        if (i > num2) {
                            System.out.println((i - 1) + " \n" + sis.getListaDeJugadores().get(i));
                        }

                    }
                    int num3 = pedirNum(1, sis.getListaDeJugadores().size() - 2, "el número del jugador que jugará con las piezas Negra");
                    if (num3 >= num2) {
                        jug2 = sis.getListaDeJugadores().get(num3 + 1);
                    } else {
                        jug2 = sis.getListaDeJugadores().get(num3);
                    }

                    System.out.println("JUGADOR DE BLANCAS\n" + jug1);
                    System.out.println("JUGADOR DE NEGRAS\n" + jug2);
                    if (!rellenoAMano) {
                        cant = pedirNum(2, 12, "la cantidad de piezas con la que desea jugar");
                        tablero.rellenar('B', cant);
                        tablero.rellenar('N', cant);
                    }
                    jugar(sis, jug1, jug2, tablero);
                    opcion2 = 3;
                }
                break;
        }
        return opcion2;
    }

    public static void jugar(Sistema sis, Jugador jugadorBlanco, Jugador jugadorNegro, Tablero tablero) {
        int pos[] = new int[4];
        int res[] = new int[4];
        char turno = 'B';
        char noTurno = 'N';
        boolean leTocaAlBlanco = true;
        boolean hayFichas = true;
        boolean computadoraNegra = false;
        Jugador jugadorTurno = new Jugador();


        Jugada jug = new Jugada();
        Partida partida = new Partida();
        Jugada jugada1 = new Jugada();
        Jugada jugadaBN = new Jugada();

        //Creo el jugador Computadora
        Jugador computadora = new Jugador();
        computadora.setNombre("Computadora");
        //Me fijo si juega la computadora.
        if (jugadorNegro.equals(computadora)) {
            computadoraNegra = true;
        }

        //Muestro Tablero
        System.out.println(tablero);

        //Pido Jugada
        Scanner in = new Scanner(System.in);
        System.out.println("Es el turno de:" + jugadorBlanco.getNombre());
        System.out.println("Ingrese la jugada: \n");
        String jugada;
        jugada = in.nextLine().toUpperCase();

        //Seteo la Jugada y la guardo en la lista de jugadas
        Tablero tablero1 = (Tablero) tablero.clone();
        jugadaBN.setTablero(tablero1);

        //Seteo el tablero y la jugada a una jugada
        jug.setJugada(jugada);
        jug.setTablero(tablero);


        while (!jugada.equals("FIN") && hayFichas) {
            if (!(computadoraNegra && !leTocaAlBlanco)) {
                if (jug.entradaVali().equals("BIEN")) {
                    //Una vez validada la entrada se traduce.
                    pos = jug.traductorJugada();
                    //Se verifica la lógica.
                    if (jug.logicaValida(pos, turno, noTurno).equals("BIEN")) {
                        tablero.cambioTablero(pos, turno);

                        //Seteo el tablero y la jugada a la jugada
                        jug.setTablero(tablero);
                        jug.setJugada(jugada);

                        //Muestro el Tablero
                        System.out.println(tablero);

                        //Seteo la jugada y CLONO jugada
                        jugadaBN.setJugada(jugada);
                        jugada1 = (Jugada) jugadaBN.clone();

                        //GUARDO la jugada en la partida
                        partida.agregarJugada(jugada1);

                        //Clono el nuevo tablero
                        tablero1 = (Tablero) tablero.clone();
                        jugadaBN.setTablero(tablero1);

                        //Cambio el turno.
                        leTocaAlBlanco = (leTocaAlBlanco == false);
                        if (leTocaAlBlanco) {
                            turno = 'B';
                            noTurno = 'N';
                        } else {
                            turno = 'N';
                            noTurno = 'B';
                        }
                    } else {
                        System.out.println(jug.logicaValida(pos, turno, noTurno));
                    }
                } else {
                    System.out.println(jug.entradaVali());
                }
            } else {
                //Juega la computadora.
                res = Partida.juegaComputador(tablero, turno, noTurno);

                String jugadaCompu = Jugada.traductorPosicion(res);
                //Seteo y Clono la jugada y la guardo
                jugadaBN.setJugada(jugadaCompu);
                jugada1 = (Jugada) jugadaBN.clone();

                //GUARDO la jugada en la partida
                partida.agregarJugada(jugada1);

                //Cambio de Tablero
                tablero.cambioTablero(res, turno);
                System.out.println(tablero);
                //Cambio de Turno.
                leTocaAlBlanco = (leTocaAlBlanco == false);

                //Seteo el tablero y la jugada a la jugada
                jug.setTablero(tablero);
                jug.setJugada(jugadaCompu);


                //CLONO tablero
                tablero1 = (Tablero) tablero.clone();
                jugadaBN.setTablero(tablero1);

                //Cambio de piezas ya que cambio el turno.
                if (leTocaAlBlanco) {
                    turno = 'B';
                    noTurno = 'N';
                } else {
                    turno = 'N';
                    noTurno = 'B';
                }
                //Muestro la jugada de la computadora.
                System.out.println("La jugada de la computadora fue: " + Jugada.traductorPosicion(res));
            }
            hayFichas = tablero.hayFichas(turno);
            if (hayFichas && (!(computadoraNegra && !leTocaAlBlanco))) {
                if (leTocaAlBlanco) {
                    jugadorTurno = jugadorBlanco;
                } else {
                    jugadorTurno = jugadorNegro;
                }
                System.out.println("Es el turno de:" + jugadorTurno.getNombre());
                System.out.println("\nIngrese la jugada: ");
                //Pido de nuevo una jugada
                jugada = in.nextLine().toUpperCase();
                //Seteo la Jugada a la Jugada
                jug.setJugada(jugada);
            }
        }
        //Seteo y Clono la jugada y la guardo
        jugada1 = (Jugada) jugadaBN.clone();

        //GUARDO la jugada en la partida
        partida.agregarJugada(jugada1);

        //Guardo a los Jugadores a la Partida

        jugadorBlanco.setJuegosJugados(jugadorBlanco.getJuegosJugados() + 1);
        jugadorNegro.setJuegosJugados(jugadorNegro.getJuegosJugados() + 1);

        //Guardo quien ganó la partida
        if (leTocaAlBlanco == false) {
            jugadorBlanco.setPartidosGanados(jugadorBlanco.getPartidosGanados() + 1);
            System.out.println("JUGADOR GANADOR: \n \n" + jugadorBlanco);
        } else {
            jugadorNegro.setPartidosGanados(jugadorNegro.getPartidosGanados() + 1);
            System.out.println("JUGADOR GANADOR: \n \n" + jugadorNegro);
        }
        partida.setJugador1(jugadorBlanco);
        partida.setJugador2(jugadorNegro);
        sis.getListaDePartidas().add(partida);



    }

    public static Tablero colocarAMano(Tablero tab) {
        boolean seColocoN = false;
        boolean seColocoB = false;
        //Se explica que al menos se debe cargar una ficha de cada color y se pide el ingreso.
        System.out.println("Ingrese las fichas que desea, para finalizar escriba la palabra FIN. \nRecuerde que al comenzar debe ingresar una pieza de cada color.\n");
        Scanner in = new Scanner(System.in);
        String fichas = in.nextLine().toUpperCase();
        int cantTotal = 0;
        Jugada jug = new Jugada();
        jug.setJugada(fichas);
        //Se sigue pidiendo el ingreso y validandolo mientras que no se escriba "FIN" ya habiendo colocado una pieza de cada color.
        while (!(fichas.equals("FIN") && seColocoB && seColocoN)) {
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
                                cantTotal++;
                            }
                            if (pieza == 'B') {
                                seColocoB = true;
                                cantTotal++;
                            }
                            //Obliga que se ingrese una ficha de cada color al comenzar.
                            if ((cantTotal > 1) && ((seColocoB && !seColocoN && pieza == 'B') || (seColocoN && !seColocoB && pieza == 'N'))) {
                                System.out.println("Debe ingresar una pieza de cada color al comenzar");
                            } else {
                                //Despues de todas las validaciones se coloca la ficha y se muestra el tablero.
                                tab.colocarFicha(fichas);
                                System.out.println(tab);
                            }
                        } else {
                            System.out.println("Esa casilla ya esta ocupada");
                        }

                    } else {
                        //Se muestran los errores.
                        System.out.println("NO ESTOY EN CASILLA BLANCA");
                    }
                } else {
                    //Se muestran los errores.
                    System.out.println(jug.colocoVali());
                }
                //Se pide un nuevo ingreso.
                System.out.println("Ingrese las fichas que desea, para finalizar escriba la palabra FIN. \nRecuerde que al menos debe ingresar una pieza de cada color.");
                fichas = in.nextLine().toUpperCase();
                jug.setJugada(fichas);

            } else {
                //Si se escribe "FIN" sin haber colocado una ficha de cada color pide el ingreso nuevamente.
                if (!seColocoB || !seColocoN) {
                    System.out.println("Debe ingresar al menos una ficha de cada color.");
                    fichas = in.nextLine().toUpperCase();
                    jug.setJugada(fichas);

                }
            }
        }
        return tab;
    }
}
