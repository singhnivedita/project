package com.project.dmcapp.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.dmcapp.model.UpdateTreatment;



public interface UpdateTreatmentRepo extends JpaRepository<UpdateTreatment, Integer>{
	
	//display treatment history according to patient id 
	//(view by doctor or patient itself on the basis of id of patient)
<<<<<<< Updated upstream
		@Query("Select * FROM UpdateTreatment u WHERE u.patientId :patientId")
	    public List<UpdateTreatment> getTreatmentHistory(int patientId);
=======
		@Query("Select * FROM UpdateTreatment u WHERE u.patientId =:patientId")
	    public UpdateTreatment getTreatmentHistory(int patientId);
>>>>>>> Stashed changes
}
