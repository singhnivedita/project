package com.project.dmcapp.model;


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
@Table(name = "secretQuestion_table")
public class SecretQuestion {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int secretid;
	@NotNull
	private String question;

}
