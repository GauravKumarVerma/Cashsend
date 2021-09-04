package com.coop.cashsends.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.coop.cashsends.model.Role;

public interface RoleRepository  extends CrudRepository<Role, Integer>{
	
	 @Query(value = "SELECT * FROM roles where name IN (:roles)", nativeQuery = true)
	    Set<Role> find(@Param("roles") List<String> roles);

}
