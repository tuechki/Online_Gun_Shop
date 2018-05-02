package org.elsys.ip.online_gun_shop.repository;

import org.elsys.ip.online_gun_shop.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
}
