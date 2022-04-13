/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 30, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import com.haui.it.project.models.Category;
import com.haui.it.project.requests.CategoryRequest;

public interface CategoryService {

	Category getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Category> entities);

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Category entity);

	long count();

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> S saveAndFlush(S entity);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	List<Category> findAll(Sort sort);

	List<Category> findAll();

	static Optional<Category> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	Category save(CategoryRequest categoryRequest);

	boolean deleteById(Long id);

	Category updateCategory(CategoryRequest categoryRequest, Long id);

}
