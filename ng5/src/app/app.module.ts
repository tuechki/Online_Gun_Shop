import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';

import { HttpClientModule } from '@angular/common/http';
import { AuthComponent } from './auth/auth.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/token.interceptor';
import {AuthService} from "./auth/auth.service";
import {AuthGuardService} from "./auth/auth.guard.service";
import { CreateBusinessService } from './services/message.service';
import { BusinessInfoService } from './services/business.info.service';
import {UploadService} from "./services/upload.service";

import { MaterialModule } from './material.module';
import { PrimengModule } from './primeng.module';
import { AgmCoreModule } from '@agm/core';
import { MyProfileComponent } from './my-profile/my-profile.component';
import {WeaponInfoService} from "./services/weapon.info.service";
import { FavouritesComponent } from './favourites/favourites.component';
import { PurchasesComponent } from './purchases/purchases.component';
import { CartComponent } from './cart/cart.component';
import { WeaponInfoComponent } from './weapon-info/weapon-info.component';

// import { AngularFireModule } from 'angularfire2';
//
// export const firebaseConfig = {
//   apiKey: "AIzaSyD0To-EJJUok133ygHSuVdNFvqMXG_rrcc",
//   authDomain: "onlinegunshop-30065.firebaseapp.com",
//   databaseURL: "https://onlinegunshop-30065.firebaseio.com",
//   projectId: "onlinegunshop-30065",
//   storageBucket: "onlinegunshop-30065.appspot.com",
//   messagingSenderId: "1015857744686"
// };

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    SignUpComponent,
    LoginComponent,
    AuthComponent,
    MyProfileComponent,
    FavouritesComponent,
    PurchasesComponent,
    CartComponent,
    WeaponInfoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    HttpClientModule,
    PrimengModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCuxNJz1x-vTL9ggD0ELJ9p357RyzKHUZg',
      libraries: ["places"]
    })

],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }, AuthService,
      AuthGuardService,
      CreateBusinessService,
      BusinessInfoService,
      UploadService,
      WeaponInfoService

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
