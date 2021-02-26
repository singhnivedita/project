package com.project.dmcapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

@Entity
@Table(name = "admin_table")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int adminId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Size(min = 6, max = 15)
	private String password;
	
	//foreign key of role(id) table to specify role
	@ManyToOne
	@JoinColumn(name = "roleId", referencedColumnName = "roleId")
	private Role role;

	

}
