/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 1, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haui.it.project.models.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

	@Query(value = "SELECT * FROM ProductDetail p WHERE p.product_id = :productId", nativeQuery = true)
	List<ProductDetail> findByProductId(@Param("productId") Long productId);

}
