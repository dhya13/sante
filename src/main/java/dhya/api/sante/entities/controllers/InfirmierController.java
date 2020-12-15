package dhya.api.sante.entities.controllers;


import dhya.api.sante.entities.Infirmier;
import dhya.api.sante.services.InfirmierService;
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
@RequestMapping("api/sante/infirmiers")
public class InfirmierController {

    @Autowired
    InfirmierService infirmierService;

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        infirmierService.deleteAllaInfirmiers();
        return "All Infirmiers are deleted";
    }

    @DeleteMapping("/{id}")
    public String deleteInfirmierById(@PathVariable(value = "id") String id) {
        infirmierService.deleteInfirmierById(id);
        return "User having userId == " + id + " is deleted";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Infirmier> getAll() {
        /*try {
            addInfirmier();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Collection<Infirmier> infirmiers = infirmierService.getAllInfirmiers();
        return infirmiers;
    }

    @GetMapping("/{id}")
    public Optional<Infirmier> getMedecniById(@PathVariable(value = "id") String id) {
        return infirmierService.findById(id);
    }

    @PutMapping
    public String updateInfirmier(@RequestBody Infirmier infirmier) {
        infirmierService.updateInfirmier(infirmier);
        return "user having UseId" + infirmier.getId() + " is updated";
    }

    @PostMapping
    public String addInfirmier() throws IOException {
        File file = ResourceUtils.getFile("classpath:infirmier.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<Infirmier> l = new ArrayList<>();
        while ((st = br.readLine()) != null && !"".equals(st)) {
            String [] temp = st.split(";");
            Infirmier m = new Infirmier("",temp[0],temp[1],temp[2],temp[3]);
            l.add(m);
        }

        infirmierService.createInfirmier(l);
        return "I,firmier aadded";
    }
}
