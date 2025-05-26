package com.acemdas.migros.locationservice.repository;

import com.acemdas.migros.locationservice.entity.CourierLocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourierLocationHistoryRepository extends JpaRepository<CourierLocationHistory, Long> {

    Optional<CourierLocationHistory> findTopByCourierIdAndStoreIdOrderByEnteredAtDesc(Long courierId, Long storeId);
}
