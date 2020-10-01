package com.es.doctorManagment.patient.control;


import com.es.doctorManagment.patient.entity.Patient;

import java.util.List;

public interface PatientServiceInterface {
    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    void addPatient(Patient patient);
    void updatePatientById(Patient patient);
    void removePatientById(Long patientId);
}
