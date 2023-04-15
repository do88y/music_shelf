package shelf.musicshelf.repository;

import shelf.musicshelf.domain.music.Music;

import java.util.List;

public interface MusicRepositoryCustom {
    List<Music> findByComposerName(String name);
}
