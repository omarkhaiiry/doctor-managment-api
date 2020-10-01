package com.es.doctorManagment.appointment.control;

import com.es.doctorManagment.appointment.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepositoryInterface extends CrudRepository<Appointment,Long>{
}
