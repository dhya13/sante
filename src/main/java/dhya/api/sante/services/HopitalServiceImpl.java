package dhya.api.sante.services;

import dhya.api.sante.entities.Hopital;
import dhya.api.sante.repository.HopitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Component
@Service
public class HopitalServiceImpl implements HopitalService {

    @Autowired
    HopitalRepository hopRep;

    @Override
    public void createHopital(List<Hopital> Hopitals) {
        hopRep.saveAll(Hopitals);
    }

    @Override
    public Collection<Hopital> getAllHopitals() {
        return hopRep.findAll();
    }

    @Override
    public Optional<Hopital> findById(String id) {
        return hopRep.findById(id);
    }

    @Override
    public Optional<Hopital> findByName(String name) {
        return hopRep.findByName(name);
    }

    @Override
    public void deleteHopitalById(String id) {
        hopRep.deleteById(Integer.valueOf(id));
    }

    @Override
    public void updateHopital(Hopital Hopital) {
        hopRep.save(Hopital);
    }

    @Override
    public void deleteAllaHopitals() {
        hopRep.deleteAll();
    }
}
