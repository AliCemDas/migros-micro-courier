package com.acemdas.migros.courierservice.repository;

import com.acemdas.migros.courierservice.entity.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

}
