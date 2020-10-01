package com.es.doctorManagment.managment.managers.appointment;


import com.es.doctorManagment.appointment.entity.Appointment;
import com.es.doctorManagment.bundle.ConfigKeysConstants;
import com.es.doctorManagment.managment.utilities.RestClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AppointmentManager implements AppointmentManagerInterface {

    private String USER_NAME = ConfigKeysConstants.USERNAME;
    private String PASSWORD = ConfigKeysConstants.PASSCODE;
    private String APPOINTMENTS_URL = ConfigKeysConstants.APPOINTMENTS_URL;
    private String RESERVE_PATH = ConfigKeysConstants.RESERVE_PATH;
    private String DOCTOR_PATH = ConfigKeysConstants.DOCTOR_PATH;


    public AppointmentManager() {
    }

    public List<Appointment> getAllAppointments(){

        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(APPOINTMENTS_URL, USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            List<Appointment> appointments = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Appointment.class));
            return appointments;
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
    }

    public Appointment getAppointmentById(@PathVariable Long id){
        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(APPOINTMENTS_URL + id , USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            Appointment appointment = mapper.readValue(response, Appointment.class);
            return appointment;
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }    }

    public void addAppointment(@RequestBody Appointment appointment){
            RestClient rest = new RestClient();
            String response = rest.postRequest(APPOINTMENTS_URL, USER_NAME, PASSWORD , appointment);

    }

    public void updateAppointmentById(@RequestBody Appointment appointment){
        RestClient rest = new RestClient();
        String response = rest.putRequest(APPOINTMENTS_URL, USER_NAME, PASSWORD , appointment);    }

    public void removeAppointmentById(@PathVariable Long id){
        RestClient rest = new RestClient();
        String response = rest.deleteRequest(APPOINTMENTS_URL + id , USER_NAME, PASSWORD );
    }
    public ResponseEntity<String> reserve(@PathVariable Long patientId , @PathVariable Long appointmentId) {
    try{
        RestClient rest = new RestClient();
        String response = rest.getRequest(APPOINTMENTS_URL + RESERVE_PATH + patientId + "/" + appointmentId, USER_NAME, PASSWORD);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, new TypeReference<ResponseEntity<String>>(){});
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
         }

    public List<Appointment> getAllAppointmentsDoctorId(@PathVariable Long doctorId) {

        try {
            RestClient rest = new RestClient();
            String response = rest.getRequest(APPOINTMENTS_URL + DOCTOR_PATH + doctorId , USER_NAME, PASSWORD);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, Appointment.class));
        }
        catch(IOException e)
        {
            //customized exception
            return null;

        }
    }
}
