package com.javamicroservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.javamicroservice.model.Inventory;

@EnableJpaRepositories
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

//	@Query(nativeQuery=true, value="SELECT  `quantity`, `sku_code` FROM `t_inventory` WHERE `sku_code`= ?")
//	Optional<Inventory> findBySkuCode(String skuCode);

	List<Inventory> findBySkuCodeIn(List<String> skuCode);

}
