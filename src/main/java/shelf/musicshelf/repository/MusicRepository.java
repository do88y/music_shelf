package shelf.musicshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shelf.musicshelf.domain.music.Music;

public interface MusicRepository extends JpaRepository<Music, Long>, MusicRepositoryCustom {

}
