package ee.bcs.talgud.domain.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    @Query("select p from Picture p where p.project.id = ?1")
    List<Picture> findByProject_Id(Integer id);

}