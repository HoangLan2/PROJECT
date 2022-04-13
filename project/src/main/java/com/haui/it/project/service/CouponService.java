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

import com.haui.it.project.models.Coupon;
import com.haui.it.project.requests.CouponRequest;

public interface CouponService {

	Coupon getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Coupon> entities);

	Coupon getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Coupon entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	boolean deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<Coupon> entities);

	void deleteInBatch(Iterable<Coupon> entities);

	<S extends Coupon> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Coupon> S saveAndFlush(S entity);

	void flush();

	<S extends Coupon> List<S> saveAll(Iterable<S> entities);

	Optional<Coupon> findById(Long id);

	List<Coupon> findAllById(Iterable<Long> ids);

	List<Coupon> findAll(Sort sort);

	Page<Coupon> findAll(Pageable pageable);

	List<Coupon> findAll();

	Coupon save(CouponRequest couponRequest);

	Coupon updateCategory(CouponRequest updateRequest, Long id);

}
