package com.project.dmcapp.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Data
@Entity
@Table(name = "agent_table")
public class Agent {
	//separate pk
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int agentPk;
	@NotNull
	private int agentId;
	@NotNull
	private String fName;
	@NotNull
	private String lName;
	@NotNull
	private Date dob;
	@NotNull
	private String gender;
	@NotNull
	@Column(length = 10)
	@Pattern(regexp = "^[0-9]+$")
	private String contactNumber;
	@NotNull
	@Size(min = 6, max = 15)
	private String password;
	@NotNull
	private String email;
	@NotNull
	@Column(length = 15)
	@Pattern(regexp = "^[0-9]+$")
	private String bankAccNo;
	@NotNull
	private String bankName;
	@NotNull
	private String ifsc;
	@ManyToOne
	@JoinColumn(name = "roleId", referencedColumnName = "roleId")
	private Role role;
}
