package GroupG.HMRS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class MedicationController {
    @Autowired
    private MedicationService serv;

    //Show MedicalAddition Form
    @GetMapping ("/Medical-insertion")
    public String showAddMedicalForm () {
        return "/Medical-insertion";
    }

    //Add Medicals
    @PostMapping ("/Medical-insertion")
    public String AddMedical (@ModelAttribute Medication medical){
        serv.InsertMedical(medical);
        return "redirect:/Medical-insertion";
    }

    //View Medicals
//    @GetMapping("/view")
//    public String getview (){
//        return "Medical-Lists";
//    }

    //passing the list
    @GetMapping("/medical-lists")
    public String GetAll (Model model){
        List<Medication> list = serv.GetAllMedicals();
        model.addAttribute("Medicals", list);
        return "Medical-lists";
    }



    //Show MedicalLists
//    @GetMapping ("Medical-lists")
//    public String GetAll (Model model){
//        List<Medication> list = serv.GetAllMedicals();
//        model.addAttribute("Medical", list);
//        return "Medical-Lists";
//    }
//
    //Update

    @RequestMapping("/medications/Edit/{id}")
    public String showMedicalEditionForm (@PathVariable Long id, Model model){
        Medication medical = serv.GetById(id);
        model.addAttribute("Medical", medical);
        return "Medical-Edition";
    }

    //Delete Medical
    @RequestMapping("/medications/delete/{id}")
    public String deleteMedical (@PathVariable Long id){
        serv.DeleteMedical(id);
        return "redirect:/medical-lists";

    }


}
