package org.elsys.ip.online_gun_shop.repository;

import org.elsys.ip.online_gun_shop.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {
    public List<Favourites> findByUserId (Integer userId);
    public List<Favourites> deleteByUserId (Integer userId);
}
