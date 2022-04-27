package ee.bcs.talgud.domain.task;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDto implements Serializable {
    private final Integer id;
    private final Integer projectId;
    private final Integer responsibleUserId;
    private final String name;
}
