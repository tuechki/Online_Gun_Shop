import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import {AuthGuardService} from "./auth/auth.guard.service";
import {MyProfileComponent} from "./my-profile/my-profile.component";
import {CartComponent} from "./cart/cart.component";
import {FavouritesComponent} from "./favourites/favourites.component";
import {PurchasesComponent} from "./purchases/purchases.component";


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'sign-up',
    component: SignUpComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'my-profile',
    component: MyProfileComponent
  },
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path: 'favourites',
    component: FavouritesComponent
  },
  {
    path: 'purchases',
    component: PurchasesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
