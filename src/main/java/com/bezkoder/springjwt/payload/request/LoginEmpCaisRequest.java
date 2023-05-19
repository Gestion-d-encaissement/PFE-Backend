package com.bezkoder.springjwt.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginEmpCaisRequest {
	@NotBlank
  private String username;

	@NotBlank
	private String password;
  Boolean isActiveByStatuts=false;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

  public Boolean getActiveByStatuts() {
    return isActiveByStatuts;
  }

  public void setActiveByStatuts(Boolean activeByStatuts) {
    isActiveByStatuts = activeByStatuts;
  }
}
