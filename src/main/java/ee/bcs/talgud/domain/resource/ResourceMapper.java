package ee.bcs.talgud.domain.resource;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceMapper {
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Resource resourceDtoToResource(ResourceDto resourceDto);

    List<ResourceDto> resourceDtoToResource(List<Resource> resources);


    @InheritInverseConfiguration(name = "resourceDtoToResource")
    ResourceDto resourceToResourceDto(Resource resource);

    @InheritConfiguration(name = "resourceDtoToResource")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResourceFromResourceDto(ResourceDto resourceDto, @MappingTarget Resource resource);
}
