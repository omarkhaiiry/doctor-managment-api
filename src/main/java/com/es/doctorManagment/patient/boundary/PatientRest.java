package com.es.doctorManagment.patient.boundary;


import com.es.doctorManagment.patient.control.PatientService;
import com.es.doctorManagment.patient.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRest implements PatientRestInterface {

    private PatientService patientService;

    public PatientRest() {
    }

    @Autowired
    public PatientRest(PatientService patientService) {
        this.patientService = patientService;
    }

    public List<Patient> getAllPatients(){
        return  patientService.getAllPatients();
    }

    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    public void updatePatientById(@RequestBody Patient patient){
        patientService.updatePatientById(patient);
    }

    public void removePatientById(@PathVariable Long id){
        patientService.removePatientById(id);
    }



}
