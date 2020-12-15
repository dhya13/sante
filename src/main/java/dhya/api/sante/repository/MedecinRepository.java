package dhya.api.sante.repository;

import dhya.api.sante.entities.Hopital;
import dhya.api.sante.entities.Medecin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface MedecinRepository extends MongoRepository<Medecin,Integer> {
    Collection<Medecin> findByHospitalId(String hospital);

    Optional<Hopital> findByName(String name);
}
