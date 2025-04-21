package ma.enset.hospital_management.web;

import lombok.AllArgsConstructor;
import ma.enset.hospital_management.entities.Patient;
import ma.enset.hospital_management.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page", defaultValue = "0") int page,
                        @RequestParam(name="size", defaultValue = "4") int size,
                        @RequestParam(name="keyword", defaultValue = "") String keyword){
//        List<Patient> listPatients = patientRepository.findAll();
//        model.addAttribute("patients", listPatients);

        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients);
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/formPatients")
    public String formPatients(){
        return "formPatients";
    }

}
