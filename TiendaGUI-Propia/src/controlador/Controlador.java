package controlador;

import modelo.Producto;
import modelo.Tienda;
import vista.VistaComprador;
import vista.VistaPrincipal;
import vista.VistaVendedor;

public class Controlador {

    private Tienda tienda;
    private VistaPrincipal vistaPrincipal;
    private VistaVendedor vistaVendedor;
    private VistaComprador vistaComprador;

    public Controlador(Tienda tienda, VistaPrincipal vistaPrincipal) {
        this.tienda = tienda;
        this.vistaPrincipal = vistaPrincipal;

        vistaPrincipal.getBtnVendedor().addActionListener(e -> abrirVendedor());
        vistaPrincipal.getBtnComprador().addActionListener(e -> abrirComprador());
    }

    private void abrirVendedor() {
        vistaVendedor = new VistaVendedor();
        vistaVendedor.getBtnAnadir().addActionListener(e -> añadirProducto());
        vistaVendedor.setVisible(true);
    }

    private void abrirComprador() {
        vistaComprador = new VistaComprador();
        actualizarListaComprador();
        vistaComprador.getBtnComprar().addActionListener(e -> comprarProducto());
        vistaComprador.setVisible(true);
    }

    private void añadirProducto() {
        String nombre = vistaVendedor.getTxtNombre().trim();
        String precioTexto = vistaVendedor.getTxtPrecio().trim();
        String stockTexto = vistaVendedor.getTxtStock().trim();

        if (nombre.isEmpty()) {
            vistaVendedor.mostrarError("El nombre no puede estar vacío.");
            return;
        }

        double precio;
        int stock;

        try {
            precio = Double.parseDouble(precioTexto);
            if (precio <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            vistaVendedor.mostrarError("El precio debe ser un número mayor que 0.");
            return;
        }

        try {
            stock = Integer.parseInt(stockTexto);
            if (stock <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            vistaVendedor.mostrarError("El stock debe ser un número entero mayor que 0.");
            return;
        }

        Producto p = new Producto(nombre, precio, stock);
        boolean añadido = tienda.añadirProducto(p);

        if (!añadido) {
            vistaVendedor.mostrarError("No se pueden añadir más de 5 productos.");
            return;
        }

        vistaVendedor.getModeloLista().addElement(p.toString());
        vistaVendedor.limpiarCampos();
    }

    private void comprarProducto() {
        int indice = vistaComprador.getIndiceSeleccionado();

        if (indice == -1) {
            vistaComprador.mostrarError("Selecciona un producto de la lista.");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(vistaComprador.getTxtCantidad().trim());
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            vistaComprador.mostrarError("La cantidad debe ser un número entero positivo.");
            return;
        }

        Producto p = tienda.getProductos().get(indice);

        if (cantidad > p.getStock()) {
            vistaComprador.mostrarError("No hay suficiente stock. Stock disponible: " + p.getStock());
            return;
        }

        p.setStock(p.getStock() - cantidad);
        actualizarListaComprador();
        vistaComprador.mostrarMensaje("Compra realizada. Has comprado " + cantidad + " unidad/es de " + p.getNombre());
    }

    private void actualizarListaComprador() {
        vistaComprador.getModeloLista().clear();
        for (Producto p : tienda.getProductos()) {
            vistaComprador.getModeloLista().addElement(p.toString());
        }
    }
}
