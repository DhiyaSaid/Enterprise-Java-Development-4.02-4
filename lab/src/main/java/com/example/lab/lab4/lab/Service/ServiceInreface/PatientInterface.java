package com.example.lab.lab4.lab.Service.ServiceInreface;

import com.example.lab.lab4.lab.Entities.Patient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PatientInterface {
    List<Patient> getAllPatients();

    Optional<Patient> getPatientById(long patientId);

    List<Patient> findPatientsByDateOfBirthRange(String startDate, String endDate);

    List<Patient> getPatientsByAdmittingEmployeeDepartment(String department);

    List<Patient> getPatientsWithDoctorStatusOff();

    Patient addPatient(Patient patient);

    String updatePatient(long patientId, Map<String, Object> patientdetails);
}
