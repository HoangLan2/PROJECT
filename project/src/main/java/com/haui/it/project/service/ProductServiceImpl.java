/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 31, 2022 
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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.haui.it.project.models.Category;
import com.haui.it.project.models.Product;
import com.haui.it.project.models.ProductDetail;
import com.haui.it.project.reponsitory.CategoryReponsitory;
import com.haui.it.project.reponsitory.ProductDetailRepository;
import com.haui.it.project.reponsitory.ProductRepository;
import com.haui.it.project.requests.ProductDetailRequest;
import com.haui.it.project.requests.ProductRequest;

@Component
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Autowired
	private CategoryReponsitory categoryReponsitory;

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

	@Override
	public List<Product> findAllById(Iterable<Long> ids) {
		return productRepository.findAllById(ids);
	}

	@Override
	public <S extends Product> List<S> saveAll(Iterable<S> entities) {
		return productRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		productRepository.flush();
	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		return productRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return productRepository.existsById(id);
	}

	@Override
	public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productRepository.findAll(example, pageable);
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		return productRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Product> entities) {
		productRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productRepository.exists(example);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		productRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		productRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		productRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends Product> entities) {
		productRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public Product getById(Long id) {
		return productRepository.getById(id);
	}

	@Override
	public Product save(ProductRequest proRequest) {
		Product pro = new Product();
		pro.setMetal(proRequest.getMetal());
		pro.setName(proRequest.getName());
		Category cate = categoryReponsitory.getById(proRequest.getCategoryId());

		pro.setCategory(cate);

		productRepository.save(pro);
		ProductDetail proDetail = new ProductDetail();
		List<ProductDetailRequest> proDetails = proRequest.getProDetails();
		for (ProductDetailRequest element : proDetails) {

			proDetail.setColor(element.getColor());
			proDetail.setOriginalprice(element.getOriginal_price());
			proDetail.setPhoto(element.getPhoto());
			proDetail.setQuanity(element.getQuanity());
			proDetail.setSize(element.getSize());
			// proDetail.setProductP(productRepository.findById(pro.getId()).get());
			proDetail.setProductP(pro);
			proDetail.setSellingPrice(element.getSelling_price());

			productDetailRepository.save(proDetail);
		}

		return pro;
	}

	@Override
	public boolean deleteById(Long id) {
		boolean isRemoved = false;
		Optional<Product> productList = productRepository.findById(id);

		List<ProductDetail> productDetailList = new ArrayList<>();
//		productDetailList = productDetailRepository.findAll();
//
//		for (ProductDetail e : productDetailList) {
//			if (e.getProductP().getId().equals(id)) {
//				productDetailRepository.deleteById(id);
//			}
//		}

		productDetailList = productDetailRepository.findByProductId(id);

		for (ProductDetail e : productDetailList) {
			productDetailRepository.delete(e);
		}
		if (productList.isPresent()) {
			productRepository.deleteById(id);
			isRemoved = true;
		}
		return isRemoved;
	}

	@Override
	public Product updateProduct(ProductRequest productRequest, Long id) {

		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		existingProduct.setCategory(categoryReponsitory.getById(productRequest.getCategoryId()));
		existingProduct.setMetal(productRequest.getMetal());
		existingProduct.setName(productRequest.getName());

		ProductDetail existingProDetail = new ProductDetail();
		List<ProductDetailRequest> proDetails = productRequest.getProDetails();
		for (ProductDetailRequest element : proDetails) {

			existingProDetail.setColor(element.getColor());
			existingProDetail.setOriginalprice(element.getOriginal_price());
			existingProDetail.setPhoto(element.getPhoto());
			existingProDetail.setQuanity(element.getQuanity());
			existingProDetail.setSize(element.getSize());
			existingProDetail.setProductP(existingProduct);
			existingProDetail.setSellingPrice(element.getSelling_price());

			productDetailRepository.save(existingProDetail);
		}

		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
