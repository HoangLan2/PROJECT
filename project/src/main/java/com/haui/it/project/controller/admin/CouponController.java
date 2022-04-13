/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 3, 2022 
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

import com.haui.it.project.models.Coupon;
import com.haui.it.project.reponsitory.CouponRepository;
import com.haui.it.project.requests.CouponRequest;
import com.haui.it.project.service.CouponService;

@Controller
@RequestMapping("admin/coupons")
public class CouponController {

	@Autowired
	CouponService couponService;

	@Autowired
	CouponRepository couponsRepository;

	@PostMapping(path = "coupon", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Coupon> create(@RequestBody CouponRequest newCoupon) {
		Coupon coupon = couponService.save(newCoupon);

		return new ResponseEntity<>(coupon, HttpStatus.CREATED);
	}

	// Delete Coupon by id
	@DeleteMapping(value = "/deleteCoupon/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {

		boolean isRemoved = couponService.deleteById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Coupon> updateCoupon(@PathVariable("id") Long id,
			@RequestBody CouponRequest updateCategory) {
		return new ResponseEntity<Coupon>(couponService.updateCategory(updateCategory, id),
				HttpStatus.OK);
	}

	@GetMapping("getAllCoupon")
	public ResponseEntity<List<Coupon>> getAll() {
		return new ResponseEntity<>(couponService.findAll(), HttpStatus.OK);
	}
}
