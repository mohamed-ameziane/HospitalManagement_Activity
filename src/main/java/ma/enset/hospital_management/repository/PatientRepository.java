package ma.enset.hospital_management.repository;

import ma.enset.hospital_management.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
