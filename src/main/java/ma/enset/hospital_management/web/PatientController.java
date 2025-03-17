package ma.enset.hospital_management.web;

import lombok.AllArgsConstructor;
import ma.enset.hospital_management.entities.Patient;
import ma.enset.hospital_management.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model){
        List<Patient> listPatients = patientRepository.findAll();
        model.addAttribute("patients", listPatients);

        return "patients";
    }


}
