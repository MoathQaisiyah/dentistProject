package com.Thedentist.dentist.controle.dentistRun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;

import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "workinghours")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkingHoursEntity {

        @Column(name = "id")
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id ;

//        @ManyToOne
//        @JoinColumn(name = "iddoc", referencedColumnName ="id")
        @Column(name = "iddoc")
        Integer iddoc ;

        @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
        @Column(name = "time")
        LocalTime  appointmentTIME;


}

