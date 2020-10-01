package com.es.doctorManagment.appointment.control;


import com.es.doctorManagment.appointment.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface{

    private AppointmentRepositoryInterface appointmentRepositoryInterface;

    @Autowired
    public AppointmentService(AppointmentRepositoryInterface appointmentRepositoryInterface) {
        this.appointmentRepositoryInterface = appointmentRepositoryInterface;
    }

    public List<Appointment> getAllAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        appointmentRepositoryInterface.findAll().forEach(appointments::add);
        return appointments;
    }

    public Appointment getAppointmentById(Long id){
        return appointmentRepositoryInterface.findById(id).orElse(null);
    }

    public void addAppointment(Appointment appointment){
        appointmentRepositoryInterface.save(appointment);
    }

    public void updateAppointmentById(Appointment appointment){
        appointmentRepositoryInterface.save(appointment);
    }

    public void removeAppointmentById(Long id){
        appointmentRepositoryInterface.deleteById(id);
    }

    public List<Appointment> getAllAppointmentsDoctorId(Long doctorId) {
        ArrayList<Appointment> appointments = new ArrayList<>();

        //finding all then filtering with doctorId
        appointmentRepositoryInterface.findAll().forEach(appointment -> {
            if(appointment.getDoctorId().equals(doctorId))
            {
                appointments.add(appointment);
            }
        });
        return appointments;
    }

    public ResponseEntity<String> reserve(Long patientid , Long appointmentId) {

        Appointment appointment = getAppointmentById(appointmentId);

        //checking if the appointment available
        if(appointment != null  && appointment.isAvailable()) {
            appointment.setAvailable(false);
            appointment.setPatientId(patientid);
            updateAppointmentById(appointment);
            return new ResponseEntity<>("Appointment is reserved succesfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Appointment is not available", HttpStatus.NOT_ACCEPTABLE);
    }
}
