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
import org.springframework.stereotype.Service;

import com.haui.it.project.models.Coupon;
import com.haui.it.project.reponsitory.CouponRepository;
import com.haui.it.project.requests.CouponRequest;

@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Page<Coupon> findAll(Pageable pageable) {
		return couponRepository.findAll(pageable);
	}

	@Override
	public List<Coupon> findAll(Sort sort) {
		return couponRepository.findAll(sort);
	}

	@Override
	public List<Coupon> findAllById(Iterable<Long> ids) {
		return couponRepository.findAllById(ids);
	}

	@Override
	public Optional<Coupon> findById(Long id) {
		return couponRepository.findById(id);
	}

	@Override
	public <S extends Coupon> List<S> saveAll(Iterable<S> entities) {
		return couponRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		couponRepository.flush();
	}

	@Override
	public <S extends Coupon> S saveAndFlush(S entity) {
		return couponRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return couponRepository.existsById(id);
	}

	@Override
	public <S extends Coupon> List<S> saveAllAndFlush(Iterable<S> entities) {
		return couponRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Coupon> entities) {
		couponRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return couponRepository.count();
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		couponRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Coupon entity) {
		couponRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		couponRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		couponRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends Coupon> entities) {
		couponRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		couponRepository.deleteAll();
	}

	@Override
	public Coupon getById(Long id) {
		return couponRepository.getById(id);
	}

	@Override
	public Coupon getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Coupon> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteById(Long id) {
		boolean isRemoved = false;

		List<Coupon> couponList = new ArrayList<>();
		couponList = couponRepository.findAll();

		for (Coupon element : couponList) {
			if (element.getId().equals(id)) {
				couponRepository.deleteById(id);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	@Override
	public Coupon save(CouponRequest couponRequest) {
		Coupon coupon = new Coupon();
		coupon.setDateFinish(couponRequest.getDateFinish());
		coupon.setDateStart(couponRequest.getDateStart());
		coupon.setDisCount(couponRequest.getDisCount());

		couponRepository.save(coupon);
		return coupon;
	}

	@Override
	public Coupon updateCategory(CouponRequest updateRequest, Long id) {
		Coupon existingCoupon = couponRepository.findById(id)
				.orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		existingCoupon.setDateFinish(updateRequest.getDateFinish());
		existingCoupon.setDateStart(updateRequest.getDateStart());
		existingCoupon.setDisCount(updateRequest.getDisCount());

		couponRepository.save(existingCoupon);
		return existingCoupon;
	}

	@Override
	public List<Coupon> findAll() {
		return couponRepository.findAll();
	}

}
