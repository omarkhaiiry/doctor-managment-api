package com.es.doctorManagment.doctor.boundary;

import com.es.doctorManagment.doctor.entity.Doctor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@RequestMapping("/doctors")
public interface DoctorRestInterface {

    @RequestMapping
    List<Doctor> getAllDoctors();

    @RequestMapping("/{id}")
    Doctor getDoctorById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST )
    void addDoctor(@RequestBody Doctor doctor);

    @RequestMapping(method = RequestMethod.PUT )
    void updateDoctorById(@RequestBody Doctor doctor);

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removeDoctorById(@PathVariable Long id);
}
