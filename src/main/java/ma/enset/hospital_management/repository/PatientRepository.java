package ma.enset.hospital_management.repository;

import ma.enset.hospital_management.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String keyword, Pageable pageable);

    /* l'equivalence de findByNomContains
    @Query("select p from Patient p where p.nom like :keyword")
    Page<Patient> chercher(@Param("keyword") String keyword, Pageable pageable);
    */
}
