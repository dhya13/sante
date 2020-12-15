package dhya.api.sante.entities.controllers;


import dhya.api.sante.entities.Medecin;
import dhya.api.sante.services.MedecinService;
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
@RequestMapping("api/sante/medecins")
public class MedecinController {

    @Autowired
    MedecinService medecinService;

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        medecinService.deleteAllaMedecins();
        return "All medecins are deleted";
    }

    @DeleteMapping("/{id}")
    public String deleteMedecniById(@PathVariable(value = "id") String id) {
        medecinService.deleteMedecinById(id);
        return "User having userId == " + id + " is deleted";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Medecin> getAll() {
        /*try {
            addMedecin();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Collection<Medecin> medecins = medecinService.getAllMedecins();
        return medecins;
    }

    @GetMapping("/{id}")
    public Optional<Medecin> getMedecniById(@PathVariable(value = "id") String id) {
        return medecinService.findMedecinById(id);
    }

    @GetMapping("/hopital/{name}")
    public Collection<Medecin> getHopitalByName(@PathVariable(value = "name") String name) {
        Collection<Medecin> medecins = medecinService.getAllMedecinsByHopital(name);
        return medecins;
    }

    @PutMapping("/{id}")
    public String updateMedecin(@PathVariable(value = "id") String id, @RequestBody Medecin medecin) {
        medecin.setId(id);
        medecinService.updateMedecin(medecin);
        return "user having UseId" + medecin.getId() + " is updated";
    }

    @PostMapping("/{id}")
    public String addMedecin() throws IOException {
        File file = ResourceUtils.getFile("classpath:medecin.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<Medecin> l = new ArrayList<>();
        while ((st = br.readLine()) != null && !"".equals(st)) {
            String [] temp = st.split(";");
            Medecin m = new Medecin("",temp[0],temp[1],temp[2],temp[3]);
            //Medecin medecin = new Medecin("","SAFA","SASSI","Gynecologue","3");
            l.add(m);
        }

        medecinService.createMedecin(l);
        return "user added";
    }
}
