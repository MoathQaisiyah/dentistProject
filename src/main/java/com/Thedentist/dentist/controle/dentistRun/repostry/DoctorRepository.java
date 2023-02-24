package com.Thedentist.dentist.controle.dentistRun.repostry;

import com.Thedentist.dentist.controle.dentistRun.entity.DoctorEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {


    @Query(nativeQuery = true, value = "select name,specialty,email,phone from doctor")
    List<DoctorEntity> PatientSeeListOfAllDoctors();
}
