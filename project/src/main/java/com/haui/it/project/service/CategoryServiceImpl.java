/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 30, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.haui.it.project.models.Category;
import com.haui.it.project.reponsitory.CategoryReponsitory;
import com.haui.it.project.reponsitory.ProductRepository;
import com.haui.it.project.requests.CategoryRequest;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryReponsitory categoryReponsitory;

	@Autowired
	ProductRepository productRepository;

	public CategoryServiceImpl(CategoryReponsitory categoriesRepository) {
		this.categoryReponsitory = categoriesRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryReponsitory.findAll();
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryReponsitory.findAll(sort);
	}

	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return categoryReponsitory.saveAll(entities);
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return categoryReponsitory.saveAndFlush(entity);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return categoryReponsitory.saveAllAndFlush(entities);
	}

	@Override
	public long count() {
		return categoryReponsitory.count();
	}

	@Override
	public void delete(Category entity) {
		categoryReponsitory.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		categoryReponsitory.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		categoryReponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryReponsitory.deleteAll();
	}

	@Override
	public Category getById(Long id) {
		return categoryReponsitory.getById(id);
	}

	@Override
	public Category save(CategoryRequest categoryRequest) {
		Category cate = new Category();
		cate.setName(categoryRequest.getName());

		categoryReponsitory.save(cate);
//		List<ProRequest> pro = categoryRequest.getPro();
//		for (ProRequest element : pro) {		
//			Product product = new Product();
//			product.setCategory(cate);
//			product.setMetal(element.getMetal());
//			product.setName(element.getName());
//			productRepository.save(product);
//		}
		return cate;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean isRemoved = false;

		List<Category> categoryList = new ArrayList<>();
		categoryList = categoryReponsitory.findAll();

		for (Category element : categoryList) {
			if (element.getId().equals(id)) {
				categoryReponsitory.deleteById(id);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	@Override
	public Category updateCategory(CategoryRequest categoryRequest, Long id) {
		Category existingCategory = categoryReponsitory.findById(id)
				.orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		existingCategory.setName(categoryRequest.getName());

		categoryReponsitory.save(existingCategory);
		return existingCategory;
	}
}
