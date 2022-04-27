package ee.bcs.talgud.talgud.domain.picture;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PictureMapper {
    @Mapping(source = "projectId", target = "project.id")
    Picture pictureDtoToPicture(PictureDto pictureDto);

    @Mapping(source = "project.id", target = "projectId")
    PictureDto pictureToPictureDto(Picture picture);

    @Mapping(source = "projectId", target = "project.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePictureFromPictureDto(PictureDto pictureDto, @MappingTarget Picture picture);
}
