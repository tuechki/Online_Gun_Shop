package org.elsys.ip.online_gun_shop.controller;

import org.elsys.ip.online_gun_shop.model.Reviews;
import org.elsys.ip.online_gun_shop.model.Weapon;
import org.elsys.ip.online_gun_shop.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/weapons")
public class WeaponController {

    private final WeaponService weaponService;

    @Autowired
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping
    public List<Weapon> getAllWeapons() {
        return weaponService.getAllWeapons();
    }

    @PostMapping
    public ResponseEntity createWeapon(@RequestBody Weapon weapon) {
        weaponService.createWeapon(weapon);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Weapon> getWeaponById(@PathVariable Integer id) {
        Weapon weapon = weaponService.getWeaponById(id);

        return new ResponseEntity<Weapon>(weapon, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Weapon> updateUserById(@PathVariable Integer id, @RequestBody Weapon w) {
        Weapon updatedWeapon = weaponService.updateWeapon(id, w);

        return new ResponseEntity<Weapon>(updatedWeapon, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserById(@PathVariable Integer id) {
        weaponService.deleteWeaponById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{weaponId}/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<Reviews>> getWeaponReviews(@PathVariable Integer weaponId) {
        List<Reviews> weaponReviews = weaponService.getWeaponReviews(weaponId);

        return new ResponseEntity<List<Reviews>>(weaponReviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/{weaponId}/reviews", method = RequestMethod.DELETE)
    public ResponseEntity<List<Reviews>> deleteUserReviews(@PathVariable Integer weaponId) {
        List<Reviews> deletedReviews = weaponService.deleteWeaponReviews(weaponId);

        return new ResponseEntity<List<Reviews>>(deletedReviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/{weaponId}/reviews", method = RequestMethod.POST)
    public ResponseEntity<Reviews> createWeaponReview(@PathVariable Integer weaponId, @RequestBody Reviews reviews) {
        Reviews weaponReview = weaponService.createWeaponReview(weaponId, reviews);

        return new ResponseEntity<Reviews>(weaponReview, HttpStatus.OK);
    }
}
