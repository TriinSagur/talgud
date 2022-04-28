//package ee.bcs.talgud.service.management;
//
//import io.swagger.v3.oas.annotations.Operation;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//@RequestMapping("/management")
//public class ManagementController {
//
//    @Resource
//    private ManagementService managementService;
//
//    @PostMapping
//    @Operation(summary = "Loob uue projekti.")
//    public int addNewProject(RequestBody ProjectDto projectDto) {
//        return managementService.addNewProject(projectDto);
//    }
//}
