package com.es.doctorManagment.appointment.boundary;

import com.es.doctorManagment.appointment.entity.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Omar Khairy
 *
 * this interface has all the appointments Rest configuration
 *
 */
@RequestMapping("/appointments")
public interface AppointmentRestInterface {

    /**
     * <p>this method returns all appointments </p>
     * @return a list of all appointments
     */
    @RequestMapping
    List<Appointment> getAllAppointments();

    /**
     * <p>this method returns appointment of specific id
     * </p>
     * @param id the id of the appointment
     * @return a list of appointments
     */
    @RequestMapping("/{id}")
    Appointment getAppointmentById(@PathVariable Long id);

    /**
     * <p>this method add appointment to db
     * </p>
     * @param appointment the appointment new object
     */
    @RequestMapping(method = RequestMethod.POST )
    void addAppointment(@RequestBody Appointment appointment);

    /**
     * <p>this method update appointment in db
     * </p>
     * @param appointment the appointment updated object
     */
    @RequestMapping(method = RequestMethod.PUT )
    void updateAppointmentById(@RequestBody Appointment appointment);

    /**
     * <p>this method delete appointment of specific id
     * </p>
     * @param id the id of the topic
     */
    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeAppointmentById(@PathVariable Long id);

    /**
     * <p>this method reserve for a patient with specific id a specific appointment
     * </p>
     * @param patientId the id of the patient
     * @param appointmentId  the id of the appointment
     * @return response of either appointment reserved successfully or unavailable appointment
     */
    @RequestMapping("reserve/{patientId}/{appointmentId}")
    ResponseEntity<String> reserve(@PathVariable Long patientId ,@PathVariable Long appointmentId );

    /**
     * <p>this method gets all appointments for a doctor with specific id
     * </p>
     * @param doctorId the id of the doctor
     * @return response of either appointment reserved successfully or unavailable appointment
     */
    @RequestMapping("doctor/{doctorId}")
    List<Appointment> getAllAppointmentsDoctorId(@PathVariable Long doctorId) ;

    }
