package com.es.doctorManagment.appointment.control;


import com.es.doctorManagment.appointment.entity.Appointment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentServiceInterface {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    void addAppointment(Appointment appointment);
    void updateAppointmentById(Appointment appointment);
    void removeAppointmentById(Long id);
    List<Appointment> getAllAppointmentsDoctorId(Long doctorId) ;
    ResponseEntity<String> reserve(Long patientId, Long appointmentId);

}
