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
//        TODO hiljem teha valideerimine et sama kasutajanimega userit pole juba olemas
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        return user.getId();
    }

    public int getUser(UserDto userDto) {
        Optional<User> user = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
        if (user.isPresent()){
            return user.get().getId();
        }
//        TODO Error message
        return -1;
    }

    public void updateUser(Integer userId, UserDto userDto) {
        User user = userRepository.getById(userId);
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.getById(userId);
        userRepository.deleteById(user.getId());
    }

    public User getUserById(Integer userId) {
        return userRepository.getById(userId);
    }

}