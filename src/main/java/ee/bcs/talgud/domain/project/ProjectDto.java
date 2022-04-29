package ee.bcs.talgud.domain.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data

public class ProjectDto implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private Instant startTime;
    private Instant endTime;
    private BigDecimal longitude;
    private BigDecimal latitude;
}
