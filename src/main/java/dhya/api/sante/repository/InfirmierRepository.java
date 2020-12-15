package dhya.api.sante.repository;

import dhya.api.sante.entities.Infirmier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfirmierRepository extends MongoRepository<Infirmier,Integer> {

   Optional<Infirmier> findById(String id);
}
