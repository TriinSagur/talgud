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

    public List<PlanningResponse> getAllTasksForProject(Integer projectId) {
        List<TaskDto> tasks = taskService.getAllTasksForProject(projectId);
        List<PlanningResponse> planningResponses = new ArrayList<>();
        for (TaskDto task : tasks) {
            PlanningResponse planningResponse = new PlanningResponse();
            if (task.getUserId() != null) {
                Contact contact = contactService.getContactsByUserId(task.getUserId());
                mapContactToPlanningResponse(contact, planningResponse);
            }
            mapTaskToPlanningResponse(task, planningResponse);
            planningResponses.add(planningResponse);
        }
        return planningResponses;
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

    public List<PlanningResponse> getAllResourcesForProject(Integer projectId) {
        List<ResourceDto> resources = resourceService.getAllResourcesForProject(projectId);
        List<PlanningResponse> planningResponses = new ArrayList<>();
        for (ResourceDto resource : resources) {
            PlanningResponse planningResponse = new PlanningResponse();
            if (resource.getUserId() != null) {
                Contact contact = contactService.getContactsByUserId(resource.getUserId());
                mapContactToPlanningResponse(contact, planningResponse);
            }
            mapResourceToPlanningResponse(resource, planningResponse);
            planningResponses.add(planningResponse);
        }
        return planningResponses;
    }

    public void removeResourceById(Integer resourceId) {
        resourceService.removeResourceById(resourceId);

    }

    public void updateResourceWithUserId(ResourceDto resourceDto) {
        resourceService.updateResourceWithUserId(resourceDto);
    }

    private void mapTaskToPlanningResponse(TaskDto task, PlanningResponse planningResponse) {
        planningResponse.setId(task.getId());
        planningResponse.setProjectId(task.getProjectId(
        ));
        planningResponse.setUserId(task.getUserId());
        planningResponse.setName(task.getName());
    }

    private void mapResourceToPlanningResponse(ResourceDto resourceDto, PlanningResponse planningResponse) {
        planningResponse.setId(resourceDto.getId());
        planningResponse.setProjectId(resourceDto.getProjectId());
        planningResponse.setUserId(resourceDto.getUserId());
        planningResponse.setName(resourceDto.getName());
    }

    private void mapContactToPlanningResponse(Contact contact, PlanningResponse planningResponse) {
        planningResponse.setContactFirstName(contact.getFirstName());
        planningResponse.setContactLastName(contact.getLastName());
    }

}
