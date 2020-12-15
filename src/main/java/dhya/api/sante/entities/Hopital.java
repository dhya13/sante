package dhya.api.sante.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "hopital")
public class Hopital {

    @Id
    private String id;
    private String name;
    private String labelName;
    private String adresse;
    private String phone;

    public Hopital(String id, String name, String labelName, String adresse, String phone) {
        this.id = id;
        this.name = name;
        this.labelName = labelName;
        this.adresse = adresse;
        this.phone = phone;
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

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
