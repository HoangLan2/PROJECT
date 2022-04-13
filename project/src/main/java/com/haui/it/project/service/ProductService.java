/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 31, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.haui.it.project.models.Product;
import com.haui.it.project.requests.ProductRequest;

public interface ProductService {

	Product getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Product> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Product entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	boolean deleteById(Long id);

	<S extends Product> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Product> entities);

	<S extends Product> long count(Example<S> example);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	List<Product> findAll();

	List<Product> findAllById(Iterable<Long> ids);

	List<Product> findAll(Sort sort);

	Page<Product> findAll(Pageable pageable);

	Product save(ProductRequest productRequest);

	Product updateProduct(ProductRequest productRequest, Long id);

}
