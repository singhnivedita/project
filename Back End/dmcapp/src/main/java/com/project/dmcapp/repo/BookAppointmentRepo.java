package com.project.dmcapp.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dmcapp.entities.BookAppointment;

public interface BookAppointmentRepo extends JpaRepository<BookAppointment, Integer>{

	@Query("SELECT p FROM Patient p WHERE p.status = 1")
	public List<BookAppointment> getAppointmentStatus();
}
