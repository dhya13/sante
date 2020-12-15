package dhya.api.sante.entities.controllers;


import dhya.api.sante.entities.Hopital;
import dhya.api.sante.services.HopitalService;
import dhya.api.sante.services.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/sante/hopitals")
public class HopitalController {

    @Autowired
    HopitalService HopitalService;

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        HopitalService.deleteAllaHopitals();
        return "All Hopitals are deleted";
    }

    @DeleteMapping("/{id}")
    public String deleteHopitalById(@PathVariable(value = "id") String id) {
        HopitalService.deleteHopitalById(id);
        return "User having userId == " + id + " is deleted";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Hopital> getAll() {
        /*try {
            addHopital();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Collection<Hopital> Hopitals = HopitalService.getAllHopitals();
        return Hopitals;
    }

    @GetMapping("/{id}")
    public Optional<Hopital> getHopitalById(@PathVariable(value = "id") String id) {
        return HopitalService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Hopital> getHopitalByName(@PathVariable(value = "name") String name) {
        return HopitalService.findByName(name);
    }

    @PutMapping("/{id}")
    public String updateHopital(@PathVariable(value = "id") String id, @RequestBody Hopital Hopital) {
        Hopital.setId(id);
        HopitalService.updateHopital(Hopital);
        return "user having UseId" + Hopital.getId() + " is updated";
    }

    @PostMapping
    public String addHopital() throws IOException {
        File file = ResourceUtils.getFile("classpath:hopital.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<Hopital> l = new ArrayList<>();
        while ((st = br.readLine()) != null && !"".equals(st)) {
            String [] temp = st.split(";");
            Hopital m = new Hopital("",temp[0],temp[1],temp[2],temp[3]);
            l.add(m);
        }

        HopitalService.createHopital(l);
        return "I,firmier aadded";
    }
}
