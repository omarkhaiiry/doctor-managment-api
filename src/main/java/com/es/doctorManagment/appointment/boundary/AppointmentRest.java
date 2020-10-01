package com.es.doctorManagment.appointment.boundary;


import com.es.doctorManagment.appointment.control.AppointmentService;
import com.es.doctorManagment.appointment.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AppointmentRest implements AppointmentRestInterface {

    private AppointmentService appointmentService;

    public AppointmentRest() {
    }

    @Autowired
    public AppointmentRest(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public List<Appointment> getAllAppointments(){
        return  appointmentService.getAllAppointments();
    }

    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    public void updateAppointmentById(@RequestBody Appointment appointment){
        appointmentService.updateAppointmentById(appointment);
    }

    public void removeAppointmentById(@PathVariable Long id){
        appointmentService.removeAppointmentById(id);
    }
    public ResponseEntity<String> reserve(@PathVariable Long patientId , @PathVariable Long appointmentId) {

        return appointmentService.reserve(patientId , appointmentId);
    }

    public List<Appointment> getAllAppointmentsDoctorId(@PathVariable Long doctorId) {

        return appointmentService.getAllAppointmentsDoctorId(doctorId);
    }
}
