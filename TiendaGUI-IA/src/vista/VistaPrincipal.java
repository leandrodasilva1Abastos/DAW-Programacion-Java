package vista;

import javax.swing.*;
import java.awt.*;

public class VistaPrincipal extends JFrame {

    private JButton btnVendedor;
    private JButton btnComprador;

    public VistaPrincipal() {
        setTitle("Tienda - Inicio");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("¿Quién eres?", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        btnVendedor = new JButton("Vendedor");
        btnComprador = new JButton("Comprador");

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnVendedor);
        panelBotones.add(btnComprador);

        add(lblTitulo, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public JButton getBtnVendedor() { return btnVendedor; }
    public JButton getBtnComprador() { return btnComprador; }
}