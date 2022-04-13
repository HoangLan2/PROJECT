/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 30, 2022 
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

import com.haui.it.project.models.Product;
import com.haui.it.project.reponsitory.ProductRepository;
import com.haui.it.project.requests.ProductRequest;
import com.haui.it.project.service.CategoryService;
import com.haui.it.project.service.ProductService;

@Controller
@RequestMapping("admin/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductRepository productRepository;

	@PostMapping(path = "product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody ProductRequest newProductRequest) {
		Product product = productService.save(newProductRequest);

		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	// Delete Product by id
	@DeleteMapping(value = "/deleteProduct/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {

		boolean isRemoved = productService.deleteById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	// Update
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
			@RequestBody ProductRequest updateProduct) {
		return new ResponseEntity<Product>(productService.updateProduct(updateProduct, id),
				HttpStatus.OK);
	}

	@GetMapping("getAllProduct")
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
	}
}
