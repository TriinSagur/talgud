package ee.bcs.talgud.domain.project;

import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.service.management.ProjectResponse;
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

    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectRespository.findAll();
        return projectMapper.toProjectResponses(projects);

    }


    public List<ProjectResponse> getAllOldProjects(Instant now) {
        List<Project> projects = projectRespository.findOld(now, now);
        return projectMapper.toProjectResponses(projects);
    }

    public List<ProjectResponse> getAllNewProjects(Instant now) {
        List<Project> projects = projectRespository.findNew(now);
        return projectMapper.toProjectResponses(projects);
    }

    public ProjectDto getProjectDto(Project project) {
        return projectMapper.toDto(project);
    }
}
