/**
 * Handles user authentication including login and session validation.
 */

public class AuthService {
    private final IUserRepository repository;

    public AuthService(IUserRepository repository) {
        this.repository = repository;
    }

    public boolean register(UserData user) {
        return repository.save(user);
    }

    public boolean login(String username, String password) {
        return repository.findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}
