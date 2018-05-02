package org.elsys.ip.online_gun_shop.repository;

import org.elsys.ip.online_gun_shop.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
}
