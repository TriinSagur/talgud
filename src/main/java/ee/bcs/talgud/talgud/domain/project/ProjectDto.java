package ee.bcs.talgud.talgud.domain.project;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class ProjectDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String address;
    private final Instant startTime;
    private final Instant endTime;
    private final BigDecimal longitude;
    private final BigDecimal latitude;
}
