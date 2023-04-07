package shelf.musicshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelf.musicshelf.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    public Optional<User> findById(Long id);

    public Optional<User> findByUsername(String username);
}
