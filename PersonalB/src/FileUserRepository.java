/**
 * Handles user data persistence to and from files.
 */
import java.io.*;
import java.util.*;

public class FileUserRepository implements IUserRepository {
    private final String filePath = "users.txt";
    private final Map<String, UserData> users = new HashMap<>();

    public FileUserRepository() {
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    UserData user = new UserData(parts[0], parts[1], parts[2]);
                    users.put(parts[0], user);
                }
            }
        } catch (IOException e) {
            System.out.println("User file not found. A new one will be created.");
        }
    }

    @Override
    public boolean save(UserData user) {
        if (users.containsKey(user.getUsername())) return false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(user.getUsername() + "," + user.getEmail() + "," + user.getPassword());
            writer.newLine();
            users.put(user.getUsername(), user);
            return true;
        } catch (IOException e) {
            System.out.println("Failed to save user: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<UserData> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }
}
