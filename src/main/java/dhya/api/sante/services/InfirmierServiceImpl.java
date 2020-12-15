package dhya.api.sante.services;

import dhya.api.sante.entities.Infirmier;
import dhya.api.sante.repository.InfirmierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class InfirmierServiceImpl implements InfirmierService{

     @Autowired
    InfirmierRepository infRep;

    @Override
    public void createInfirmier(List<Infirmier> Infirmiers) {
        infRep.saveAll(Infirmiers);
    }

    @Override
    public Collection<Infirmier> getAllInfirmiers() {
        return infRep.findAll();
    }

    @Override
    public Optional<Infirmier> findById(String id) {
        return infRep.findById(id);
    }

    @Override
    public void deleteInfirmierById(String id) {
        infRep.deleteById(Integer.valueOf(id));
    }

    @Override
    public void updateInfirmier(Infirmier Infirmier) {
        infRep.save(Infirmier);
    }

    @Override
    public void deleteAllaInfirmiers() {
        infRep.deleteAll();
    }
}
