package ee.bcs.talgud.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final String firstName;
    private final String lastName;
    private final String telephone;
    private final String email;
}
