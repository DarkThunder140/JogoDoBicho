import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserDatabase {
    private static final String USER_FILE = "users.txt";

    // Método para salvar um usuário no arquivo
    public static void saveUser(String username, String password) {
        try (FileWriter writer = new FileWriter(USER_FILE, true)) {
            writer.write(username + ";" + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para verificar se o usuário é válido
    public static boolean isUserValid(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
