package com.Thedentist.dentist.controle.dentistRun.servese;

import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.DoctorEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.PatientEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.WorkingHoursEntity;
import com.Thedentist.dentist.controle.dentistRun.pojo.Result;
import com.Thedentist.dentist.controle.dentistRun.repostry.AppointmentRepository;
import com.Thedentist.dentist.controle.dentistRun.repostry.DoctorRepository;

import com.Thedentist.dentist.controle.dentistRun.repostry.PatientRepository;
import com.Thedentist.dentist.controle.dentistRun.repostry.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repoDoc;
    @Autowired
    private AppointmentRepository repoAppointment;

    @Autowired
    private WorkingHoursRepository repoWorkingHours;

    @Autowired
    private PatientRepository repoPat;







//    The Doctor Can Update Profile: The doctors can update their profile with their password, name , and
//    their national ID, specialty, and phone number.


    public Result addOrUpdateDoctor(DoctorEntity doctor) {
        Result result0 = new Result();
        Map<String, Object> result = new HashMap<>();
        WorkingHoursEntity workingHours = new WorkingHoursEntity();
//        name:
        if (doctor.getName() == null || doctor.getName().isEmpty()) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("NameEntity", "Cannot Send Name Entity Empty");
            result0.setResult(result);
            return result0;
        }
//        national ID :
        if (doctor.getNationalID() == null || doctor.getNationalID() < 0) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("nationalID", "Cannot Send nationalID negative");
            result0.setResult(result);
            return result0;
        }
//        specialty
        if (doctor.getSpecialty() == null || doctor.getSpecialty().isEmpty()) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("specialty", "Cannot Send specialty Empty");
            result0.setResult(result);
            return result0;
        }
//        password
        if (doctor.getPassword() == null || doctor.getPassword().isEmpty()) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("password", "Cannot Send password Empty");
            result0.setResult(result);
            return result0;

        }
//        phone number:
        if (doctor.getPhone() == null || doctor.getPhone() < 0) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("phone number", "Cannot Send phone number negative");
            result0.setResult(result);
            return result0;
        }
//        Email :
        if (doctor.getEmail() == null || doctor.getEmail().isEmpty()) {

            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("phone number", "Cannot Send Email number negative");
            result0.setResult(result);
            return result0;
        }
//        username :
        if (doctor.getUsername() == null || doctor.getUsername().isEmpty()) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("phone number", "Cannot Send Email number negative");
            result0.setResult(result);
            return result0;
        }

//        ONLY FOR UPDATE NEED ID doctor:
        if (doctor.getId() != null) {
            repoDoc.save(doctor);
            result0.setStatusCode("0");
            result0.setStatusDescription("successful");
            result.put("Your profile Update is complete", "in number " + doctor.getId());
            result0.setResult(result);
            return result0;
        }

        repoDoc.save(doctor);

        int i=0;
        while (i<=9){
            workingHours.setAppointmentTIME(LocalTime.of(8 +i , 0));
            workingHours.setIddoc(doctor.getId());
            workingHours.setId(doctor.getId());
            repoWorkingHours.saveAll(List.of(workingHours));
            i++;
        }



        result0.setStatusCode("0");
        result0.setStatusDescription("successful");
        result.put("Your Doctor profile is Create", "And your ID profile is " + doctor.getId());
        result0.setResult(result);
        return result0;

    }

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//❖ The Doctor Can See All Available Time USING DATE:

    public List<AppointmentEntity> findTimeAllByDate(LocalDate date) {

        return repoAppointment.findByAllByDate(date);
    }

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


//The Doctor Can Create Appointment:
public Result CreateAppointmentV1(AppointmentEntity Appointment ) {
    Result result0 = new Result();
    Map<String, Object> result = new HashMap<>();

    if(Appointment.getAppointmentTIME()==LocalTime.of(8 , 0 )) {
        repoWorkingHours.DELETETime8(Appointment.getDoctorOpj().getId());
       }

    if(Appointment.getAppointmentTIME()==LocalTime.of(9,0)) {
        repoWorkingHours.DELETETime9(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(10,0)) {
        repoWorkingHours.DELETETime10(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(11,0)) {
        repoWorkingHours.DELETETime11(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(12,0)) {
        repoWorkingHours.DELETETime12(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(13,0)) {
        repoWorkingHours.DELETETime13(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(14,0)) {
        repoWorkingHours.DELETETime14(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(15,0)) {
        repoWorkingHours.DELETETime15(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(16,0)) {
        repoWorkingHours.DELETETime16(Appointment.getDoctorOpj().getId());
    }
    if(Appointment.getAppointmentTIME()==LocalTime.of(17,0)) {
        repoWorkingHours.DELETETime17(Appointment.getDoctorOpj().getId());
    }

    repoAppointment.save(Appointment);
    result0.setStatusCode("0");
    result0.setStatusDescription("successful");
    result.put("Your Appointment", "Created And your ID Appointment is  "+Appointment.getAppointmentId());
    result0.setResult(result);
    return result0;
}

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//The doctor can update the appointment Status

    public Result updateStatus(AppointmentEntity Appointment) {
        Result result = new Result();
        Map<String, Object> mapResult = new HashMap<>();

        if (Appointment.getAppointmentId() == null)
            if (Appointment.getStatus()==null)
                 {
                result.setStatusCode("1");
                result.setStatusDescription("error");
                mapResult.put("Status", "Can't Send Status with a number other than one and zero ");
                result.setResult(mapResult);
                return result;
            }

        repoAppointment.save(Appointment);
        result.setStatusCode("0");
        result.setStatusDescription("successful");
        result.setResult(mapResult);
        return result;
    }

    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//    The Doctor can cancel an appointment
    public Boolean deleteAppointmentById(Integer id) {
        if (id == null || id < 0)
            return false;
        repoDoc.deleteById(id);
        return true;
    }

//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//See All Available Time
//public List<WorkingHoursEntity> findAllAvailableTimeByID(Integer doctorID) {
//
//    List<WorkingHoursEntity>CHEAK= repoWorkingHours.findAvalibleTimeByID(doctorID);
//
//    return CHEAK;
//}
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//doctor can get the summary for all booked timelines :
public List<AppointmentEntity> findAllByDate(LocalDate start , LocalDate end , Integer doctorID) {
    return repoAppointment.findByDateBetween(start, end ,doctorID);
}
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//❖ The doctor can see a list of all patients
    public List<PatientEntity> findAllPatient() {

        return repoPat.DoctorVisitAccount();
    }


//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public List<AppointmentEntity> findAllTimeInAppointmentReserved(Integer doctorID) {
        if (doctorID == null || doctorID<0)
            return new ArrayList<>();
        return repoAppointment.findAllTimeReserved(doctorID);
    }


    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//❖ The patient visited count:
    public List<AppointmentEntity> findVisitedCount(Integer doctorID,Integer patientID) {
        if (doctorID == null || doctorID<0)
            return new ArrayList<>();
        return repoAppointment.ThePatientVisitedCount(doctorID,patientID);
    }

}




