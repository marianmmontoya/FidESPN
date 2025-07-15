package fidespn;

// Proyecto FidESPN - Realizado por Marian Montoya Chavarría

import javax.swing.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;

    public LoginGUI() {
        setTitle("FidESPN - Ingreso");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 30, 80, 20);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 30, 150, 20);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(20, 60, 80, 20);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(100, 60, 150, 20);
        add(txtContrasena);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(100, 100, 100, 25);
        add(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = new String(txtContrasena.getPassword());
                JOptionPane.showMessageDialog(null, "Bienvenido " + usuario + " a FidESPN");
            }
        });
    }
}
