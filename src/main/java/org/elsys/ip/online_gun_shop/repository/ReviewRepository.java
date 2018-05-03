package org.elsys.ip.online_gun_shop.repository;

import org.elsys.ip.online_gun_shop.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer> {
    public List<Reviews> findByWeaponId (Integer weaponId);
    public List<Reviews> deleteByWeaponId (Integer weaponId);

    public List<Reviews> findByUserId (Integer userId);
    public List<Reviews> deleteByUserId (Integer userId);
}
