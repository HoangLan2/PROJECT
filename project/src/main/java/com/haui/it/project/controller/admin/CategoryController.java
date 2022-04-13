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

import com.haui.it.project.models.Category;
import com.haui.it.project.reponsitory.CategoryReponsitory;
import com.haui.it.project.requests.CategoryRequest;
import com.haui.it.project.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	CategoryReponsitory categoryReponsitory;

	// Add new category
	@PostMapping(path = "category", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> create(@RequestBody CategoryRequest newCategoryRequest) {
		Category category = categoryService.save(newCategoryRequest);

		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	// Delete category by id
	@DeleteMapping(value = "/deleteCategory/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable Long id) {

		boolean isRemoved = categoryService.deleteById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id,
			@RequestBody CategoryRequest updateCategory) {
		return new ResponseEntity<Category>(categoryService.updateCategory(updateCategory, id),
				HttpStatus.OK);
	}

	@GetMapping("getAllCategory")
	public ResponseEntity<List<Category>> getAll() {
		return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
	}

}
