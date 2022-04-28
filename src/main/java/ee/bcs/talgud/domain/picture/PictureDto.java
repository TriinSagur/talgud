package ee.bcs.talgud.domain.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureDto implements Serializable {
    private final Integer id;
    private final Integer projectId;
    private final byte[] data;
}
