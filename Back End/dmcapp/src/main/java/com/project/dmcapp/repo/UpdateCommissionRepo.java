package com.project.dmcapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.model.UpdateCommission;

public interface UpdateCommissionRepo extends JpaRepository <UpdateCommission, Integer> {
    
	
//	@Query("SELECT u FROM User u WHERE u.status = 1")
//	public int updateCommission(int serviceId,int commValue);
	@Query("SELECT u FROM UpdateCommission u WHERE u.diagnosticServiceId.serviceId =?1")
	public UpdateCommission findCommissionByService(int serviceId);
	
	
	@Query(value="SELECT SUM(baselineValue) from commission_table where diagnosticServiceId IN (select  dgserviceId from request_table where agentId=?1)", nativeQuery=true)
	public int findCommissionValue(int agId);

	@Query("select u from UpdateCommission u where u.commissionId=?1")
	public List<UpdateCommission> findCommById(int commId);
}
