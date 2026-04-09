/*
 *Autores: Maria Gimena Czarnievicz e Ismael Rodriguez
 */
package Obligatorio;

public final class Jugador implements Comparable<Jugador>, Cloneable {
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
    }

    //Get y Set de ALIAS
    public String getAlias() {
        return alias;
    }

    public void setAlias(String unAlias) {
        alias = unAlias;
    }

    //Get y Set de JUEGOSJUGADOS
    public int getJuegosJugados() {
        return juegosJugados;
    }

    public void setJuegosJugados(int unosJuegosJugados) {
        juegosJugados = unosJuegosJugados;
    }

    //Get y Set de PARTIDOSGANADOS
    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int unosPartidosGanados) {
        partidosGanados = unosPartidosGanados;
    }

    //2 jugadores son iguales si tienen el mismo nombre.
    @Override
    public boolean equals(Object jugador) {
        return this.getNombre().equalsIgnoreCase(((Jugador) jugador).getNombre());
    }

//toString
    @Override
    public String toString() {
        return "---------------------------------------------"
                + "\n•Nombre Del Jugador: " + getNombre() + ""
                + "\n•Alias Del Jugador : " + getAlias() + " "
                + "\n•Partidas Jugadas: " + getJuegosJugados()+ " "
                + "\n•Partidos Ganados: " +getPartidosGanados()+" "
                + "\n---------------------------------------------";
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

