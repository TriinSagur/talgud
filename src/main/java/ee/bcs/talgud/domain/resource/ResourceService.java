package ee.bcs.talgud.domain.resource;

import ee.bcs.talgud.domain.project.Project;
import ee.bcs.talgud.domain.project.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @javax.annotation.Resource
    private ResourceRepository resourceRepository;

    @javax.annotation.Resource
    private ProjectService projectService;

        public void addNewResource(ResourceDto resourceDto) {
        Project project = projectService.getProjectById(resourceDto.getProjectId());
        Resource resource = new Resource();
        resource.setProject(project);
        resource.setName(resourceDto.getName());
        resource.setUser(null);
        resourceRepository.save(resource);
    }
}
