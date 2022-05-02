package ee.bcs.talgud.service.management;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class ProjectResponse implements Serializable {
    private Integer projectId;
    private String projectName;
    private String projectAddress;
    private Instant projectStartTime;
    private Instant projectEndTime;
    private BigDecimal projectLongitude;
    private BigDecimal projectLatitude;
}
