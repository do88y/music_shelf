package shelf.musicshelf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shelf.musicshelf.domain.music.Composer;
import shelf.musicshelf.domain.music.Category;
import shelf.musicshelf.domain.music.Music;
import shelf.musicshelf.domain.music.Player;
import shelf.musicshelf.repository.ComposerRepository;
import shelf.musicshelf.repository.MusicRepository;
import shelf.musicshelf.repository.PlayerRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    private final ComposerRepository composerRepository;
    private final PlayerRepository playerRepository;

    /**
     * 음악 등록
     */
    public Music save(String composer, String player, String title, Category category) {
        Composer newComposer = new Composer(composer);
        Player newPlayer = new Player(player);
        Music music = Music.createMusic(newComposer, newPlayer, title, category);

        composerRepository.save(newComposer);
        playerRepository.save(newPlayer);
        musicRepository.save(music);

        return music;
    }


}
