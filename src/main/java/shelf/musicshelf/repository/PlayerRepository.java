package shelf.musicshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shelf.musicshelf.domain.music.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
