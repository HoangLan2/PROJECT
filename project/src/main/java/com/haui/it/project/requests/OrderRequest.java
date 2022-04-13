/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 5, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.requests;

import java.util.Map;

public class OrderRequest {

	private Long userId;
	private Map<Long, Integer> productIds;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Map<Long, Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(Map<Long, Integer> productIds) {
		this.productIds = productIds;
	}

}
