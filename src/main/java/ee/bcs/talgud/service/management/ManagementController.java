package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
import ee.bcs.talgud.domain.task.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping()
public class ManagementController {

    @Resource
    private ManagementService managementService;

    @PostMapping("/new-project")
    @Operation(summary = "Loob uued talgud ja määrab looja moderaatoriks")
    public ProjectDto addNewProjectUser(@RequestBody ProjectDto projectDto, @RequestParam Integer userId) {
        return managementService.addNewProjectUser(projectDto, userId);
    }

    @GetMapping("/all")
    @Operation(summary = "Leiab kõik talgud")
    public List<ProjectDto> getAllProjects() {
        return managementService.getAllProjects();
    }

    @GetMapping("/old-projects")
    @Operation(summary = "Leiab juba toimunud talgud")
    public List<ProjectDto> getAllOldProjects() {
        Instant now = Instant.now();
        return managementService.getAllOldProjects(now);
    }

    @GetMapping("/new-projects")
    @Operation(summary = "Leiab uued tulevased talgud")
    public List<ProjectDto> getAllNewProjects() {
        Instant now = Instant.now();
        return managementService.getAllNewProjects(now);
    }

    @PostMapping("/task")
    @Operation(summary = "Loob uue Taski")
    public void addNewTask(@RequestBody TaskDto taskDto) {
        managementService.addNewTask(taskDto);
    }

    @GetMapping("/task")
    @Operation(summary = "Leiab kõik projektiga seotud Taskid")
    public List<TaskDto> getAllTasksForProject (@RequestParam Integer projectId) {
        return managementService.getAllTasksForProject(projectId);
    }

    @DeleteMapping("/task")
    @Operation(summary = "Kustutab Taski")
    public void removeTaskById (@RequestParam Integer taskId) {
        managementService.removeTaskById(taskId);
    }

    @PutMapping("/task")
    @Operation(summary = "Seob Taski useriga")
    public void updateTaskWithUserId (@RequestBody TaskDto taskDto) {
        managementService.updateTaskWithUserId(taskDto);
    }

    @GetMapping("/projectusers")
    @Operation(summary = "Leiab kõik konkreetse talguga liitunud Userid")
    public List<UserResponse> findAllProjectUsers(@RequestParam Integer projectId) {
        return managementService.findAllProjectUsers(projectId);
    }

}

