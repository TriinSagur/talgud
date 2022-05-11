package ee.bcs.talgud.domain.projectuser;

import ee.bcs.talgud.service.management.UsersProjectResponse;
import ee.bcs.talgud.service.management.UserResponse;
import ee.bcs.talgud.util.DateUtil;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = DateUtil.class)
public interface ProjectUserMapper {

    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "userId", target = "user.id")
    ProjectUser projectUserDtoToProjectUser(ProjectUserDto projectUserDto);

    @InheritInverseConfiguration(name = "projectUserDtoToProjectUser")
    ProjectUserDto projectUserToProjectUserDto(ProjectUser projectUser);

    @Mapping(target = "projectId", source = "project.id")
    @Mapping(target = "projectName", source = "project.name")
    @Mapping(target = "projectAddress", source = "project.address")
    @Mapping(target = "projectStartTime", expression = "java(DateUtil.getFormattedDate(projectUser.getProject().getStartTime()))")
    @Mapping(target = "projectEndTime", expression = "java(DateUtil.getFormattedDate(projectUser.getProject().getEndTime()))")
    @Mapping(target = "projectLongitude", source = "project.longitude")
    @Mapping(target = "projectLatitude", source = "project.latitude")
    UsersProjectResponse toUsersProjectResponse(ProjectUser projectUser);


    List<UsersProjectResponse> toUsersProjectResponses(List<ProjectUser> projectUser);

    @InheritConfiguration(name = "projectUserDtoToProjectUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectUserFromProjectUserDto(ProjectUserDto projectUserDto, @MappingTarget ProjectUser projectUser);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "userUsername", source = "user.username")
    UserResponse toUserResponse(ProjectUser projectUser);


    List<UserResponse> toUserResponses(List<ProjectUser> projectUser);

    @Named("timestamp")
    default String timestampToDate (Instant time){
        return DateUtil.getFormattedDate(time);
    }


}
