package com.es.doctorManagment.doctor.boundary;


import com.es.doctorManagment.doctor.control.DoctorService;
import com.es.doctorManagment.doctor.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorRest implements DoctorRestInterface {

    private DoctorService doctorService;

    public DoctorRest() {
    }

    @Autowired
    public DoctorRest(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public List<Doctor> getAllDoctors(){
        return  doctorService.getAllDoctors();
    }

    public Doctor getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
    }

    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

    public void updateDoctorById(@RequestBody Doctor doctor){
        doctorService.updateDoctorById(doctor);
    }

    public void removeDoctorById(@PathVariable Long id){
        doctorService.removeDoctorById(id);
    }
}
