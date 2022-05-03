package ee.bcs.talgud.service.planning;

import ee.bcs.talgud.domain.resource.ResourceDto;
import ee.bcs.talgud.domain.resource.ResourceService;
import ee.bcs.talgud.domain.task.TaskDto;
import ee.bcs.talgud.domain.task.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanningService {

    @Resource
    private TaskService taskService;

    @Resource
    private ResourceService resourceService;


    public void addNewTask(TaskDto taskDto) {
        taskService.addNewTask(taskDto);
    }

    public List<TaskDto> getAllTasksForProject (Integer projectId) {
        return taskService.getAllTasksForProject(projectId);
    }

    public void removeTaskById(Integer taskId) {
        taskService.removeTaskById(taskId);
    }

    public void updateTaskWithUserId(TaskDto taskDto) {
        taskService.updateTaskWithUserId(taskDto);
    }
    public void addNewResource(ResourceDto resourceDto) {
        resourceService.addNewResource(resourceDto);
    }

    public List<ResourceDto> getAllResourcesForProject(Integer projectId) {
        return resourceService.getAllResourcesForProject(projectId);
    }
    public void removeResourceById(Integer resourceId) {
        resourceService.removeResourceById(resourceId);

    }
    public void updateResourceWithUserId(ResourceDto resourceDto) {
        resourceService.updateResourceWithUserId(resourceDto);
    }

}
