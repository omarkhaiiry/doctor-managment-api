package com.es.doctorManagment.patient.control;

import com.es.doctorManagment.patient.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepositoryInterface extends CrudRepository<Patient,Long>{
}
