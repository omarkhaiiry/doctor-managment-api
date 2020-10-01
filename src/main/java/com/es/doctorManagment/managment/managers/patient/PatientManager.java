package com.es.doctorManagment.managment.managers.patient;


import com.es.doctorManagment.bundle.ConfigKeysConstants;
import com.es.doctorManagment.managment.utilities.RestClient;
import com.es.doctorManagment.patient.entity.Patient;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PatientManager implements PatientManagerrInterface {

    private String USER_NAME = ConfigKeysConstants.USERNAME;
    private String PASSWORD = ConfigKeysConstants.PASSCODE;
    private String PATIENT_URL = ConfigKeysConstants.PATIENT_URL;


    public PatientManager() {
    }


    public List<Patient> getAllPatients(){
        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(PATIENT_URL, USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            List<Patient> patients = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Patient.class));
            return patients;
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
    }

    public Patient getPatientById(@PathVariable Long id){
        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(PATIENT_URL + id , USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            Patient patient = mapper.readValue(response, Patient.class);
            return patient;
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
    }

    public void addPatient(@RequestBody Patient patient){
        RestClient rest = new RestClient();
        String response = rest.postRequest(PATIENT_URL, USER_NAME, PASSWORD , patient);
    }

    public void updatePatientById(@RequestBody Patient patient){
        RestClient rest = new RestClient();
        String response = rest.putRequest(PATIENT_URL, USER_NAME, PASSWORD , patient);
    }

    public void removePatientById(@PathVariable Long id){
        RestClient rest = new RestClient();
        String response = rest.deleteRequest(PATIENT_URL + id , USER_NAME, PASSWORD );
    }



}
