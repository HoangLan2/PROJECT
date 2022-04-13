/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 10, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.requests;

import java.util.Date;

public class CouponRequest {

	private float disCount;
	private Date dateStart;
	private Date dateFinish;

	public float getDisCount() {
		return disCount;
	}

	public void setDisCount(float disCount) {
		this.disCount = disCount;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

}
