/**
 * Interface for user data persistence operations.
 */

import java.util.Optional;

public interface IUserRepository {
    boolean save(UserData user);
    Optional<UserData> findByUsername(String username);
}
