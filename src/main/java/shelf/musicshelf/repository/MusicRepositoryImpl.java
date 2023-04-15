package shelf.musicshelf.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import shelf.musicshelf.domain.music.Music;

import javax.persistence.EntityManager;
import java.util.List;

import static shelf.musicshelf.domain.music.QMusic.*;

public class MusicRepositoryImpl implements MusicRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MusicRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Music> findByComposerName(String name) {
        return queryFactory
                .selectFrom(music)
                .where(music.composer.name.contains(name))
                .fetch();
    }
}
