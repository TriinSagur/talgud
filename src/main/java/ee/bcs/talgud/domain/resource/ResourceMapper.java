package ee.bcs.talgud.domain.resource;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceMapper {
    @Mapping(source = "projectId", target = "project.id")
    @Mapping(source = "responsibleUserId", target = "responsibleUser.id")
    Resource resourceDtoToResource(ResourceDto resourceDto);

    @InheritInverseConfiguration(name = "resourceDtoToResource")
    ResourceDto resourceToResourceDto(Resource resource);

    @InheritConfiguration(name = "resourceDtoToResource")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateResourceFromResourceDto(ResourceDto resourceDto, @MappingTarget Resource resource);
}
