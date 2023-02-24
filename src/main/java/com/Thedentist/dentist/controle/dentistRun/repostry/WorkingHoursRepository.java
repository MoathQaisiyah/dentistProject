package com.Thedentist.dentist.controle.dentistRun.repostry;

import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.WorkingHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;




@Transactional
@Repository
public interface WorkingHoursRepository extends JpaRepository<WorkingHoursEntity, Integer> {



    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'08:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime8(Integer iddoc) ;

    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'09:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime9(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'10:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime10(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'11:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime11(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'12:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime12(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'13:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime13(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'14:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime14(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'15:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime15(Integer iddoc) ;

    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'16:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime16(Integer iddoc) ;
    @Query(nativeQuery = true, value = "DELETE FROM workinghours WHERE time =:'17:00:00' and iddoc =:iddoc")
    List<AppointmentEntity> DELETETime17(Integer iddoc) ;



}
