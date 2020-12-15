package dhya.api.sante.services;

import dhya.api.sante.entities.Hopital;
import dhya.api.sante.entities.Medecin;
import dhya.api.sante.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class MedecinServiceImpl  implements MedecinService{

     @Autowired
    MedecinRepository medRep;

    @Override
    public void createMedecin(List<Medecin> medecins) {
        medRep.saveAll(medecins);
    }

    @Override
    public Collection<Medecin> getAllMedecins() {
        return medRep.findAll();
    }

    @Override
    public Optional<Medecin> findMedecinById(String id) {
        return medRep.findById(Integer.valueOf(id));
    }

    @Override
    public void deleteMedecinById(String id) {
        medRep.deleteById(Integer.valueOf(id));
    }

    @Override
    public Collection<Medecin> getAllMedecinsByHopital(String hospital) {
        return medRep.findByHospitalId(hospital);
    }

    @Override
    public void updateMedecin(Medecin medecin) {
        medRep.save(medecin);
    }

    @Override
    public void deleteAllaMedecins() {
        medRep.deleteAll();
    }
}
