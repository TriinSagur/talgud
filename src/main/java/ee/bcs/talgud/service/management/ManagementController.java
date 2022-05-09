package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
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

    @PostMapping("/project")
    @Operation(summary = "Loob uued talgud ja määrab looja moderaatoriks")
    public ProjectResponse addNewProjectUserModerator(@RequestBody ProjectDto projectDto, @RequestParam Integer userId) {
        return managementService.addNewProjectUserModerator(projectDto, userId);
    }

    @PostMapping("/project-user")
    @Operation(summary = "Lisab kasutaja olemasoleva projekti osaliseks")
    public void addNewProjectUser(@RequestParam Integer projectId, @RequestParam Integer userId) {
        managementService.addNewProjectUser(projectId, userId);
    }

    @GetMapping("/project-all")
    @Operation(summary = "Leiab kõik talgud")
    public List<ProjectDto> getAllProjects() {
        return managementService.getAllProjects();
    }

    @GetMapping("/project-old")
    @Operation(summary = "Leiab juba toimunud talgud")
    public List<ProjectDto> getAllOldProjects() {
        Instant now = Instant.now();
        return managementService.getAllOldProjects(now);
    }

    @GetMapping("/project-new")
    @Operation(summary = "Leiab uued tulevased talgud")
    public List<ProjectDto> getAllNewProjects() {
        Instant now = Instant.now();
        return managementService.getAllNewProjects(now);
    }

    @GetMapping("/project-user")
    @Operation(summary = "Leiab kõik kasutaja talgud")
    public List<ProjectResponse> findAllUserProjects(@RequestParam Integer userId) {
        return managementService.findAllUserProjects(userId);
    }

    @GetMapping("/user-project")
    @Operation(summary = "Leiab kõik konkreetse talguga liitunud Userid")
    public List<UserResponse> findAllProjectUsers(@RequestParam Integer projectId) {
        return managementService.findAllProjectUsers(projectId);
    }


}

