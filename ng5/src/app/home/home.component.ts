import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../auth/auth.service";
import {Router} from "@angular/router";
import {} from '@types/googlemaps'
import {WeaponInfoService} from "../services/weapon.info.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

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

    // this.httpClient.get('http://localhost:8080/weapons', {observe: 'response'})
    //   .subscribe(resp => {
    //       console.log(resp.headers);
    //       console.log(resp.body);
    //       this.weapons = resp.body;
    //     }
    //   );

    
  }

  showWeapon(weapon){
    console.log(weapon);
    this.weaponInfoService.setCurrentWeapon(weapon);
    this.router.navigate(['weapon-info']);
  }


}
