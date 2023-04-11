package shelf.musicshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shelf.musicshelf.domain.music.Composer;

public interface ComposerRepository extends JpaRepository<Composer, Long> {
}
