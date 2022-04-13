/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 1, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.haui.it.project.models.OrderDetail;
import com.haui.it.project.reponsitory.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDeatailService {

	@Autowired
	private OrderDetailRepository ordersRepository;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return ordersRepository.save(entity);
	}

	@Override
	public List<OrderDetail> findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return ordersRepository.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return ordersRepository.findAll(sort);
	}

	@Override
	public List<OrderDetail> findAllById(Iterable<Long> ids) {
		return ordersRepository.findAllById(ids);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return ordersRepository.findById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
		return ordersRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		ordersRepository.flush();
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return ordersRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return ordersRepository.existsById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return ordersRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<OrderDetail> entities) {
		ordersRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return ordersRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		ordersRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		ordersRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(OrderDetail entity) {
		ordersRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		ordersRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		ordersRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		ordersRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ordersRepository.deleteAll();
	}

	@Override
	public OrderDetail getById(Long id) {
		return ordersRepository.getById(id);
	}

}
