package ee.bcs.talgud.domain.userrole;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserRoleMapper {
    @Mapping(source = "roleId", target = "role.id")
    @Mapping(source = "userId", target = "user.id")
    UserRole userRoleDtoToUserRole(UserRoleDto userRoleDto);

    @InheritInverseConfiguration(name = "userRoleDtoToUserRole")
    UserRoleDto userRoleToUserRoleDto(UserRole userRole);

    @InheritConfiguration(name = "userRoleDtoToUserRole")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserRoleFromUserRoleDto(UserRoleDto userRoleDto, @MappingTarget UserRole userRole);
}
