package ee.bcs.talgud.domain.resource;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceDto implements Serializable {
    private Integer id;
    private Integer projectId;
    private Integer userId;
    private String name;
}
