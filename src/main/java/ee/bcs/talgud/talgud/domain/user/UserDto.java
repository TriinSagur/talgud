package ee.bcs.talgud.talgud.domain.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String username;
    private final String password;
}
