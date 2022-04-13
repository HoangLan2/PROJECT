/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 3, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.haui.it.project.models.Product;
import com.haui.it.project.models.ProductDetail;
import com.haui.it.project.reponsitory.ProductDetailRepository;
import com.haui.it.project.reponsitory.ProductRepository;
import com.haui.it.project.requests.ProDetailRequest;

@Service
public class ProductDetailImpl implements ProductDetailService {

	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDetail> findAll() {
		return productDetailRepository.findAll();
	}

	@Override
	public Page<ProductDetail> findAll(Pageable pageable) {
		return productDetailRepository.findAll(pageable);
	}

	@Override
	public List<ProductDetail> findAll(Sort sort) {
		return productDetailRepository.findAll(sort);
	}

	@Override
	public List<ProductDetail> findAllById(Iterable<Long> ids) {
		return productDetailRepository.findAllById(ids);
	}

	@Override
	public Optional<ProductDetail> findById(Long id) {
		return productDetailRepository.findById(id);
	}

	@Override
	public <S extends ProductDetail> List<S> saveAll(Iterable<S> entities) {
		return productDetailRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		productDetailRepository.flush();
	}

	@Override
	public <S extends ProductDetail> S saveAndFlush(S entity) {
		return productDetailRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return productDetailRepository.existsById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<ProductDetail> entities) {
		productDetailRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return productDetailRepository.count();
	}

	@Override
	public <S extends ProductDetail> boolean exists(Example<S> example) {
		return productDetailRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		productDetailRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ProductDetail entity) {
		productDetailRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		productDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		productDetailRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends ProductDetail> entities) {
		productDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productDetailRepository.deleteAll();
	}

	@Override
	public ProductDetail getById(Long id) {
		return productDetailRepository.getById(id);
	}

	@Override
	public ProductDetail save(ProDetailRequest proDetailRequest) {
		ProductDetail proDetail = new ProductDetail();
		proDetail.setColor(proDetailRequest.getColor());
		proDetail.setOriginalprice(proDetailRequest.getOriginal_price());
		proDetail.setPhoto(proDetailRequest.getPhoto());
		proDetail.setQuanity(proDetailRequest.getQuanity());
		proDetail.setSellingPrice(proDetailRequest.getSelling_price());
		proDetail.setSize(proDetailRequest.getSize());
		Long proId = proDetailRequest.getProId();
		Product pro = productRepository.getById(proId);

		proDetail.setProductP(pro);
		productDetailRepository.save(proDetail);

		List<Product> productList = new ArrayList<Product>();
		productList = productRepository.findAll();
		for (Product element : productList) {
			if (proId == element.getId()) {
				productDetailRepository.save(proDetail);
			} else
				return null;
		}
		return proDetail;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean isRemoved = false;

		List<ProductDetail> productDetailList = new ArrayList<>();
		productDetailList = productDetailRepository.findAll();

		for (ProductDetail element : productDetailList) {
			if (element.getId().equals(id)) {
				productDetailRepository.deleteById(id);
				isRemoved = true;
			}
		}
		return isRemoved;
	}

	@Override
	public ProductDetail updateProductDetail(ProDetailRequest proDetailRequest, Long id) {
		ProductDetail existingProductDetail = productDetailRepository.findById(id)
				.orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		existingProductDetail.setColor(proDetailRequest.getColor());
		existingProductDetail.setOriginalprice(proDetailRequest.getOriginal_price());
		existingProductDetail.setPhoto(proDetailRequest.getPhoto());
		existingProductDetail.setProductP(productRepository.getById(proDetailRequest.getProId()));
		existingProductDetail.setQuanity(proDetailRequest.getQuanity());
		existingProductDetail.setSellingPrice(proDetailRequest.getSelling_price());
		existingProductDetail.setSize(proDetailRequest.getSize());

		productDetailRepository.save(existingProductDetail);
		return existingProductDetail;
	}
}
