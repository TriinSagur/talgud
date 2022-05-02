package ee.bcs.talgud.domain.contact;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private Integer id;
    private Integer userId;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
}
