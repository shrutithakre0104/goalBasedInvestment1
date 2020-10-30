package com.app.beans;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
public class UserBean {
	   
	private Long userId;
 
	@NotBlank(message = "User Name required and should not be blank or empty")
	@ApiModelProperty(value = "userName", required = true)
	private String userName;

	private String contactNumber;

	private String alternateContactNumber;

	private String emailAddress;

	private String address;

	private String description;

	private boolean active;

	@JsonIgnore
	private String createdBy;

	@JsonIgnore
	private Date createdDate;

	@JsonIgnore
	private String updatedBy;

	@JsonIgnore
	private Date updatedDate;
}
