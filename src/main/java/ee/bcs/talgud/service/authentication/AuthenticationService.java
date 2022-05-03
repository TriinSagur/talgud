package ee.bcs.talgud.service.authentication;

import ee.bcs.talgud.domain.contact.ContactDto;
import ee.bcs.talgud.domain.contact.ContactService;
import ee.bcs.talgud.domain.user.UserDto;
import ee.bcs.talgud.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthenticationService {

    @Resource
    private UserService userService;

    @Resource
    private ContactService contactService;

    public int addNewUser(UserDto userDto) {
        return userService.addNewUser(userDto);
    }

    public int getUser(UserDto userDto) {
        return userService.getUser(userDto);
    }

    public void updateUser(Integer userId, UserDto userDto) {
        userService.updateUser(userId, userDto);
    }

    public void deleteUser(Integer userId) {
        userService.deleteUser(userId);
    }

    public void addNewContact(ContactDto contactDto) {
        contactService.addNewContact(contactDto);
    }

    public void updateContact(ContactDto contactDto) {
        contactService.updateContact(contactDto);
    }
}
