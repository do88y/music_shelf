package shelf.musicshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shelf.musicshelf.domain.music.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

    @Query("select m from Music m where m.composer.name like %:composerName%")
    public Music findByComposerName(@Param("composerName") String composerName);
}
