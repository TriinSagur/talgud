package ee.bcs.talgud.domain.project;

import ee.bcs.talgud.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class ProjectService {

    @Resource
    private ProjectRepository projectRespository;

    @Resource
    private ProjectMapper projectMapper;

    public Project addNewProject(ProjectDto projectDto) {
        Project project = projectMapper.toEntity(projectDto);
        projectRespository.save(project);
        return project;
    }

    public Project getProjectById(Integer projectId) {
        return projectRespository.getById(projectId);

    }

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRespository.findAll();
        return projectMapper.toDtos(projects);

    }


    public List<ProjectDto> getAllOldProjects(Instant now) {
        List<Project>projects= projectRespository.findByEndTimeIsBefore(now);
        return projectMapper.toDtos(projects);
    }

    public List<ProjectDto> getAllNewProjects(Instant now) {
        List<Project>projects=projectRespository.findByStartTimeIsAfter(now);
        return projectMapper.toDtos(projects);
    }

    public ProjectDto getProjectDto(Project project) {
        return projectMapper.toDto(project);
    }
}
