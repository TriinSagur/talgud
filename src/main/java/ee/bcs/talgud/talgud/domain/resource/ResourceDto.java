package ee.bcs.talgud.talgud.domain.resource;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResourceDto implements Serializable {
    private final Integer id;
    private final Integer projectId;
    private final Integer responsibleUserId;
    private final String name;
}
