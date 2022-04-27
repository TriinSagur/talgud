package ee.bcs.talgud.domain.userrole;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleDto implements Serializable {
    private final Integer id;
    private final Integer roleId;
    private final Integer userId;
}
