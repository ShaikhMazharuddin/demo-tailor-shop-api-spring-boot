/**
 * 
 */
package com.mazzee.dts.controller;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazzee.dts.dto.User;
import com.mazzee.dts.service.UserService;
import com.mazzee.dts.utils.ApiError;
import com.mazzee.dts.utils.RecordNotFoundException;

/**
 * @author mazhar
 *
 */
@RestController
@RequestMapping("user")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/login", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public ResponseEntity<User> login(@RequestBody User user) throws RecordNotFoundException {
		ResponseEntity<User> responseEntity = null;
		Supplier<RecordNotFoundException> recordNotFoundException = () -> new RecordNotFoundException(
				new ApiError(HttpStatus.FORBIDDEN.value(), "User name / password is incorrect"));
		User loggedInUser = userService.login(user).orElseThrow(recordNotFoundException);
		responseEntity = ResponseEntity.ok().body(loggedInUser);
		return responseEntity;
	}

}