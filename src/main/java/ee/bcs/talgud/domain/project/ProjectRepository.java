package ee.bcs.talgud.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("select p from Project p where p.endTime < ?1")
    List<Project> findByEndTimeIsBefore(Instant endTime);

    @Query("select p from Project p where p.startTime > ?1")
    List<Project> findByStartTimeIsAfter(Instant startTime);



}