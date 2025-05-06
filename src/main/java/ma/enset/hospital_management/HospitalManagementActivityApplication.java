package ma.enset.hospital_management;

import ma.enset.hospital_management.entities.Patient;
import ma.enset.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalManagementActivityApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementActivityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Patient patient = new Patient();
        patient.setId(null);
        patient.setNom("Amine");
        patient.setDateNaissance(new Date());
        patient.setMalade(true);
        patient.setScore(10);

        En utilisant le constructeur avec params
        Patient patient = new Patient(null, "Amine", new Date(), true, 10);


        En utilisant Builder
        Patient patient = Patient.builder()
                .nom("Amine")
                .dateNaissance(new Date())
                .isMalade(true)
                .score(10)
                .build();


        patientRepository.save(patient);*/
//        patientRepository.save(new Patient(null, "", new Date(), true, 87));
        /*patientRepository.save(new Patient(null, "Fatima Zahra ", new Date(), false, 65));
        patientRepository.save(new Patient(null, "Omar ", new Date(), true, 72));
        patientRepository.save(new Patient(null, "Leila ", new Date(), false, 90));
        */


    }
}
