package ee.bcs.talgud.domain.project;

import ee.bcs.talgud.service.management.ProjectResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRespository.findAll();
        return projectMapper.toDtos(projects);
    }

}
