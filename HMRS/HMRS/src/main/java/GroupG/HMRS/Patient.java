package GroupG.HMRS;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientID;
    private String name;
    @Enumerated(EnumType.STRING)
    private SexCategory sexCategory;
    private String address;
    private String disease;
    @Enumerated(EnumType.STRING)
    private AgeCategory ageCategory;

    //All-argument Constructors

    public Patient(Long id, Long patientID, String name, SexCategory sexCategory, String address, String disease, AgeCategory ageCategory) {
        this.id = id;
        this.patientID = patientID;
        this.name = name;
        this.sexCategory = sexCategory;
        this.address = address;
        this.disease = disease;
        this.ageCategory = ageCategory;
    }


    //No-argument Constructor

    public Patient() {
    }


    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexCategory getSexCategory() {
        return sexCategory;
    }

    public void setSexCategory(SexCategory sexCategory) {
        this.sexCategory = sexCategory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }
}

