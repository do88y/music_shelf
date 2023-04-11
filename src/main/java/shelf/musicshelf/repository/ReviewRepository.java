package shelf.musicshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shelf.musicshelf.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
