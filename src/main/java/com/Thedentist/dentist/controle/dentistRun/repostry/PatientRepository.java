package com.Thedentist.dentist.controle.dentistRun.repostry;

import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

    @Query(nativeQuery = true, value = "select name,phone,age,gender from patient ")
    List<PatientEntity> DoctorVisitAccount();



}
