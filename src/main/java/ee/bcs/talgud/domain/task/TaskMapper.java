package ee.bcs.talgud.domain.task;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "responsibleUserId", target = "responsibleUser.id")
    Task taskDtoToTask(TaskDto taskDto);

    @InheritInverseConfiguration(name = "taskDtoToTask")
    TaskDto taskToTaskDto(Task task);

    @InheritConfiguration(name = "taskDtoToTask")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTaskFromTaskDto(TaskDto taskDto, @MappingTarget Task task);

}
