package ee.bcs.talgud.domain.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
//    @Query("select t from Task t where t.project.id = ?1")
//    List<Task> findByProject_Id(Integer id);

    @Query("select t from Task t where t.project.id = ?1 order by t.id")
    List<Task> findByProject_Id(Integer id);



}