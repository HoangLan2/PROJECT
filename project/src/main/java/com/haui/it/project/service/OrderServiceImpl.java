/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 3, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.haui.it.project.contants.OrderStatus;
import com.haui.it.project.models.Order;
import com.haui.it.project.models.OrderDetail;
import com.haui.it.project.models.Product;
import com.haui.it.project.models.ProductDetail;
import com.haui.it.project.reponsitory.OrderDetailRepository;
import com.haui.it.project.reponsitory.OrderRepository;
import com.haui.it.project.reponsitory.ProductDetailRepository;
import com.haui.it.project.reponsitory.UserRepository;
import com.haui.it.project.requests.OrderRequest;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository ordersRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Autowired
	private ProductDetailRepository productDetailRepository;

	@Override
	public List<Order> findAll() {
		return ordersRepository.findAll();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return ordersRepository.findAll(pageable);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return ordersRepository.findAll(sort);
	}

	@Override
	public List<Order> findAllById(Iterable<Long> ids) {
		return ordersRepository.findAllById(ids);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return ordersRepository.findById(id);
	}

	@Override
	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
		return ordersRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		ordersRepository.flush();
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return ordersRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return ordersRepository.existsById(id);
	}

	@Override
	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
		return ordersRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<Order> entities) {
		ordersRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return ordersRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		ordersRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		ordersRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Order entity) {
		ordersRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		ordersRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		ordersRepository.deleteAllInBatch();
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		ordersRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		ordersRepository.deleteAll();
	}

	@Override
	public Order getById(Long id) {
		return ordersRepository.getById(id);
	}

	@Override
	public Order save(OrderRequest orderRequest) {
		Order order = new Order();
		order.setCreateDate(new Date());
		order.setStatus(OrderStatus.ORDERED.toString());
		order.setUser(userRepository.getById(orderRequest.getUserId()));
		ordersRepository.save(order);

		Map<Long, Integer> productIds = orderRequest.getProductIds();
		for (Map.Entry<Long, Integer> entry : productIds.entrySet()) {

//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setQuantity(entry.getValue());
			ProductDetail productDetail = productDetailRepository.getById(entry.getKey());
			Product product = productDetail.getProductP();
			orderDetail.setProduct(product);

			BigDecimal ite = BigDecimal.valueOf(entry.getValue());
			BigDecimal total = ite.multiply(productDetail.getSellingPrice());
			orderDetail.setTotalPrice(total);
			orderDetailRepository.save(orderDetail);
		}

		return order;
	}

	@Override
	public Order updateOrder(String status, Long id) {
		Order existingOrder = ordersRepository.findById(id)
				.orElseThrow(() -> new ConfigDataResourceNotFoundException(null));
		existingOrder.setStatus(status);

		ordersRepository.save(existingOrder);
		return existingOrder;
	}

}
