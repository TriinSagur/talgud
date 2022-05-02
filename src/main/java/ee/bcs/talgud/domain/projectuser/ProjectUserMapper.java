package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.service.management.UserResponse;
import org.mapstruct.*;

import java.util.List;


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

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "userUsername", source = "user.username")
    UserResponse toUserResponse(ProjectUser projectUser);


    List<UserResponse> toUserResponses(List<ProjectUser> projectUser);
}
