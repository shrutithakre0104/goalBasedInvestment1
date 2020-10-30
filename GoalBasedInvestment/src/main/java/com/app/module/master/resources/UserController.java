package com.app.module.master.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.beans.UserBean;
import com.app.beans.ResponseBean;
import com.app.exception.GoalBasedInvestmentException;
import com.app.module.master.service.IUserService;

import io.swagger.annotations.ApiOperation;

/**
 * @author shruti
 * @since 30 oct 2020
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@ApiOperation(value = "save user after validation", response = ResponseEntity.class)
	@PostMapping(value = "/insertUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insertUser(@Valid @RequestBody UserBean userBean) throws GoalBasedInvestmentException {
		ResponseBean responseBean = userService.insertOrUpdateUser(userBean);
		return new ResponseEntity<Object>(responseBean, HttpStatus.OK);
	}

	@ApiOperation(value = "update user after validation", response = ResponseEntity.class)
	@PutMapping(value = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUser(@Valid @RequestBody UserBean userBean) throws GoalBasedInvestmentException {
		ResponseBean responseBean = userService.insertOrUpdateUser(userBean);
		return new ResponseEntity<Object>(responseBean, HttpStatus.OK);
	}

	@GetMapping(value = "/getActiveUsers")
	public ResponseEntity<Object> getActiveUsers() throws GoalBasedInvestmentException {
		ResponseBean responseBean = userService.getActiveUsers();
		return new ResponseEntity<Object>(responseBean, HttpStatus.OK);
	}

	@GetMapping(value = "/getUsers")
	public ResponseEntity<Object> getUsers() throws GoalBasedInvestmentException {
		ResponseBean responseBean = userService.getUsers();
		return new ResponseEntity<Object>(responseBean, HttpStatus.OK);
	}
}
