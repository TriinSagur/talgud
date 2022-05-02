package ee.bcs.talgud.domain.picture;

import ee.bcs.talgud.service.image.ImageResponse;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PictureMapper {

    @Mapping(target = "data", source = "data", qualifiedByName = "byteArrayToString")
    ImageResponse toResponse(Picture picture);

    List<ImageResponse> toResponses(List<Picture> pictures);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
