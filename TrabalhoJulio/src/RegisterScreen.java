import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterScreen() {
        setTitle("Cadastro");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameLabel.setBounds(10, 10, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 10, 160, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 40, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 40, 160, 25);
        add(passwordField);

        registerButton = new JButton("Cadastrar");
        registerButton.setBounds(100, 80, 100, 25);
        add(registerButton);

        registerButton.addActionListener(new RegisterButtonListener());
    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Salvando usuário em um arquivo (apenas exemplo)
            UserDatabase.saveUser(username, password);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

            dispose();
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
        }
    }
}
