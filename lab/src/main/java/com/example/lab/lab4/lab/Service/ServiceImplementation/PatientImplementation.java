package com.example.lab.lab4.lab.Service.ServiceImplementation;


import com.example.lab.lab4.lab.Entities.Patient;
import com.example.lab.lab4.lab.Repositories.PatientRepository;
import com.example.lab.lab4.lab.Service.ServiceInreface.PatientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PatientImplementation implements PatientInterface {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(long patient_id) {
            return patientRepository.findById(patient_id);
    }

    @Override
    public List<Patient> findPatientsByDateOfBirthRange(String startDate, String endDate) {
        return patientRepository.findPatientByDateOfBirthRang(startDate, endDate);
    }

    @Override
    public List<Patient> getPatientsByAdmittingEmployeeDepartment(String department) {
        return patientRepository.findByAdmittedBy_Department(department);
    }

    @Override
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientRepository.findPatientByAdmittedBy_Status("OFF");
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public String updatePatient(long patientId, Map<String, Object> patientdetails) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();

            if (patientdetails != null) {
                updatePatientAttributes(patient, patientdetails);
                // You need to save the changes to the database
                patientRepository.save(patient);
                return "PatientInfo attributes updated successfully";
            } else {
                return "PatientInfo data is null or empty.";
            }
        } else {
            return "PatientInfo not found";
        }
    }

    private void updatePatientAttributes(Patient patient, Map<String, Object> patientdetails) {
        for (Map.Entry<String, Object> entry : patientdetails.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals("newPatientName")) {
                patient.setName(value.toString());
            } else {
                throw new IllegalArgumentException("Invalid attribute: " + key);
            }
        }
    }








}
