/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 3, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.haui.it.project.models.ProductDetail;
import com.haui.it.project.requests.ProDetailRequest;

public interface ProductDetailService {

	ProductDetail getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends ProductDetail> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(ProductDetail entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	boolean deleteById(Long id);

	<S extends ProductDetail> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<ProductDetail> entities);

	boolean existsById(Long id);

	<S extends ProductDetail> S saveAndFlush(S entity);

	void flush();

	<S extends ProductDetail> List<S> saveAll(Iterable<S> entities);

	Optional<ProductDetail> findById(Long id);

	List<ProductDetail> findAllById(Iterable<Long> ids);

	List<ProductDetail> findAll(Sort sort);

	Page<ProductDetail> findAll(Pageable pageable);

	List<ProductDetail> findAll();

	ProductDetail save(ProDetailRequest proDetailRequest);

	ProductDetail updateProductDetail(ProDetailRequest updateProDetail, Long id);
}
