package com.es.doctorManagment.patient.control;

import com.es.doctorManagment.patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements PatientServiceInterface{

    private PatientRepositoryInterface patientRepositoryInterface;

    @Autowired
    public PatientService(PatientRepositoryInterface patientRepositoryInterface) {
        this.patientRepositoryInterface = patientRepositoryInterface;
    }

    public List<Patient> getAllPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        patientRepositoryInterface.findAll().forEach(patients::add);
        return patients;
    }

    public Patient getPatientById(Long patientId){
        return patientRepositoryInterface.findById(patientId).orElse(null);
    }

    public void addPatient(Patient patient){
        patientRepositoryInterface.save(patient);
    }

    public void updatePatientById(Patient patient){
        patientRepositoryInterface.save(patient);
    }

    public void removePatientById(Long patientId){
        patientRepositoryInterface.deleteById(patientId);
    }


}
