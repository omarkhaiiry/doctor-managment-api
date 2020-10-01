package com.es.doctorManagment.doctor;


import com.es.doctorManagment.appointment.entity.Appointment;
import com.es.doctorManagment.appointment.control.AppointmentRepositoryInterface;
import com.es.doctorManagment.appointment.control.AppointmentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceImplTest
{
    @MockBean
    private AppointmentRepositoryInterface appointmentRepositoryInterface;

    @Autowired
    private AppointmentService appointmentService;

    private static Long dcctorId = 1L;
    private static Long patientId = 1L;
    private static String dateTime = "date time description";
    private static Boolean available = true;
    private static Long id = new Long(1);

    private Appointment appointmentTestObj;

    @Before
    public void setUp(){

        appointmentTestObj = new Appointment(patientId,dcctorId,dateTime,available);
        appointmentTestObj.setId(id);
        List<Appointment> allAppointments = new ArrayList<Appointment>();
        allAppointments.add(appointmentTestObj);

        Mockito.when(appointmentRepositoryInterface.findById(id)).thenReturn(java.util.Optional.ofNullable(appointmentTestObj));
    }

    @Test
    public void whenGetTopicById_thenReturnAppointment(){
        Appointment actual = appointmentService.getAppointmentById(id);

        Assert.assertNotNull(actual);
        Assert.assertEquals(id, actual.getId());
        Assert.assertEquals(dateTime, actual.getDateTime());
        Assert.assertEquals(dcctorId, actual.getDoctorId());
        Assert.assertEquals(patientId, actual.getPatientId());

    }
}
