package com.es.doctorManagment.appointment.entity;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
public class Appointment {


    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(table = "patient" ,name = "patientId")
    private Long patientId;

    @JoinColumn(table = "doctor", name = "doctorId")
    private Long doctorId;

    private String dateTime;

    private boolean available = true;

    public Appointment() {
    }

    public Appointment(Long patientId, Long doctorId, String dateTime, boolean available) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
