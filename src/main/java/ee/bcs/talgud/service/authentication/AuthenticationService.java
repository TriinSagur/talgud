package ee.bcs.talgud.service.authentication;

import ee.bcs.talgud.domain.user.User;
import ee.bcs.talgud.domain.user.UserDto;
import ee.bcs.talgud.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthenticationService {

    @Resource
    private UserService userService;

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
}
