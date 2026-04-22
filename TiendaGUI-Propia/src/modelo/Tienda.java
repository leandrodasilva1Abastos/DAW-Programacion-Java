package modelo;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> productos;

    public Tienda() {
        productos = new ArrayList<>();
    }

    public boolean añadirProducto(Producto p) {
        if (productos.size() >= 5) {
            return false;
        }
        productos.add(p);
        return true;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
