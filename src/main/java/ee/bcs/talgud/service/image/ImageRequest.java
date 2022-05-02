package ee.bcs.talgud.service.image;

import lombok.Data;

@Data
public class ImageRequest {
    private Integer id;
    private Integer projectId;
    private String data;
}
