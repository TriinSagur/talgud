package ee.bcs.talgud.domain.task;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private UserService userService;

    @Resource
    private ProjectService projectService;

    @Resource
    private TaskRepository taskRepository;

    @Resource
    private TaskMapper taskMapper;

    public void addNewTask (TaskDto taskDto) {
        Project project = projectService.getProjectById(taskDto.getProjectId());
        Task task = new Task();
        task.setProject(project);
        task.setName(taskDto.getName());
        task.setUser(null);
        taskRepository.save(task);
    }

    public List<TaskDto> getAllTasksForProject(Integer projectId) {
        List<Task> tasks = taskRepository.findByProject_Id(projectId);
        return taskMapper.taskToTaskDto(tasks);
    }

    public void removeTaskById(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    public void updateTaskWithUserId(TaskDto taskDto) {
        Task task = taskRepository.getById(taskDto.getId());
        User user = userService.getUserById(taskDto.getUserId());
        task.setUser(user);
        taskRepository.save(task);
    }
}
