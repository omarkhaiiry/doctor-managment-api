package com.es.doctorManagment.managment.managers.doctor;


import com.es.doctorManagment.bundle.ConfigKeysConstants;
import com.es.doctorManagment.doctor.entity.Doctor;
import com.es.doctorManagment.managment.utilities.RestClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DoctorManager implements DoctorManagerInterface {

    private String USER_NAME = ConfigKeysConstants.USERNAME;
    private String PASSWORD = ConfigKeysConstants.PASSCODE;
    private String DOCTOR_URL = ConfigKeysConstants.DOCTOR_URL;


    public DoctorManager() {
    }



    public List<Doctor> getAllDoctors(){
        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(DOCTOR_URL, USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            List<Doctor> doctors = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Doctor.class));
            return doctors;
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
    }

    public Doctor getDoctorById(@PathVariable Long id){
        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(DOCTOR_URL + id , USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            Doctor doctor = mapper.readValue(response, Doctor.class);
            return doctor;
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
    }

    public void addDoctor(@RequestBody Doctor doctor){
        RestClient rest = new RestClient();
        String response = rest.postRequest(DOCTOR_URL, USER_NAME, PASSWORD , doctor);
    }

    public void updateDoctorById(@RequestBody Doctor doctor){
        RestClient rest = new RestClient();
        String response = rest.putRequest(DOCTOR_URL, USER_NAME, PASSWORD , doctor);
    }

    public void removeDoctorById(@PathVariable Long id){
        RestClient rest = new RestClient();
        String response = rest.deleteRequest(DOCTOR_URL + id , USER_NAME, PASSWORD );
    }
}
