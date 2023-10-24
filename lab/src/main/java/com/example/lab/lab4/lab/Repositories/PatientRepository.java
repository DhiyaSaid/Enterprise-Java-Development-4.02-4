package com.example.lab.lab4.lab.Repositories;

import com.example.lab.lab4.lab.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findPatientByDateOfBirthRang(String startDate, String endDate);

    List<Patient> findByAdmittedBy_Department(String department);

    List<Patient> findPatientByAdmittedBy_Status(String off);
}
