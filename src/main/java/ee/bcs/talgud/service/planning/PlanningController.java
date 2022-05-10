package ee.bcs.talgud.service.planning;

import ee.bcs.talgud.domain.resource.ResourceDto;
import ee.bcs.talgud.domain.task.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class PlanningController {

    @Resource
    private PlanningService planningService;

    @PostMapping("/task")
    @Operation(summary = "Loob uue Taski")
    public void addNewTask(@RequestBody TaskDto taskDto) {
        planningService.addNewTask(taskDto);
    }

    @GetMapping("/task")
    @Operation(summary = "Leiab kõik projektiga seotud Taskid")
    public List<TaskResponse> getAllTasksForProject (@RequestParam Integer projectId) {
        return planningService.getAllTasksForProject(projectId);
    }

    @DeleteMapping("/task")
    @Operation(summary = "Kustutab Taski")
    public void removeTaskById (@RequestParam Integer taskId) {
        planningService.removeTaskById(taskId);
    }

    @PutMapping("/task")
    @Operation(summary = "Seob Taski useriga")
    public void updateTaskWithUserId (@RequestBody TaskDto taskDto) {
        planningService.updateTaskWithUserId(taskDto);
    }

    @PostMapping("/resource")
    @Operation(summary = "Lisab uue vahendi")
    public void addNewResource(@RequestBody ResourceDto resourceDto) {
        planningService.addNewResource(resourceDto);
    }

    @GetMapping("/resource")
    @Operation(summary = "Leiab kõik projektiga seotud vahendid")
    public List<ResourceDto> getAllResourcesForProject (@RequestParam Integer projectId) {
        return planningService.getAllResourcesForProject(projectId);
    }

    @DeleteMapping("/resource")
    @Operation(summary = "Kustutab lisatud vahendi")
    public void removeResourceById (@RequestParam Integer resourceId) {
        planningService.removeResourceById(resourceId);
    }
    @PutMapping("/resource")
    @Operation(summary = "Seob vahendi useriga")
    public void updateResourceWithUserId (@RequestBody ResourceDto resourceDto) {
        planningService.updateResourceWithUserId(resourceDto);
    }
}
