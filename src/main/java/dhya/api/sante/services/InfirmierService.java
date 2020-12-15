package dhya.api.sante.services;

import dhya.api.sante.entities.Infirmier;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface InfirmierService {

    public void createInfirmier(List<Infirmier> Infirmiers);

    public Collection<Infirmier> getAllInfirmiers();

    public Optional<Infirmier> findById(String id);

    public  void deleteInfirmierById(String id);

    public void updateInfirmier(Infirmier Infirmier);

    public void deleteAllaInfirmiers();





}
