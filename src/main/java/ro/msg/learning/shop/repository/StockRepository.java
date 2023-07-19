package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entity.StockEntity;

import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, UUID>
{}
