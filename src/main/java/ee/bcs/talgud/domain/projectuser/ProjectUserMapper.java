package ee.bcs.talgud.domain.projectuser;

import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectUserMapper {

    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "userId", target = "user.id")
    ProjectUser projectUserDtoToProjectUser(ProjectUserDto projectUserDto);

    @InheritInverseConfiguration(name = "projectUserDtoToProjectUser")
    ProjectUserDto projectUserToProjectUserDto(ProjectUser projectUser);

    @Mapping(target = "projectId", source = "project.id")
    @Mapping(target = "projectName", source = "project.name")
    @Mapping(target = "projectAddress", source = "project.address")
    @Mapping(target = "projectStartTime", source = "project.startTime")
    @Mapping(target = "projectEndTime", source = "project.endTime")
    @Mapping(target = "projectLongitude", source = "project.longitude")
    @Mapping(target = "projectLatitude", source = "project.latitude")
    ProjectResponse toProjectResponse(ProjectUser projectUser);


    List<ProjectResponse> toProjectResponses(List<ProjectUser> projectUser);

    @InheritConfiguration(name = "projectUserDtoToProjectUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectUserFromProjectUserDto(ProjectUserDto projectUserDto, @MappingTarget ProjectUser projectUser);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "userUsername", source = "user.username")
    UserResponse toUserResponse(ProjectUser projectUser);


    List<UserResponse> toUserResponses(List<ProjectUser> projectUser);
}
