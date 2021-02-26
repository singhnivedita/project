package com.project.dmcapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.UpdateCommission;

public interface UpdateCommissionRepo extends JpaRepository <UpdateCommission, Integer> {
    
	
//	@Query("SELECT u FROM User u WHERE u.status = 1")
//	public int updateCommission(int serviceId,int commValue);
	@Query("SELECT * FROM UpdateCommission u WHERE u.diagnosticServiceId =:serviceId")
	public UpdateCommission findCommissionByService(int serviceId);
}
