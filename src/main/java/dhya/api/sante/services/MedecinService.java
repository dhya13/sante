package dhya.api.sante.services;

import dhya.api.sante.entities.Hopital;
import dhya.api.sante.entities.Medecin;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface MedecinService {

    public void createMedecin(List<Medecin> medecins);

    public Collection<Medecin> getAllMedecins();

    public Optional<Medecin> findMedecinById(String id);

    public  void deleteMedecinById(String id);

    Collection<Medecin> getAllMedecinsByHopital(String name);

    public void updateMedecin(Medecin medecin);

    public void deleteAllaMedecins();





}
