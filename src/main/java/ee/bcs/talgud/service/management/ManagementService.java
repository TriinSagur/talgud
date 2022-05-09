package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.projectuser.ProjectUserService;
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


    public ProjectResponse addNewProjectUserModerator(ProjectDto projectDto, Integer userId) {
        return projectUserService.addNewProjectUserModerator(projectDto, userId);
    }

    public void addNewProjectUser(Integer projectId, Integer userId) {
        projectUserService.addNewProjectUser(projectId, userId);
    }

    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    public List<ProjectResponse> findAllUserProjects(Integer userId) {
        return projectUserService.findAllUserProjects(userId);
    }

    public List<ProjectDto> getAllOldProjects(Instant now) {
        return projectService.getAllOldProjects(now);
    }

    public List<ProjectDto> getAllNewProjects(Instant now) {
        return projectService.getAllNewProjects(now);
    }

    public List<UserResponse> findAllProjectUsers(Integer projectId) {
        return projectUserService.findAllProjectUsers(projectId);
    }


}
