package ma.enset.hospital_management;

import ma.enset.hospital_management.entities.Patient;
import ma.enset.hospital_management.repository.PatientRepository;
import ma.enset.hospital_management.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

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

    /*@Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager) {
        PasswordEncoder passwordEncoder = passwordEncoder();
        return args -> {
            UserDetails u1 = jdbcUserDetailsManager.loadUserByUsername("amz1");
            if(u1 == null) {
                jdbcUserDetailsManager.createUser(
                        User.withUsername("amz1").password(passwordEncoder.encode("123456")).roles("USER").build()
                );
            }
            UserDetails u2 = jdbcUserDetailsManager.loadUserByUsername("admin");
            if(u2 == null) {
                jdbcUserDetailsManager.createUser(
                        User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN", "USER").build()
                );
            }
        };
    }*/

    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
        return args -> {
            accountService.addNewRole("USER");
            accountService.addNewRole("ADMIN");
            accountService.addNewUser("amz1", "123456", "123456", "amz1@mail.com");
            accountService.addNewUser("admin", "admin", "admin", "admin@mail.com");
            accountService.affectRole("amz1", "USER");
            accountService.affectRole("admin", "USER");
            accountService.affectRole("admin", "ADMIN");
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
