package ee.bcs.talgud.domain.task;

import lombok.Data;

import javax.validation.constraints.Null;
import java.io.Serializable;

@Data
public class TaskDto implements Serializable {
    private Integer id;
    private Integer projectId;
    private Integer userId;
    private String name;
}
