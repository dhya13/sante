package dhya.api.sante.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "infirmier")
public class Infirmier {

    @Id
    private String id;
    private String name;
    private String speciality;
    private String surname;
    private String hospitalId;

    public Infirmier(String id, String name, String surname, String speciality, String hospitalId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.hospitalId = hospitalId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
