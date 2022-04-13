/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 3, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haui.it.project.models.OrderDetail;
import com.haui.it.project.service.OrderDeatailService;

@Controller
@RequestMapping("admin/orderDetail")
public class OrderDetailController {

	@Autowired
	OrderDeatailService orderDetailService;

	@GetMapping("getAllOrderDetail")
	public ResponseEntity<List<OrderDetail>> getAll() {
		return new ResponseEntity<>(orderDetailService.findAll(), HttpStatus.OK);
	}
}
