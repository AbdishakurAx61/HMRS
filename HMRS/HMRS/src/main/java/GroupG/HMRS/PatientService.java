package GroupG.HMRS;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }
    // Insert a new patient
    public void insertPatient (Patient patient){
            repo.save(patient);
    }
    //Update an existing patient
//    public void updatePatient (Patient patient){
//        repo.save(patient);
//    }

    // Delete a patient by ID
    public void deletePatient (Long id){
        repo.deleteById(id);
    }
    // Get a patient by ID
//    public Patient getPatient (Long id){
//        return repo.findById(id).orElse(null);
//    }
    //Get ALL Patients
    public List<Patient> getAllPatients (String keyword) {
        if (keyword != null)
            return repo.search(keyword);
        return repo.findAll();
    }
    //get patient
    @Transactional
    public Patient findPatientById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }


    @Transactional
    public void updatePatient(
            Long id, // ID used to find the record
            Long patientID,
            String name,
            SexCategory sexCategory,
            String address,
            String disease,
            AgeCategory ageCategory
    ) {
        Patient patient = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Update fields except ID
        patient.setPatientID(patientID);
        patient.setName(name);
        patient.setSexCategory(sexCategory);
        patient.setAddress(address);
        patient.setDisease(disease);
        patient.setAgeCategory(ageCategory);

        // Save the updated patient
        repo.save(patient); // This triggers an update because the ID is present
    }

//    public void updatePatient(
//            Long id,
//            Long patientID,
//            String name,
//            SexCategory sexCategory,
//            String address,
//            String disease,
//            AgeCategory ageCategory
//    ) {
//        Patient patient = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Patient not found"));
//        patient.setPatientID(patientID);
//        patient.setName(name);
//        patient.setSexCategory(sexCategory);
//        patient.setAddress(address);
//        patient.setDisease(disease);
//        patient.setAgeCategory(ageCategory);
//        repo.save(patient); // This triggers an update because patient has an ID
//    }
//
//    public Patient findPatientById(Long id) {
//        return repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Patient not found"));
//    }
}

