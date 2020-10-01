package com.es.doctorManagment.doctor.control;

import com.es.doctorManagment.doctor.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepositoryInterface extends CrudRepository<Doctor,Long>{
}
