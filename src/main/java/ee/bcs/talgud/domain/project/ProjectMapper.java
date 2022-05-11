package ee.bcs.talgud.domain.project;

import ee.bcs.talgud.service.management.ProjectResponse;
import ee.bcs.talgud.util.DateUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = DateUtil.class)
public interface ProjectMapper {

    @Mapping(target = "id", ignore = true)
    Project toEntity(ProjectDto projectDto);

    ProjectDto toDto(Project project);

    List<ProjectDto> toDtos(List<Project> project);

    @Mapping(target = "startTime", expression = "java(DateUtil.getFormattedDate(project.getStartTime()))")
    @Mapping(target = "endTime", expression = "java(DateUtil.getFormattedDate(project.getEndTime()))")
    ProjectResponse toProjectResponse(Project project);

    List<ProjectResponse> toProjectResponses(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectFromProjectDto(ProjectDto projectDto, @MappingTarget Project project);
}
