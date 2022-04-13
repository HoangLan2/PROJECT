/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 3, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.haui.it.project.models.Order;
import com.haui.it.project.requests.OrderRequest;

public interface OrderService {

	Order getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Order> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Order entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<Order> entities);

	<S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Order> S saveAndFlush(S entity);

	void flush();

	<S extends Order> List<S> saveAll(Iterable<S> entities);

	Optional<Order> findById(Long id);

	List<Order> findAllById(Iterable<Long> ids);

	List<Order> findAll(Sort sort);

	Page<Order> findAll(Pageable pageable);

	List<Order> findAll();

	Order save(OrderRequest orderRequest);

	Order updateOrder(String status, Long id);
}
