package org.elsys.ip.online_gun_shop.services;

import org.elsys.ip.online_gun_shop.exception.ResourceNotFoundException;
import org.elsys.ip.online_gun_shop.model.Reviews;
import org.elsys.ip.online_gun_shop.model.Weapon;
import org.elsys.ip.online_gun_shop.repository.ReviewRepository;
import org.elsys.ip.online_gun_shop.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    private final ReviewRepository reviewRepository;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository, ReviewRepository reviewRepository) {
        this.weaponRepository = weaponRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Weapon> getAllWeapons() {
        return this.weaponRepository.findAll();
    }

    public Weapon createWeapon(Weapon w) {
        return this.weaponRepository.save(w);
    }

    public Weapon getWeaponById(Integer id) {
        return this.weaponRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Weapon with id = "
                    + String.valueOf(id) + "not found")
        );
    }

    public Weapon updateWeapon(Integer id, Weapon w) {
        Weapon foundWeapon = getWeaponById(id);

        return this.weaponRepository.save(ServiceUtil.updateFields(w, foundWeapon));
    }

    public void deleteWeaponById(Integer id) {
        this.weaponRepository.deleteById(id);
    }

    public Reviews getWeaponReviewById(Integer weaponId, Integer reviewId) {
        Weapon weapon = getWeaponById(weaponId);

        return matchReviewById(weapon, reviewId);
    }

    public Reviews createWeaponReview(Integer weaponId, Reviews review) {
        Weapon weapon = getWeaponById(weaponId);

        review.setWeapon(weapon);

        review = reviewRepository.save(review);

        weapon.getReviews().add(review);

        weaponRepository.save(weapon);

        return review;
    }

    public Reviews updateWeaponReviewById(Integer weaponId, Integer reviewId, Reviews review) {
        Weapon weapon = getWeaponById(weaponId);

        Reviews matchedReview = matchReviewById(weapon, reviewId);

        return this.reviewRepository.save(ServiceUtil.updateFields(review, matchedReview));
    }

    public List<Reviews> getWeaponReviews(Integer weaponId) {
        return reviewRepository.findByWeaponId(weaponId);
    }

    public List<Reviews> deleteAllReviews(Integer weaponId) {
        return reviewRepository.deleteByWeaponId(weaponId);
    }

    private Reviews matchReviewById(Weapon weapon, Integer reviewId) {
        return weapon.getReviews().stream()
                .filter(reviews -> reviews.getId() == reviewId).findFirst().orElse(null);
    }
}
