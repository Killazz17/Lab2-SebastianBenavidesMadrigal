package org.example.Views;

import javax.swing.*;

public class LoginView extends JFrame {
    private JPanel contentPanel;
    private JPanel loginPanel;
    private JPanel buttonLoginPanel;
    private JPanel loginFieldPanel;
    private JPanel logginTittlePanel;
    private JLabel loginLabel;
    private JPanel usernameGroupPanel;
    private JPanel passGroupPanel;
    private JTextField usernameTextField;
    private JLabel usernameLabel;
    private JTextField passTextField;
    private JLabel passLabel;
    private JButton loginButton;

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public LoginView() {
        setContentPane(contentPanel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        loginButton.addActionListener(e -> onClick());
    }

    private void onClick() {
        String username = usernameTextField.getText().trim();
        String password = passTextField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "wrong username or password",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            //crear y mostrar la ventana de Inicio
            JFrame mainWindow = new MainView();
            mainWindow.setVisible(true);
            this.dispose();
        }
    }
}
