package tiendagui2;

import controlador.Controlador;
import modelo.Tienda;
import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        Controlador controlador = new Controlador(tienda, vistaPrincipal);
        vistaPrincipal.setVisible(true);
    }
}
