package com.es.doctorManagment.managment.managers.appointment;

import com.es.doctorManagment.appointment.entity.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@RequestMapping("/manager/appointments")
public interface AppointmentManagerInterface {

    @RequestMapping
    List<Appointment> getAllAppointments();

    @RequestMapping("/{id}")
    Appointment getAppointmentById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST )
    void addAppointment(@RequestBody Appointment appointment);

    @RequestMapping(method = RequestMethod.PUT )
    void updateAppointmentById(@RequestBody Appointment appointment);

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeAppointmentById(@PathVariable Long id);

    @RequestMapping("reserve/{patientId}/{appointmentId}")
    ResponseEntity<String> reserve(@PathVariable Long patientId, @PathVariable Long appointmentId);

    @RequestMapping("doctor/{doctorId}")
    List<Appointment> getAllAppointmentsDoctorId(@PathVariable Long doctorId) ;

    }
