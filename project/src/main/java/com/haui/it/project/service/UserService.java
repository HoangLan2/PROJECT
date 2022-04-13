/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 1, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.haui.it.project.models.User;
import com.haui.it.project.requests.UserRequest;

public interface UserService {

	User getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends User> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(User entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	boolean deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<User> entities);

	<S extends User> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends User> S saveAndFlush(S entity);

	void flush();

	<S extends User> List<S> saveAll(Iterable<S> entities);

	Optional<User> findById(Long id);

	List<User> findAllById(Iterable<Long> ids);

	List<User> findAll(Sort sort);

	Page<User> findAll(Pageable pageable);

	List<User> findAll();

	User save(UserRequest userRequest);
	
	List<User> getAllUsers();
	
	User updateUser(UserRequest userRequest, Long id);
}
