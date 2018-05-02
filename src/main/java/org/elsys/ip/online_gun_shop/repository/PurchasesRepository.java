package org.elsys.ip.online_gun_shop.repository;

import org.elsys.ip.online_gun_shop.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Integer> {
}
