package GroupG.HMRS;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Medicals")

public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String medicalName;
    private LocalDate expiryDate;
    private Long quantity;
    private String dosage; //The amount of medication to be taken. (something like "500 mg" or "2 tablets")
    private String medicineType;// Tablet or Syrup
    private String frequency; //How medicine should be taken


    //All-argument Constructors

    public Medication(Long id, String medicalName, LocalDate expiryDate, Long quantity, String dosage, String medicineType, String frequency) {
        this.id = id;
        this.medicalName = medicalName;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.dosage = dosage;
        this.medicineType = medicineType;
        this.frequency = frequency;
    }


    //No-argument Constructor

    public Medication() {
    }


    //Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicalName() {
        return medicalName;
    }

    public void setMedicalName(String medicalName) {
        this.medicalName = medicalName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
