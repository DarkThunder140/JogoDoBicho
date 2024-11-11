import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MainScreen extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;

    public MainScreen() {
        setTitle("Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(10, 10, 360, 200);
        add(textArea);

        saveButton = new JButton("Salvar");
        saveButton.setBounds(150, 220, 100, 25);
        add(saveButton);

        saveButton.addActionListener(new SaveButtonListener());
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();

            Thread saveThread = new Thread(() -> {
                try (FileWriter writer = new FileWriter("dados.txt", true)) {
                    writer.write(text + "\n");
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar dados");
                }
            });

            saveThread.start();
        }
    }
}
