package com.Thedentist.dentist.controle.dentistRun.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorEntity {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    @Column(name = "nationalID")
    Long nationalID ;
    @NotBlank(message = "UserName cannot be null or empty")
    @Column(name = "username")
    String username ;
    @NotBlank(message = "password cannot be null or empty")
    @Column(name = "password")
    String password ;
    @Column(name = "name")
    String name ;
    @Column(name = "specialty")
    String specialty ;
    @Column(name = "email")
    String email ;
    @Column(name = "phone")
    Long phone ;


    @OneToMany(mappedBy = "DoctorOpj")
    List<AppointmentEntity> appointment;


}
