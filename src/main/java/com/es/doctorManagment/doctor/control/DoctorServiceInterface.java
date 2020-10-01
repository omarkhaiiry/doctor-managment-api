package com.es.doctorManagment.doctor.control;


import com.es.doctorManagment.doctor.entity.Doctor;

import java.util.List;

public interface DoctorServiceInterface {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long doctorId);
    void addDoctor(Doctor doctor);
    void updateDoctorById(Doctor doctor);
    void removeDoctorById(Long doctorId);
}
