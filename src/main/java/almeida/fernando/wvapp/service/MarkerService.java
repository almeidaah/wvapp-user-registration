package almeida.fernando.wvapp.service;

import almeida.fernando.wvapp.model.Marker;
import almeida.fernando.wvapp.model.User;
import almeida.fernando.wvapp.repository.MarkerRepository;
import almeida.fernando.wvapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class MarkerService {

    @Autowired
    MarkerRepository markerRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Insert or update an existing marker(associated to a user)
     * //TODO Implement save(update)
     * @param userId
     * @param marker
     */
    public void save(String userId, Marker marker) {
        if(Objects.nonNull(userId)){
            Optional<User> dbUser = userRepository.findById(userId);
            if(dbUser.isPresent()){
                User user = dbUser.get();
                dbUser.get().getMarkerList().add(marker);
                markerRepository.save(marker);
                userRepository.save(user);
            }

        }
    }
}
