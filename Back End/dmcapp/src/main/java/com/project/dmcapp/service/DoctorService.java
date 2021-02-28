package com.project.dmcapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dmcapp.dto.AuthRequestUser;
import com.project.dmcapp.dto.AuthResponseUser;
import com.project.dmcapp.exception.BookingNotFoundException;
import com.project.dmcapp.exception.UnauthorisedException;
import com.project.dmcapp.model.BookAppointment;
import com.project.dmcapp.model.Doctor;
import com.project.dmcapp.model.Role;
import com.project.dmcapp.model.TestResult;
import com.project.dmcapp.model.UpdateTreatment;
import com.project.dmcapp.repo.BookAppointmentRepo;
import com.project.dmcapp.repo.DiagnosticServiceRepo;
import com.project.dmcapp.repo.DoctorRepo;
import com.project.dmcapp.repo.PatientRepo;
import com.project.dmcapp.repo.TestResultRepo;
import com.project.dmcapp.repo.UpdateTreatmentRepo;

@Service
public class DoctorService {
	@Autowired
	PatientRepo pateintRepo;
	
	@Autowired
	DiagnosticServiceRepo diagnosisServiceRepo;
	
	@Autowired
	BookAppointmentRepo bookAppointmentRepo;
	
	@Autowired
	TestResultRepo testResultRepo;
	
	@Autowired
	UpdateTreatmentRepo updateTreatmentRepo;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	//registration
			public String doctorRegistration(Doctor doctor) {
				doctorRepo.save(doctor);
				
				return "Doctor Registration Successful";
			}
			
			//login
			@Transactional
			public AuthResponseUser loginDoctor(AuthRequestUser user) {
				
			Optional<Doctor> doctorCheck = doctorRepo.findByIdAndPassword(user.getUserId(),user.getPassword());
				if (!doctorCheck.isPresent()) {
						
					throw new UnauthorisedException();
					
				}
					Doctor doctor = doctorCheck.get();
					Role userRole = doctorCheck.get().getRole();
					
					AuthResponseUser  authResponseUser = new AuthResponseUser(doctor.getDocId(),doctor.getFirstName(),doctor.getLastName(), userRole.getRoleName(), "jwt-token");
				
				return authResponseUser;
			}	
	
	//Update Test Result by doctor based on the patient id of the patient
	public boolean updateTestResult(TestResult testResult) {
        //log.info("START");
      
       TestResult testResultOld = testResultRepo.findById(testResult.getTestId()).orElse(null);
        
       // TestResult testResultOld2 = (TestResult) testResultOld1.stream().filter(p->p.getTestId().equals(testResult.getTestId()));
        if(testResultOld == null)
            return false;
        testResultRepo.save(testResult);
      
        //log.info("END");
        return true;
    }
	
	
	//Update medical record by doctor based on the patient id of the patient
		public boolean updateTreatmentHistory(UpdateTreatment updateTreatment) {
			//log.info("START");
			UpdateTreatment updateTreatmentOld = updateTreatmentRepo.findById(updateTreatment.getTreatmentId()).orElse(null);
			//UpdateTreatment updateTreatmentOld = updateTreatmentRepo.getTreatmentHistory(updateTreatment.getPatientId().getPatientId());
			
			if(updateTreatmentOld == null)
				return false;
			
			updateTreatmentRepo.save(updateTreatment);
			//log.info("END");
			
			return true;
		}
		
		
		
		//update AppointmentStatus
				@Transactional
				public String approveAppointment(int appointmentId) {
					BookAppointment bookappointment = bookAppointmentRepo.findById(appointmentId)
							.orElseThrow(() -> new BookingNotFoundException());
					bookappointment.setStatus(true);
					bookAppointmentRepo.save(bookappointment);
					return "approved";
				}

				@Transactional
				public String rejectAppointment(int appointmentId) {
					BookAppointment appointment = bookAppointmentRepo.findById(appointmentId)
							.orElseThrow(() -> new BookingNotFoundException());
					appointment.setStatus(false);
					bookAppointmentRepo.save(appointment);
					return "rejected";
				}
				
		
		
		//treatment history - doctor
		public List<BookAppointment> getallpatientId(int doctorId){
			return bookAppointmentRepo.getallpatientId(doctorId);
		}
		
}
