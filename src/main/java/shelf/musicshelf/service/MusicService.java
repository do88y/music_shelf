package shelf.musicshelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shelf.musicshelf.domain.music.Composer;
import shelf.musicshelf.domain.music.Category;
import shelf.musicshelf.domain.music.Music;
import shelf.musicshelf.domain.music.Player;
import shelf.musicshelf.repository.MusicRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    /**
     * 음악 등록
     */
    public Music save(String composer, String player, String title, Category category) {
        Composer newComposer = new Composer(composer);
        Player newPlayer = new Player(player);
        return Music.createMusic(newComposer, newPlayer, title, category);
    }
}
