package org.example.giftservice.repository;

import org.example.giftservice.model.GiftRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<GiftRequest, Long> {
}