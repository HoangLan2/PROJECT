/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 31, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.it.project.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
