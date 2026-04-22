package vista;

import javax.swing.*;
import java.awt.*;

public class VistaComprador extends JFrame {

    private JList<String> listaProductos;
    private DefaultListModel<String> modeloLista;
    private JTextField txtCantidad;
    private JButton btnComprar;

    public VistaComprador() {
        setTitle("Vista Comprador");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Lista de productos
        modeloLista = new DefaultListModel<>();
        listaProductos = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaProductos);
        scroll.setBorder(BorderFactory.createTitledBorder("Productos disponibles"));

        // Panel compra
        JPanel panelCompra = new JPanel(new FlowLayout());
        panelCompra.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField(5);
        panelCompra.add(txtCantidad);
        btnComprar = new JButton("Comprar");
        panelCompra.add(btnComprar);

        add(scroll, BorderLayout.CENTER);
        add(panelCompra, BorderLayout.SOUTH);
    }

    public int getIndiceSeleccionado() { return listaProductos.getSelectedIndex(); }
    public String getTxtCantidad() { return txtCantidad.getText(); }
    public JButton getBtnComprar() { return btnComprar; }
    public DefaultListModel<String> getModeloLista() { return modeloLista; }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Compra", JOptionPane.INFORMATION_MESSAGE);
    }
}