package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserService;
import ee.bcs.talgud.service.management.UserResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectUserService {

    @Resource
    private ProjectService projectService;

    @Resource
    private UserService userService;

    @Resource
    private ProjectUserRepository projectUserRepository;

    @Resource
    private ProjectUserMapper projectUserMapper;

    public ProjectDto addNewProjectUserModerator(ProjectDto projectDto, Integer userId) {
        Project project = projectService.addNewProject(projectDto);
        User user = userService.getUserById(userId);
        ProjectUser projectUser = new ProjectUser(project, user, true);
        projectUserRepository.save(projectUser);
        return projectService.getProjectDto(project);

    }

    public List<UserResponse> findAllProjectUsers(Integer projectId) {
        List<ProjectUser> projectUsers = projectUserRepository.findByProject_Id(projectId);
        return projectUserMapper.toUserResponses(projectUsers);
    }
}
