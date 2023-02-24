package com.Thedentist.dentist.controle.dentistRun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
@Table(name = "patient")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    @NotBlank(message = "UserName cannot be null or empty")
    @Column(name = "username")
    String username ;
    @NotBlank(message = "password cannot be null or empty")
    @JsonIgnore
    @Column(name = "password")
    String password ;
    @Column(name = "name")
    String name ;
    @Column(name = "phone")
    Long phone ;
    @Min(message = "Age Cannot be less than 0", value = 0)
    @Column(name = "age")
    Integer age ;
    @Column(name = "gender")
    String gender ;

    @OneToMany(mappedBy = "PatientOpj")
    List<AppointmentEntity> appointment;


}
