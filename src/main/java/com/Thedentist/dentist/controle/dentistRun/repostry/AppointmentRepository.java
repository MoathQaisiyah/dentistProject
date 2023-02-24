package com.Thedentist.dentist.controle.dentistRun.repostry;

import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {

    @Query(value = "SELECT e FROM AppointmentEntity e WHERE e.appointmentDATE =:date")
    List<AppointmentEntity> findByAllByDate(LocalDate date);

    @Query(value = "SELECT t FROM AppointmentEntity t WHERE t.appointmentDATE >=  :start AND t.appointmentDATE<= :end and ( doctorID =:doctorID)")
    List<AppointmentEntity> findByDateBetween( LocalDate start, LocalDate end ,Integer doctorID);

    @Query(value = "SELECT t FROM AppointmentEntity t WHERE t.appointmentDATE >=  :start AND t.appointmentDATE<= :end and ( patientID =:PatientID)")
    List<AppointmentEntity> findByDateBetweenIDPatient( LocalDate start, LocalDate end ,Integer PatientID);
    @Query(nativeQuery = true, value = "SELECT * FROM appointment WHERE  doctorID =:doctorID")
    List<AppointmentEntity> findAllTimeReserved(Integer doctorID);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM appointment WHERE Status = :0 and( doctorID =:doctorID) and (patientID =:patientID)")
    List<AppointmentEntity> ThePatientVisitedCount(Integer doctorID ,Integer patientID);



}
