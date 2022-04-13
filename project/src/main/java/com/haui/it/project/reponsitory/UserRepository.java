/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 1, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.it.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
