package shelf.musicshelf.domain;

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
    private String era;
}
