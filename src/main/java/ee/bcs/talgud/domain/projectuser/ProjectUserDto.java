package ee.bcs.talgud.domain.projectuser;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectUserDto implements Serializable {
    private final Integer id;
    private final Integer projectId;
    private final Integer userId;
    private final Boolean isModerator;
}
