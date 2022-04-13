/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 1, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haui.it.project.models.User;
import com.haui.it.project.reponsitory.UserRepository;
import com.haui.it.project.requests.UserRequest;
import com.haui.it.project.service.UserService;

@Controller
@RequestMapping("admin/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping(path = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@RequestBody UserRequest newuserRequest) {
		User user = userService.save(newuserRequest);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/deleteUser/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {

		boolean isRemoved = userService.deleteById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
			@RequestBody UserRequest updateUser) {
		return new ResponseEntity<User>(userService.updateUser(updateUser, id), HttpStatus.OK);
	}

	@GetMapping("getAllUser")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}
}
