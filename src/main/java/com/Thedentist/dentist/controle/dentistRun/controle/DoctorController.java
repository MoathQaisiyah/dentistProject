package com.Thedentist.dentist.controle.dentistRun.controle;

import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.DoctorEntity;
//import com.Thedentist.dentist.controle.dentistRun.entity.WorkingHoursEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.PatientEntity;
import com.Thedentist.dentist.controle.dentistRun.pojo.Result;

import com.Thedentist.dentist.controle.dentistRun.servese.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService DocService;
/////////////////////////////////////////////////////////////////////////////////
//    Put the value in place of the question mark (?)Number ("varchar") :
//

//    {
//        "nationalID": ?,
//            "username": "?",
//            "password": "?",
//            "name": "?",
//            "specialty": "?",
//            "email": "?",
//            "phone": ?
//    }

    @PostMapping("/addDoctor")
    public Result addDoctor(@Valid @RequestBody DoctorEntity doctor ) {

        return DocService.addOrUpdateDoctor(doctor);
    }
    /////////////////////////////////////////////////////////////////////////////////
//    Put the value in place of the question mark like (?)Number ("varchar") :

    //    {
//
//        "appointmentId" : "Put Number ID you want to Update",
//            "nationalID": ?,
//            "username": "?",
//            "password": "?",
//            "name": "?",
//            "specialty": "?",
//            "email": "?",
//            "phone": ?
//    }
    @PutMapping("/updateDoctor")
    public Result updateDoctor(@RequestBody DoctorEntity doctor) {

        return DocService.addOrUpdateDoctor(doctor);
    }


/////////////////////////////////////////////////////////////////////////////////
//    Put the value in place of the question mark like (?)Number ("varchar") :


//    {
//        "doctorOpj": {
//        "id": ?
//    },
//        "patientOpj": {
//        "id": ?
//    },
//        "appointmentTIME": "HH:mm",
//            "appointmentDATE": "dd/MM/yyyy"
//    }
    @PostMapping("/CreateAppointment")
    public Result CreateAppointment(@RequestBody AppointmentEntity Appointment ) {

        return DocService.CreateAppointmentV1(Appointment) ;
    }
////////////////////////////////////////////////////////////////////////////////////
//    Put the value in place of the question mark :
//{
//    "appointmentId": 1,
//        "Status": 0
//}

    @PutMapping("/UpdateStatusVisit")
    public Result UpdatePatientVisitedHimOrNot(@RequestBody AppointmentEntity Appointment) {


        return DocService.updateStatus(Appointment);
    }

///////////////////////////////////////////////////////////////////////////////////////
//@GetMapping("/findAllAvailableTimeByID")
//public List<WorkingHoursEntity> findAllAvailableTime(@RequestParam Integer id) {
//
//    return DocService.findAllAvailableTimeByID(id);
//}

///////////////////////////////////////////////////////////////////////////////////////
@DeleteMapping("/deleteAppointmentById")
public String deleteAppointmentById(@RequestParam Integer AppointmentId) {
    if (DocService.deleteAppointmentById(AppointmentId))
        return "Succ";
    else
        return "Failed";
}
///////////////////////////////////////////////////////////////////////////////////////
//    findAllByDate :
@GetMapping("/findAllByDateBetweenAndId")
public List<AppointmentEntity> findAllByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate start , @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate end , @RequestParam Integer doctorID ) {

    return DocService.findAllByDate(start , end ,doctorID);
}

///////////////////////////////////////////////////////////////////////////////////////
//Booked Timeline

    @GetMapping("/findBookedTimeline")
    public List<AppointmentEntity> findBookedTimeline(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {

        return DocService.findTimeAllByDate(date);
    }
///////////////////////////////////////////////////////////////////////////////////////
@GetMapping("/findAllTimeInAppointmentReserved")
public List<AppointmentEntity> findAllTimeInAppointmentReserved(@RequestParam Integer doctorID) {

    return DocService.findAllTimeInAppointmentReserved(doctorID);
}


/////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/findVisitedCountByIDdocAndPAT")
    public List<AppointmentEntity> findVisitedCountByIDdocAndPAT(@RequestParam Integer doctorID, @RequestParam Integer patientID) {

        return DocService.findVisitedCount(doctorID,patientID);
    }
/////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/seeAListOfAllPatients")
    public List<PatientEntity> seeAListOfAllPatients() {

        return DocService.findAllPatient();
    }



}

