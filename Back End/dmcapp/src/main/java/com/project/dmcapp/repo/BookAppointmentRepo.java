package com.project.dmcapp.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dmcapp.entities.BookAppointment;

public interface BookAppointmentRepo extends JpaRepository<BookAppointment, Integer>{

}
