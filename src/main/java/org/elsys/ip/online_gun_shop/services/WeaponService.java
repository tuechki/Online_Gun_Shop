package org.elsys.ip.online_gun_shop.services;

import org.elsys.ip.online_gun_shop.exception.ResourceNotFoundException;
import org.elsys.ip.online_gun_shop.model.Weapon;
import org.elsys.ip.online_gun_shop.repository.WeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    private final WeaponRepository weaponRepository;

    public WeaponService(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
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

}
