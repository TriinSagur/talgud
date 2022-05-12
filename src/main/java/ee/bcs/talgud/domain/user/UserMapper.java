package ee.bcs.talgud.domain.user;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto dto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserDto userDto, @MappingTarget User user);
}
