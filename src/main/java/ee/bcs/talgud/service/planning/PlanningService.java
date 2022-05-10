package ee.bcs.talgud.service.planning;

import ee.bcs.talgud.domain.contact.Contact;
import ee.bcs.talgud.domain.contact.ContactService;
import ee.bcs.talgud.domain.resource.ResourceDto;
import ee.bcs.talgud.domain.resource.ResourceService;
import ee.bcs.talgud.domain.task.TaskDto;
import ee.bcs.talgud.domain.task.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlanningService {

    @Resource
    private TaskService taskService;

    @Resource
    private ResourceService resourceService;

    @Resource
    private ContactService contactService;


    public void addNewTask(TaskDto taskDto) {
        taskService.addNewTask(taskDto);
    }

    public List<TaskResponse> getAllTasksForProject(Integer projectId) {
        List<TaskDto> tasks = taskService.getAllTasksForProject(projectId);
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskDto task : tasks) {
            TaskResponse taskResponse = new TaskResponse();
            if (task.getUserId() != null) {
                Contact contact = contactService.getContactsByUserId(task.getUserId());
                mapContactToTaskResponse(contact, taskResponse);
            }
            mapTasksToTaskResponse(task, taskResponse);
            taskResponses.add(taskResponse);
        }
        return taskResponses;
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

    private void mapTasksToTaskResponse(TaskDto task, TaskResponse taskResponse) {
        taskResponse.setId(task.getId());
        taskResponse.setProjectId(task.getProjectId());
        taskResponse.setUserId(task.getUserId());
        taskResponse.setName(task.getName());
    }

    private void mapContactToTaskResponse(Contact contact, TaskResponse taskResponse) {
        taskResponse.setContactFirstName(contact.getFirstName());
        taskResponse.setContactLastName(contact.getLastName());
    }

}
