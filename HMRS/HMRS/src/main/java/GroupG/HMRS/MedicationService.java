package GroupG.HMRS;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {
    private final MedicationRepository repo;

    public MedicationService(MedicationRepository repo) {
        this.repo = repo;
    }


    //Insert a Medical
    public void InsertMedical (Medication medical) {
        repo.save(medical);
    }

    //Update a Medical
    public void UpdateMedical (Medication medical){
        repo.save(medical);
    }
    
    //Delete a Medical
    public void DeleteMedical (Long id) {
        repo.deleteById(id);
    }
    //GetBYId a Medical
    public Medication GetById (Long id){
       return repo.findById(id).orElse(null);
    }
    
    //GetAll of Medicals
    public List<Medication> GetAllMedicals (){
        return repo.findAll();
    }
}
