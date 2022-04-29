package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProjectUserService {

    @Resource
    private ProjectUserRepository projectUserRepository;

    public Integer addNewProjectUserModerator(Project project, User user) {
        ProjectUser projectUser = new ProjectUser(project, user, true, false);
        projectUserRepository.save(projectUser);
        return projectUser.getId();
    }
}
