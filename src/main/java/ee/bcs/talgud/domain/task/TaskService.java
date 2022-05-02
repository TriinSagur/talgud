package ee.bcs.talgud.domain.task;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectService;
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
//        User user = userService.getUserById(taskDto.getUserId());
        Project project = projectService.getProjectById(taskDto.getProjectId());
        Task task = taskMapper.taskDtoToTask(taskDto);
        task.setUser(null);
        taskRepository.save(task);
    }

    public List<TaskDto> getAllTasksForProject(TaskDto taskDto) {
        List<Task> tasks = taskRepository.findByProject_Id(taskDto.getProjectId());
        return taskMapper.taskToTaskDto(tasks);
    }

}
