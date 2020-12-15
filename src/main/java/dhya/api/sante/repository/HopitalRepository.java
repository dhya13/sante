package dhya.api.sante.repository;

import dhya.api.sante.entities.Hopital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HopitalRepository extends MongoRepository<Hopital, Integer> {

    Optional<Hopital> findById(String id);

    Optional<Hopital> findByName(String name);
}
