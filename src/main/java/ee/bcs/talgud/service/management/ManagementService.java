package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagementService {

    @Resource
    private ProjectService projectService;

    public void addNewProject(ProjectDto projectDto) {
        projectService.addNewProject(projectDto);
    }

    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

}
