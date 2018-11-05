package almeida.fernando.wvapp.service;

import almeida.fernando.wvapp.model.User;
import almeida.fernando.wvapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        if(Objects.nonNull(user.getId())){
            userRepository.save(user);
            return;
        }
        userRepository.insert(user);
    }

    public User loadUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
