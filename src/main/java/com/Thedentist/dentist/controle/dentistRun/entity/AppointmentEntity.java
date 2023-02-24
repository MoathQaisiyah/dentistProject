package com.Thedentist.dentist.controle.dentistRun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer appointmentId;
    @Column(name = "Status")
    Integer Status ;

    @ManyToOne
    @JoinColumn(name = "doctorID", referencedColumnName ="id")
    DoctorEntity DoctorOpj ;

    @ManyToOne
    @JoinColumn(name = "patientID", referencedColumnName ="id")
    PatientEntity PatientOpj ;


    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    @Column(name = "appointmentTIME")
    LocalTime appointmentTIME;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @Column(name = "appointmentDATE")
    LocalDate appointmentDATE;





}
