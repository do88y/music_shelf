package shelf.musicshelf.domain.music;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Music {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "composer_id")
    private Composer composer;
    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;

    public static Music createMusic(Composer composer, Player player, String title, Category category) {
        Music music = new Music();
        music.composer = composer;
        music.player = player;
        music.title = title;
        music.category = category;
        return music;
    }
}

