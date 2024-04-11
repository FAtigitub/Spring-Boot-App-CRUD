package ma.xproce.tp2.dao.repositories;

import ma.xproce.tp2.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}
