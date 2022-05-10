package ee.bcs.talgud.domain.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    @Query("select r from Resource r where r.project.id = ?1 order by r.id")
    List<Resource> findByProject_Id(Integer id);



}