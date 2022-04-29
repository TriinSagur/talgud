package ee.bcs.talgud.domain.projectuser;

import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectUserMapper {
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "userId", target = "user.id")
    ProjectUser projectUserDtoToProjectUser(ProjectUserDto projectUserDto);

    @InheritInverseConfiguration(name = "projectUserDtoToProjectUser")
    ProjectUserDto projectUserToProjectUserDto(ProjectUser projectUser);

    @InheritConfiguration(name = "projectUserDtoToProjectUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectUserFromProjectUserDto(ProjectUserDto projectUserDto, @MappingTarget ProjectUser projectUser);
}
