package ee.bcs.talgud.service.management;

import ee.bcs.talgud.domain.project.ProjectDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class ManagementController {

    @Resource
    private ManagementService managementService;

    @PostMapping("/new-project")
    @Operation(summary = "Loob uued talgud ja määrab looja moderaatoriks")
    public Integer addNewProjectUser(@RequestBody ProjectDto projectDto, @RequestParam Integer userId) {
        return managementService.addNewProjectUser(projectDto, userId);
    }

    @GetMapping("/all")
    @Operation(summary = "Leiab kõik talgud")
    public List<ProjectDto> getAllProjects() {
        return managementService.getAllProjects();
    }

}
