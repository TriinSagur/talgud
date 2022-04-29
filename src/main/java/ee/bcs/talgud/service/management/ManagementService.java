package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.projectuser.ProjectUserService;
import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Service
public class ManagementService {

    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectUserService projectUserService;

    @Resource
    private UserService userService;

    public Integer addNewProjectUser(ProjectDto projectDto, Integer userId) {
        Project project = projectService.addNewProject(projectDto);
        User user = userService.getUserById(userId);
        return projectUserService.addNewProjectUserModerator(project, user);
    }

    public Project addNewProject (ProjectDto request){
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
