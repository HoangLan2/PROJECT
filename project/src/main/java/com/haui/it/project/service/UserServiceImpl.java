/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 1, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.haui.it.project.models.User;
import com.haui.it.project.reponsitory.UserRepository;
import com.haui.it.project.requests.UserRequest;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	PasswordEncoder passwordEncoder;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}

	@Override
	public List<User> findAllById(Iterable<Long> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		userRepository.flush();
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return userRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
		return userRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<User> entities) {
		userRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		userRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		userRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		userRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

	@Override
	public User getById(Long id) {
		return userRepository.getById(id);
	}

	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public User save(UserRequest userRequest) {
		String encodePass = this.passwordEncoder.encode(userRequest.getPassword());
		User user = new User();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setEmail(userRequest.getEmail());
		user.setPassword(encodePass);
		user.setPhoto(userRequest.getPhoto());
		user.setRole(userRequest.getRole());
		userRepository.save(user);
		return user;
	}

	@Override
	public boolean deleteById(Long id) {

		boolean isRemoved = false;

		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();

		for (User element : userList) {
			if (element.getId().equals(id)) {
				userRepository.deleteById(id);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(UserRequest userRequest, Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		existingUser.setAddress(userRequest.getAddress());
		existingUser.setEmail(userRequest.getEmail());
		existingUser.setName(userRequest.getName());
		existingUser.setPassword(userRequest.getPassword());
		existingUser.setPhoto(userRequest.getPhoto());
		existingUser.setRole(userRequest.getRole());

		userRepository.save(existingUser);
		return existingUser;
	}
}
