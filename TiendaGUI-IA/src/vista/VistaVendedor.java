package vista;

import javax.swing.*;
import java.awt.*;

public class VistaVendedor extends JFrame {

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;
    private JButton btnAnadir;
    private JList<String> listaProductos;
    private DefaultListModel<String> modeloLista;

    public VistaVendedor() {
        setTitle("Vista Vendedor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Formulario
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Añadir Producto"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Stock:"));
        txtStock = new JTextField();
        panelFormulario.add(txtStock);

        btnAnadir = new JButton("Añadir Producto");
        panelFormulario.add(new JLabel());
        panelFormulario.add(btnAnadir);

        // Lista de productos
        modeloLista = new DefaultListModel<>();
        listaProductos = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaProductos);
        scroll.setBorder(BorderFactory.createTitledBorder("Lista de productos"));

        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    public String getTxtNombre() { return txtNombre.getText(); }
    public String getTxtPrecio() { return txtPrecio.getText(); }
    public String getTxtStock() { return txtStock.getText(); }
    public JButton getBtnAnadir() { return btnAnadir; }
    public DefaultListModel<String> getModeloLista() { return modeloLista; }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}