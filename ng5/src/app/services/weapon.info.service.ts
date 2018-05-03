import { Injectable } from '@angular/core';

@Injectable()
export class WeaponInfoService {

  private currentWeapon: any = null;

  public getCurrentWeapon(){
    return this.currentWeapon;
  }

  public setCurrentWeapon(business){
    this.currentWeapon = business;
  }

  public clearCurrentWeapon() {
    this.currentWeapon = null;
  }

}
