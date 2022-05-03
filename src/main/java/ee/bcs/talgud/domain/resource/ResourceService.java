package ee.bcs.talgud.domain.resource;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectService;
import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {
    @javax.annotation.Resource
    private ResourceRepository resourceRepository;

    @javax.annotation.Resource
    private ProjectService projectService;

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    @javax.annotation.Resource
    private UserService userService;


    public void addNewResource(ResourceDto resourceDto) {
        Project project = projectService.getProjectById(resourceDto.getProjectId());
        Resource resource = new Resource();
        resource.setProject(project);
        resource.setName(resourceDto.getName());
        resource.setUser(null);
        resourceRepository.save(resource);
    }
    public void removeResourceById(Integer resourceId) {
        resourceRepository.deleteById(resourceId);
    }
    public void updateResourceWithUserId(ResourceDto resourceDto) {
       Resource resource = resourceRepository.getById(resourceDto.getId());
        User user = userService.getUserById(resourceDto.getUserId());
        resource.setUser(user);
        resourceRepository.save(resource);
    }

    public List<ResourceDto> getAllResourcesForProject(Integer projectId) {
        List<Resource> resource = resourceRepository.findByProject_Id(projectId);
        return resourceMapper.resourceDtoToResource(resource);
    }

}
