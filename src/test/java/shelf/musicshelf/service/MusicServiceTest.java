package shelf.musicshelf.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shelf.musicshelf.domain.music.Category;
import shelf.musicshelf.domain.music.Music;
import shelf.musicshelf.repository.MusicRepository;

import java.util.List;

@SpringBootTest
@Transactional
class MusicServiceTest {

    @Autowired MusicRepository musicRepository;
    @Autowired MusicService musicService;

    @Test
    @DisplayName("음악 등록")
    void save() throws Exception {
        //given
        Music savedMusic = musicService.save("bach", "Glenn Gould", "Goldberg variations", Category.ETC);
        musicRepository.save(savedMusic);

        //when
        List<Music> findMusic = musicRepository.findByComposerName("bach");

        //then
        Assertions.assertThat(findMusic.get(0)).isEqualTo(savedMusic);
    }
}