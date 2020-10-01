package com.es.doctorManagment.managment.managers.patient;

import com.es.doctorManagment.patient.entity.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@RequestMapping("/manager/patients")
public interface PatientManagerrInterface {

    @RequestMapping
    List<Patient> getAllPatients();

    @RequestMapping("/{id}")
    Patient getPatientById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST )
    void addPatient(@RequestBody Patient patient);

    @RequestMapping(method = RequestMethod.PUT )
    void updatePatientById(@RequestBody Patient patient);

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    void removePatientById(@PathVariable Long id);


}
