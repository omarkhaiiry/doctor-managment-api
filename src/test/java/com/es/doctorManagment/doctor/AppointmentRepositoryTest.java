package com.es.doctorManagment.doctor;



import com.es.doctorManagment.appointment.entity.Appointment;
import com.es.doctorManagment.appointment.control.AppointmentRepositoryInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepositoryInterface appointmentRepositoryInterface;

    private static Long dcctorId = 1L;
    private static Long patientId = 1L;
    private static String dateTime = "date time description";
    private static Boolean available = true;
    private static Long id = new Long(1);
    private Appointment appointmentTestObj;


    @Test
    public void whenFindAll_thenReturnPersistedAppointments() {
        // given
        appointmentTestObj = new Appointment(patientId,dcctorId,dateTime,available);
        entityManager.persist(appointmentTestObj);
        entityManager.flush();

        // setting Id after persisting to test auto generate
        appointmentTestObj.setId(id);

        // when
        ArrayList<Appointment> found = new ArrayList<>();
        appointmentRepositoryInterface.findAll().forEach(found::add);


        // then
        Assert.notEmpty(found ,"testing that persistence happened");
        Assert.isTrue(found.get(0).getId().equals(appointmentTestObj.getId()),"testing that id is persisted correctly");
        Assert.isTrue(found.get(0).getDateTime().equals(appointmentTestObj.getDateTime()) ,"testing that date time is persisted correctly");
        Assert.isTrue(found.get(0).getDoctorId().equals(appointmentTestObj.getDoctorId()),"testing that doctor id is persisted correctly");
    }
}
