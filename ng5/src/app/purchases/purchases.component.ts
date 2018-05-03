import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../auth/auth.service";
import {WeaponInfoService} from "../services/weapon.info.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.scss']
})
export class PurchasesComponent implements OnInit {

  weapons: any;
  image: File = null;

  @ViewChild("search")
  public searchElementRef: ElementRef;

  constructor(
    public authService: AuthService,
    private router: Router,
    private httpClient: HttpClient,
    public weaponInfoService: WeaponInfoService
  ) {}


  ngOnInit() {

    this.httpClient.get('http://localhost:8080/weapons', {observe: 'response'})
      .subscribe(resp => {
          console.log(resp.headers);
          console.log(resp.body);
          this.weapons = resp.body;
        }
      );

  }

  showWeapon(weapon){
    console.log(weapon);
    this.weaponInfoService.setCurrentWeapon(weapon);
    this.router.navigate(['weapon-info']);
  }
}
