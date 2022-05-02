package ee.bcs.talgud.domain.projectuser;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectUserDto implements Serializable {
    private Integer id;
    private Integer projectId;
    private Integer userId;
    private Boolean isModerator;

}
