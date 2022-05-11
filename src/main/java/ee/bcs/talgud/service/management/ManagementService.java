package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.contact.Contact;
import ee.bcs.talgud.domain.contact.ContactService;
import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.projectuser.ProjectUser;
import ee.bcs.talgud.domain.projectuser.ProjectUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagementService {

    @Resource
    private ProjectService projectService;

    @Resource
    private ProjectUserService projectUserService;

    @Resource
    private ContactService contactService;


    public UsersProjectResponse addNewProjectUserModerator(ProjectDto projectDto, Integer userId) {
        return projectUserService.addNewProjectUserModerator(projectDto, userId);
    }

    public void addNewProjectUser(Integer projectId, Integer userId) {
        projectUserService.addNewProjectUser(projectId, userId);
    }

    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    public List<UsersProjectResponse> findAllUserProjects(Integer userId) {
        return projectUserService.findAllUserProjects(userId);
    }

    public List<ProjectResponse> getAllOldProjects(Instant now) {
        return projectService.getAllOldProjects(now);
    }

    public List<ProjectResponse> getAllNewProjects(Instant now) {
        return projectService.getAllNewProjects(now);
    }

    public List<UserResponse> findAllProjectUsers(Integer projectId) {
        List<ProjectUser> projectUsers = projectUserService.findAllProjectUsers(projectId);
        List<UserResponse> userResponses = new ArrayList<>();
        for (ProjectUser projectUser : projectUsers) {
            Contact contact = contactService.getContactsByUserId(projectUser.getUser().getId());
            UserResponse userResponse = new UserResponse();
            userResponse.setUserId(projectUser.getUser().getId());
            userResponse.setUserUsername(projectUser.getUser().getUsername());
            userResponse.setContactFirstName(contact.getFirstName());
            userResponse.setContactLastName(contact.getLastName());
            userResponses.add(userResponse);
        }
        return userResponses;
    }


}
