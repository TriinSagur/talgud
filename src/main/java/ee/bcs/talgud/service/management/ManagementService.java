package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class ManagementService {

    @Resource
    private ProjectService projectService;

    public ProjectDto addNewProject (ProjectDto request){
        return projectService.addNewProject(request);
    }

    public List<ProjectDto>getAllProjects(){
        return projectService.getAllProjects();

    }


    public List<ProjectDto> getAllOldProjects(Instant now) {
        return projectService.getAllOldProjects(now);
    }

    public List<ProjectDto> getAllNewProjects(Instant now) {
        return projectService.getAllNewProjects(now);
    }
}
