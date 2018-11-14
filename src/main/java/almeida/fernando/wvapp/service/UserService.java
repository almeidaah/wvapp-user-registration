package almeida.fernando.wvapp.service;

import almeida.fernando.wvapp.model.Marker;
import almeida.fernando.wvapp.model.User;
import almeida.fernando.wvapp.repository.MarkerRepository;
import almeida.fernando.wvapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MarkerRepository markerRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save(User user) {
        if(Objects.nonNull(user.getId())){
            userRepository.save(user);
            return;
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Marker m = new Marker();
        m.setLatitude(-27.5973);
        m.setLongitude(-48.5499);
        m.setContent("MEU TEXTO");

        Marker m2 = new Marker();
        m2.setLatitude(-27.5973);
        m2.setLongitude(-48.5499);
        m2.setContent("MEU TEXTO M2");

        markerRepository.saveAll(Arrays.asList(m, m2));
        user.getMarkerList().addAll(Arrays.asList(m, m2));
        userRepository.insert(user);
    }

    public User loadUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUser(String userId) {
        return userRepository.findById(userId);
    }
}
