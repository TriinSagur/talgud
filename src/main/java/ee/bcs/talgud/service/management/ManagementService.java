package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.projectuser.ProjectUserDto;
import ee.bcs.talgud.domain.projectuser.ProjectUserService;
import ee.bcs.talgud.domain.task.TaskDto;
import ee.bcs.talgud.domain.task.TaskService;
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
    private TaskService taskService;

    public ProjectDto addNewProjectUser(ProjectDto projectDto, Integer userId) {
        return projectUserService.addNewProjectUserModerator(projectDto, userId);
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
    public List<TaskDto> addNewTask(TaskDto taskDto) {
        taskService.addNewTask(taskDto);
        return taskService.getAllTasksForProject(taskDto);
    }
}
