package GroupG.HMRS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:keyword% OR p.disease LIKE %:keyword%")
    List<Patient> search(@Param("keyword") String keyword);

}
