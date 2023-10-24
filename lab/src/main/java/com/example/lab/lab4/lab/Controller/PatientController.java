package com.example.lab.lab4.lab.Controller;


import com.example.lab.lab4.lab.Entities.Patient;
import com.example.lab.lab4.lab.Service.ServiceImplementation.PatientImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientImplementation patientImplementation;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientImplementation.getAllPatients();
    }


    @GetMapping("/patients/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable long patientId) {
        return patientImplementation.getPatientById(patientId);
    }

    @GetMapping("/patients/DoB")
    public List<Patient> getPatientsByDateOfBirthRange(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    )
    {
        return patientImplementation.findPatientsByDateOfBirthRange(startDate, endDate);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getPatientsByAdmittingEmployeeDepartment(
            @PathVariable String department) {
        return patientImplementation.getPatientsByAdmittingEmployeeDepartment(department);
    }

    @GetMapping("/patients/doctorStatus/{status}")
    public List<Patient> getPatientsWithDoctorStatusOff(@PathVariable String status) {
        return patientImplementation.getPatientsWithDoctorStatusOff();
    }

    @PostMapping("/patients/add")
    public Patient addPatient(@RequestBody @Valid Patient patient) {
        return patientImplementation.addPatient(patient);
    }

    @PatchMapping("/patients/updatePatient/{patientId}")
    public String updatePatient(@PathVariable long patientId,@RequestBody Map<String, Object> patientdetails) {
        return patientImplementation.updatePatient(patientId, patientdetails);
    }




}