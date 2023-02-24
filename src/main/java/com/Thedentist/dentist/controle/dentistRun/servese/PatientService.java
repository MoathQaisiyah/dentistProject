package com.Thedentist.dentist.controle.dentistRun.servese;

import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.DoctorEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.PatientEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.WorkingHoursEntity;
import com.Thedentist.dentist.controle.dentistRun.pojo.Result;
//import com.Thedentist.dentist.controle.dentistRun.pojo.WorkingHours;
import com.Thedentist.dentist.controle.dentistRun.repostry.AppointmentRepository;
import com.Thedentist.dentist.controle.dentistRun.repostry.DoctorRepository;
import com.Thedentist.dentist.controle.dentistRun.repostry.PatientRepository;
import com.Thedentist.dentist.controle.dentistRun.repostry.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PatientService {
    @Autowired
    private PatientRepository repoPat;
    @Autowired
    private AppointmentRepository repoAppointment;
    @Autowired
    private WorkingHoursRepository repoWorkingHours;
    @Autowired
    private DoctorRepository repoDoc;

    public Result addOrUpdatePatient(PatientEntity patient) {
        Result result0 = new Result();
        Map<String, Object> result = new HashMap<>();

//        name:
        if (patient.getName() == null || patient.getName().isEmpty()) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("NameEntity", "Cannot Send Name Entity Empty");
            result0.setResult(result);
            return result0;
        }
//        gender :
        if (patient.getGender() == null || patient.getGender().isEmpty()){
                result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("gender", "Can't Send gender Empty or null");
            result0.setResult(result);
            return result0;
        }
//        userNAME:
        if (patient.getUsername()== null|| patient.getUsername().isEmpty()) {
        result0.setStatusCode("1");
        result0.setStatusDescription("error");
        result.put("userName:", "Cannot Send userName Empty or null");
        result0.setResult(result);
        return result0;
    }
//        password
        if (patient.getPassword()==null || patient.getPassword().isEmpty()) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("password", "Cannot Send password Empty or null");
            result0.setResult(result);
            return result0;

        }
//        phone number:
        if (patient.getPhone() == null|| patient.getPhone() < 0) {
                result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("phone number", "Cannot Send phone number Empty or null");
            result0.setResult(result);
            return result0;
        }
//      Age:
        if (patient.getAge() == null|| patient.getAge() < 0) {
            result0.setStatusCode("1");
            result0.setStatusDescription("error");
            result.put("Age", "Cannot Send Age number Empty or null or less than 0");
            result0.setResult(result);
            return result0;
        }
//        ONLY FOR UPDATE NEED ID patient:
        if (patient.getId() != null) {
            repoPat.save(patient);
            result0.setStatusCode("0");
            result0.setStatusDescription("successful");
            result.put("Your profile Update is complete", "in ID number " + patient.getId());
            result0.setResult(result);
            return result0;
        }

        repoPat.save(patient);
        result0.setStatusCode("0");
        result0.setStatusDescription("successful");
        result.put("Your patient profile is Create", "And your ID profile is " + patient.getId());
        result0.setResult(result);
        return result0;

    }
//    ////////////////////////////////////////////////////////////////////////////////////
//❖ The Patient Can Create Appointment:
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
//////////////////////////////////////////////////////////////////////////////////////
//    ❖ The Patient can see a list of all Doctors.
public List<DoctorEntity> SeeAListOfAllDoctors() {

    return repoDoc.PatientSeeListOfAllDoctors();
}
//////////////////////////////////////////////////////////////////////////////////////
//    ❖ The Patient Can Cancel the Appointment.
public Boolean deleteAppointmentById(Integer id) {
    if (id == null || id < 0)
        return false;
    repoDoc.deleteById(id);
    return true;
}
//////////////////////////////////////////////////////////////////////////////////////
//❖ The Patient Can Show a Report To Check All Timelines in the Dentist
public List<AppointmentEntity> findAllByDate(LocalDate start , LocalDate end , Integer patientID) {
    return repoAppointment.findByDateBetweenIDPatient(start, end ,patientID);
}

//////////////////////////////////////////////////////////////////////////////////////


}
