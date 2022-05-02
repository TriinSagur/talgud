package ee.bcs.talgud.domain.task;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Task taskDtoToTask(TaskDto taskDto);

    @InheritInverseConfiguration(name = "taskDtoToTask")
    TaskDto taskToTaskDto(Task task);

    List<TaskDto> taskToTaskDto(List<Task> task);

    @InheritConfiguration(name = "taskDtoToTask")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTaskFromTaskDto(TaskDto taskDto, @MappingTarget Task task);
}
