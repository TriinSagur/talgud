package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectUserService {

    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectUserRepository projectUserRepository;

    @Resource
    private UserService userService;

    public ProjectDto addNewProjectUserModerator(ProjectDto projectDto, Integer userId) {
        Project project = projectService.addNewProject(projectDto);
        User user = userService.getUserById(userId);
        ProjectUser projectUser = new ProjectUser(project, user, true, false);
        projectUserRepository.save(projectUser);
        return projectService.getProjectDto(project);

    }
}
