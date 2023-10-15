package io.iamneo.task1.repository;

import io.iamneo.task1.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByName(String patientName);
}
