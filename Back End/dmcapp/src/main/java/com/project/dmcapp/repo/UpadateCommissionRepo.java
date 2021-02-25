package com.project.dmcapp.repo;

import com.project.dmcapp.entities.UpdateCommission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UpadateCommissionRepo extends JpaRepository <UpdateCommission, Integer> {
    
	
//	@Query("SELECT u FROM User u WHERE u.status = 1")
//	public int updateCommission(int serviceId,int commValue);
	@Query("SELECT * FROM UpdateCommission u WHERE u.diagnosticServiceId =:serviceId")
	public UpdateCommission findCommissionByService(int serviceId);
}
