package ee.bcs.talgud.service.management;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class ProjectResponse implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private String startTime;
    private String endTime;
    private BigDecimal longitude;
    private BigDecimal latitude;
}
