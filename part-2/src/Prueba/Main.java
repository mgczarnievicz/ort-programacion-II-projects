
package Prueba;

import Dominio.Sistema;
import Interfaz.MenuPrincipal;

public class Main {
//Se corre el programa.
    public static void main(String[] args) {
        //RECUPERO EL SISTEMA
        Sistema s = Sistema.recuperarSistema();
        MenuPrincipal m = new MenuPrincipal(s);
        m.setVisible(true);

    }
}
