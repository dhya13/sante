package dhya.api.sante.services;

import dhya.api.sante.entities.Hopital;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface HopitalService {

    public void createHopital(List<Hopital> Hopitals);

    public Collection<Hopital> getAllHopitals();

    public Optional<Hopital> findById(String id);

    public Optional<Hopital> findByName(String name);

    public  void deleteHopitalById(String id);

    public void updateHopital(Hopital Hopital);

    public void deleteAllaHopitals();





}
