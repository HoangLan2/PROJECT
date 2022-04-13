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

import com.haui.it.project.models.OrderDetail;

public interface OrderDeatailService {

	OrderDetail getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends OrderDetail> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(OrderDetail entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<OrderDetail> entities);

	<S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends OrderDetail> S saveAndFlush(S entity);

	void flush();

	<S extends OrderDetail> List<S> saveAll(Iterable<S> entities);

	Optional<OrderDetail> findById(Long id);

	List<OrderDetail> findAllById(Iterable<Long> ids);

	List<OrderDetail> findAll(Sort sort);

	Page<OrderDetail> findAll(Pageable pageable);

	List<OrderDetail> findAll();

	<S extends OrderDetail> S save(S entity);

}
