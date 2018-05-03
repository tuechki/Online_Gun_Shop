import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthService} from "../auth/auth.service";
import {WeaponInfoService} from "../services/weapon.info.service";

@Component({
  selector: 'app-weapon-info',
  templateUrl: './weapon-info.component.html',
  styleUrls: ['./weapon-info.component.scss']
})
export class WeaponInfoComponent implements OnInit {


  weapon: any;

  constructor(private httpClient: HttpClient, private router: Router,
              public authService: AuthService, public weaponInfoService: WeaponInfoService) { }

  ngOnInit() {

    this.httpClient.get('http://localhost:8080/weapons/'
      + this.weaponInfoService.getCurrentWeapon()['id'],
      {observe: 'response'}
    ).subscribe(resp => {
      this.weapon = resp.body;
    });

  }

}
