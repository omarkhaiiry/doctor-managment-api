package com.es.doctorManagment.doctor.control;

import com.es.doctorManagment.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService implements DoctorServiceInterface{

    private DoctorRepositoryInterface doctorRepositoryInterface;

    @Autowired
    public DoctorService(DoctorRepositoryInterface doctorRepositoryInterface) {
        this.doctorRepositoryInterface = doctorRepositoryInterface;
    }

    public List<Doctor> getAllDoctors() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctorRepositoryInterface.findAll().forEach(doctors::add);
        return doctors;
    }

    public Doctor getDoctorById(Long doctorId){
        return doctorRepositoryInterface.findById(doctorId).orElse(null);
    }

    public void addDoctor(Doctor doctor){
        doctorRepositoryInterface.save(doctor);
    }

    public void updateDoctorById(Doctor doctor){
        doctorRepositoryInterface.save(doctor);
    }

    public void removeDoctorById(Long doctorId){
        doctorRepositoryInterface.deleteById(doctorId);
    }
}
