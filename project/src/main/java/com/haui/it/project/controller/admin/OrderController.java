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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haui.it.project.models.Order;
import com.haui.it.project.reponsitory.OrderRepository;
import com.haui.it.project.requests.OrderRequest;
import com.haui.it.project.service.OrderService;

@Controller
@RequestMapping("admin/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@PostMapping(path = "order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> create(@RequestBody OrderRequest newOrder) {
		Order order = orderService.save(newOrder);

		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") Long id,
			@RequestBody String status) {
		return new ResponseEntity<Order>(orderService.updateOrder(status, id), HttpStatus.OK);
	}

	@GetMapping("getAllOrder")
	public ResponseEntity<List<Order>> getAll() {
		return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
	}
}
