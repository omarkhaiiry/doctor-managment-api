package com.es.doctorManagment.doctor;

import com.es.doctorManagment.appointment.entity.Appointment;
import com.es.doctorManagment.appointment.boundary.AppointmentRestInterface;
import com.es.doctorManagment.appointment.control.AppointmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(AppointmentRestInterface.class)
@AutoConfigureMockMvc(addFilters = false)
public class AppointmentRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
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
        given(appointmentService.getAllAppointments()).willReturn(allAppointments);
        given(appointmentService.getAppointmentById(id)).willReturn(appointmentTestObj);
    }


    @Test
    public void givenAppointment_whenGetAllAppointments_thenReturnJsonArray() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                .get("/appointments")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(appointmentTestObj.getId()));
    }
}
