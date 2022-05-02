package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectMapper;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserService;
import ee.bcs.talgud.service.management.ProjectResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectUserService {

    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectUserRepository projectUserRepository;

    @Resource
    private UserService userService;

    @Resource
    private ProjectUserMapper projectUserMapper;


    public ProjectDto addNewProjectUserModerator(ProjectDto projectDto, Integer userId) {
        Project project = projectService.addNewProject(projectDto);
        User user = userService.getUserById(userId);
        ProjectUser projectUser = new ProjectUser(project, user, true);
        projectUserRepository.save(projectUser);
        return projectService.getProjectDto(project);

    }

    public List<ProjectResponse> findAllUserProjects(Integer userId) {
        List<ProjectUser> projects = projectUserRepository.findByUser_Id(userId);
        return projectUserMapper.toProjectResponses(projects);
    }
}
