package io.iamneo.task1.service;

import io.iamneo.task1.model.Patient;
import io.iamneo.task1.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(int patientId) {
        return patientRepository.findById(patientId);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(int patientId, Patient updatedPatient) {
        if (patientRepository.existsById(patientId)) {
            updatedPatient.setId(patientId);
            return patientRepository.save(updatedPatient);
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

    public void deletePatient(int patientId) {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
        } else {
            throw new RuntimeException("Patient not found");
        }
    }
}
