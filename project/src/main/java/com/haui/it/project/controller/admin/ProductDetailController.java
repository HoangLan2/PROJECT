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

import com.haui.it.project.models.ProductDetail;
import com.haui.it.project.reponsitory.ProductDetailRepository;
import com.haui.it.project.requests.ProDetailRequest;
import com.haui.it.project.service.ProductDetailService;

@Controller
@RequestMapping("admin/productDetailDetail")
public class ProductDetailController {

	@Autowired
	ProductDetailService productDetailService;

	@Autowired
	ProductDetailRepository productDetailRepository;

	@PostMapping(path = "productDetail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDetail> create(@RequestBody ProDetailRequest newProDetailRequest) {
		ProductDetail productDetail = productDetailService.save(newProDetailRequest);

		return new ResponseEntity<>(productDetail, HttpStatus.CREATED);
	}

	// Delete ProductDetail by id
	@DeleteMapping(value = "/deleteProductDetail/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {

		boolean isRemoved = productDetailService.deleteById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	// Update
	@PutMapping("/updateProductDetail/{id}")
	public ResponseEntity<ProductDetail> updateProductDetail(@PathVariable("id") Long id,
			@RequestBody ProDetailRequest updateProDetail) {
		return new ResponseEntity<ProductDetail>(
				productDetailService.updateProductDetail(updateProDetail, id), HttpStatus.OK);
	}

	@GetMapping("getAllProductDetail")
	public ResponseEntity<List<ProductDetail>> getAll() {
		return new ResponseEntity<>(productDetailService.findAll(), HttpStatus.OK);
	}
}
