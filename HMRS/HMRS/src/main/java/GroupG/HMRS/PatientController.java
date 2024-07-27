package GroupG.HMRS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Home page
    @GetMapping("/")
    public String homePage() {
        return "Home Page";
    }
    //Show Add Patient form
    @GetMapping("/add-patient")
    public String showAddPatientForm() {
        return "add-patient"; // Return the view name
    }
    // Add a new patient
    @PostMapping("/add-patient")
    public String addPatient(@ModelAttribute Patient patient) {
        patientService.insertPatient(patient);
        return "add-patient";
    }
    //Show View Patients Form
    @GetMapping ("/view")
    public String showPatient_List () {
        return "list-patients";
    }
    // Get the patient lists
    @GetMapping ("/PatientList")
    public String getAll (Model model, @Param("keyword") String keyword) {
        List <Patient> list = patientService.getAllPatients(keyword);
        model.addAttribute("Patient", list);
        model.addAttribute("keyword", keyword);
        return "list-patients";
    }
    // Delete a patient
    @RequestMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/PatientList";
    }

    //Retrieving a patient
    @GetMapping("/Edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Patient patient = patientService.findPatientById(id);
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    //Updating a patient
    @PutMapping("/{id}")
    public String updatePatient(
            @PathVariable Long id,
            @RequestParam Long patientIDEdit,
            @RequestParam String nameEdit,
            @RequestParam SexCategory sexCategoryEdit,
            @RequestParam String addressEdit,
            @RequestParam String diseaseEdit,
            @RequestParam AgeCategory ageCategoryEdit
    ) {
        patientService.updatePatient(id, patientIDEdit, nameEdit, sexCategoryEdit, addressEdit, diseaseEdit, ageCategoryEdit);
        return "redirect:/PatientList";
    }













//    @GetMapping("/Edit/{id}")
//    public String showUpdateForm(@PathVariable Long id, Model model) {
//        Patient patient = patientService.findPatientById(id);
//        model.addAttribute("patient", patient);
//        return "edit-patient";
//    }
//
//    @PutMapping("/{id}")
//    public String updatePatient(
//            @PathVariable Long id,
//            @RequestParam Long patientID,
//            @RequestParam String name,
//            @RequestParam SexCategory sexCategory,
//            @RequestParam String address,
//            @RequestParam String disease,
//            @RequestParam AgeCategory ageCategory
//    ) {
//        patientService.updatePatient(id, patientID, name, sexCategory, address, disease, ageCategory);
//        return "redirect:/patients"; // Redirect to patient list or detail page after update
//    }








//     edit patient
//    @RequestMapping("/Edit/{id}")
//    public String showEditPatientForm(@PathVariable() Long id, Model model) {
//        Patient patient = patientService.getPatient(id);
//        model.addAttribute("Patients", patient);
//        return "edit-patient";
//    }///////////////////////////////



//     @RequestMapping(value = "/Edit/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
//    public String Update(Patient patient){
//        patientService.updatePatient(patient);
//        return "PatientList";
//    }


//@GetMapping("/edit-patient/{id}")
//public String showEditPatientForm(@PathVariable("id") Long id, Model model) {
//    Patient patient = patientService.getPatient(id);
//    model.addAttribute("patient", patient);
//    return "edit-patient";
//}
//    // Update a patient
//    @RequestMapping("/Edit/{id}")
//    public String updatePatient(@ModelAttribute("Patients") Patient patient) {
//        patientService.updatePatient(patient);
////        return "redirect:/PatientList";
//        return "edit-patient";
//    }


//@GetMapping("/Edit/{id}")
//public String showEditForm(@PathVariable("id") Long id, Model model) {
//    Patient patient = patientService.getPatient(id);
//    model.addAttribute("Patients", patient);
//    return "edit-patient";
//}


//    @RequestMapping("/Edit/{id}")
//    public String updatePatient(@PathVariable("id") Long id, @ModelAttribute("Patients") Patient patient) {
//        Patient existingPatient = patientService.getPatient(id);
//        // Update the fields with the new values
//            existingPatient.setPatientID(existingPatient.getPatientID());
//            existingPatient.setName(existingPatient.getName());
//            existingPatient.setSexCategory(existingPatient.getSexCategory());
//            existingPatient.setAddress(existingPatient.getAddress());
//            existingPatient.setDisease(existingPatient.getDisease());
//            existingPatient.setAgeCategory(existingPatient.getAgeCategory());
//        // Update other fields as necessary
//        patientService.insertPatient(existingPatient);
//        return "redirect:/edit-patient";
//    }
    //Update
//    @RequestMapping("/Edit/{id}")
//    public String updatePatient(@RequestBody Patient patient, @PathVariable("id") Long id, Model model) {
////        Patient patient = patientService.getPatient(id);
//        Patient existingPatient = patientService.getPatient(id);//find the item to update
//        model.addAttribute("Patients", existingPatient);
//        if (existingPatient != null) {
//            existingPatient.setPatientID(existingPatient.getPatientID());
//            existingPatient.setName(existingPatient.getName());
//            existingPatient.setSexCategory(existingPatient.getSexCategory());
//            existingPatient.setAddress(existingPatient.getAddress());
//            existingPatient.setDisease(existingPatient.getDisease());
//            existingPatient.setAgeCategory(existingPatient.getAgeCategory());//update them
//        } else {
//            existingPatient.setId(id);
//            patientService.insertPatient(existingPatient);
//
//        }
//        return "edit-patient";
//    }

            // Update other fields
           //save them


//
//
//    @PutMapping("/edit-patient")
//    public String updatePatient(@ModelAttribute Patient patient) {
//        patientService.updatePatient(patient);
//        return "redirect:/PatientList";
//    }


}

