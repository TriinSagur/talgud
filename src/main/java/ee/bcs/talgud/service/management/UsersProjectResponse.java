package ee.bcs.talgud.service.management;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UsersProjectResponse implements Serializable {
    private Integer projectId;
    private String projectName;
    private String projectAddress;
    private String projectStartTime;
    private String projectEndTime;
    private BigDecimal projectLongitude;
    private BigDecimal projectLatitude;
    private Boolean isModerator;
}
