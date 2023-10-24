package com.example.lab.lab4.lab.Entities;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="tbl_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patient_id;

    private String name;

    private Date date_of_birth;

    @ManyToOne
    @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
    private Employee admitted_by;

    public Patient() {
    }

    public Patient(long patient_id, String name, Date date_of_birth, Employee admitted_by) {
        this.patient_id = patient_id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.admitted_by = admitted_by;
    }

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Employee getAdmitted_by() {
        return admitted_by;
    }

    public void setAdmitted_by(Employee admitted_by) {
        this.admitted_by = admitted_by;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patient_id == patient.patient_id && Objects.equals(name, patient.name) && Objects.equals(date_of_birth, patient.date_of_birth) && Objects.equals(admitted_by, patient.admitted_by);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient_id, name, date_of_birth, admitted_by);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", admitted_by=" + admitted_by +
                '}';
    }
}
