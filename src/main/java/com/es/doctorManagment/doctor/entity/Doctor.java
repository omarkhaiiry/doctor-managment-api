package com.es.doctorManagment.doctor.entity;


import javax.persistence.*;

@Entity
public class Doctor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long doctorId;

        private String name;

        private String number;

        private String specialty;

        public Long getDoctorId() {
                return doctorId;
        }

        public void setDoctorId(Long doctorId) {
                this.doctorId = doctorId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getNumber() {
                return number;
        }

        public void setNumber(String number) {
                this.number = number;
        }

        public String getSpecialty() {
                return specialty;
        }

        public void setSpecialty(String specialty) {
                this.specialty = specialty;
        }


}
