package ee.bcs.talgud.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("select p from Project p where p.startTime > ?1 order by p.startTime")
    List<Project> findNew(Instant startTime);

    @Query("select p from Project p where p.startTime < ?1 or p.endTime < ?2 order by p.startTime")
    List<Project> findOld(Instant startTime, Instant endTime);





}