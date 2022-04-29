package ee.bcs.talgud.domain.project;

import ee.bcs.talgud.service.management.ProjectResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    Project toEntity(ProjectDto projectDto);

    ProjectDto toDto(Project project);

    ProjectResponse toResponse(Project project);

    List<ProjectDto> toDtos(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectFromProjectDto(ProjectDto projectDto, @MappingTarget Project project);
}
