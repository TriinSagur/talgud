package ee.bcs.talgud.domain.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    public int addNewUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return user.getId();
    }

    public int getUser(UserDto userDto) {
        Optional<User> user = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        if (user.isPresent()){
            return user.get().getId();
        }
        return -1;
    }

    public User getUserById(Integer userId) {
       return userRepository.getById(userId);
    }
}