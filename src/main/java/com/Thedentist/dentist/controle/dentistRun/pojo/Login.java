package com.Thedentist.dentist.controle.dentistRun.pojo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data

public class Login {

	@NotBlank(message = "Username cannot be null or empty")
	public String username;
	
	@NotBlank(message = "Password cannot be null or empty")
	public String password;
}
