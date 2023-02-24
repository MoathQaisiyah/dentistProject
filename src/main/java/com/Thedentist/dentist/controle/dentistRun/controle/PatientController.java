package com.Thedentist.dentist.controle.dentistRun.controle;



import com.Thedentist.dentist.controle.dentistRun.entity.AppointmentEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.DoctorEntity;
import com.Thedentist.dentist.controle.dentistRun.entity.PatientEntity;
import com.Thedentist.dentist.controle.dentistRun.pojo.Result;
import com.Thedentist.dentist.controle.dentistRun.servese.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
    @RequestMapping("/Patient")
public class PatientController {

        @Autowired
        private PatientService PatService;



//    Put the value in place of the question mark (?)Number ("varchar") :
//

//    {
//            "username": "?",
//            "password": "?",
//            "name": "?",
//            "phone": "?",
//            "age": "?",
//            "gender": ?
//    }

    @PostMapping("/addPatient")
    public Result addDoctor(@Valid @RequestBody PatientEntity Patient ) {

        return PatService.addOrUpdatePatient(Patient);
    }
    /////////////////////////////////////////////////////////////////////////////////
//    Put the value in place of the question mark like (?)Number ("varchar") :

    //    {
//
//        "appointmentId" : "Put Number ID you want to Update",
//            "username": "?",
//            "password": "?",
//            "name": "?",
//            "phone": "?",
//            "age": "?",
//            "gender": ?
//    }
    @PutMapping("/updatePatient")
    public Result updatePatient(@RequestBody PatientEntity Patient) {

        return PatService.addOrUpdatePatient(Patient);
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

        return PatService.CreateAppointmentV1(Appointment) ;
    }
    /////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/findAllDoctor")
    public List<DoctorEntity> findUsersByAge() {

        return PatService.SeeAListOfAllDoctors();
    }
    /////////////////////////////////////////////////////////////////////////////////
    @DeleteMapping("/deleteAppointmentById")
    public String deleteAppointmentById(@RequestParam Integer AppointmentId) {
        if (PatService.deleteAppointmentById(AppointmentId))
            return "Succ";
        else
            return "Failed";
    }
    /////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/findAllByDateBetweenAndId")
    public List<AppointmentEntity> findAllByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate start , @RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate end , @RequestParam Integer doctorID ) {

        return PatService.findAllByDate(start , end ,doctorID);
    }



    }




