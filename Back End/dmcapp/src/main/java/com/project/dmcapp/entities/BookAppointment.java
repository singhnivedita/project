package com.project.dmcapp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "Request_table")
public class BookAppointment {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
	
	@NotNull
	private Date date;
	@NotNull
	private int time;
	@NotNull
	private String remark;
	@NotNull
	private String status; 

	@NotNull
	private int pId;
	@NotNull
	private int docId;
	@NotNull
	private int serviceId;
	
}
