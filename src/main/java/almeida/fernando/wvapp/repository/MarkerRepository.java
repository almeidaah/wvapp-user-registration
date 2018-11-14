package almeida.fernando.wvapp.repository;

import almeida.fernando.wvapp.model.Marker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkerRepository extends MongoRepository<Marker, String> {

}
