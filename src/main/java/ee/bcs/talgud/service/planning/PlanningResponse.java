package ee.bcs.talgud.service.planning;

import lombok.Data;

@Data
public class PlanningResponse {
    private Integer id;
    private Integer projectId;
    private Integer userId;
    private String name;
    private String contactFirstName;
    private String contactLastName;
}
