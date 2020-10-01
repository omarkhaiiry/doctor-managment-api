package com.es.doctorManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Omar Khairy
 *
 * this class is the starting point of the application.
 */

@SpringBootApplication
public class DoctorManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorManagementApiApplication.class, args);
	}

}
