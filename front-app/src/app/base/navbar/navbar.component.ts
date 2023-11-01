import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { UserModel } from 'src/app/models/user/user.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  standalone: true,
  imports: [MdbTabsModule, CommonModule]
})
export class NavbarComponent {

  isUserData: boolean;

  constructor(private router: Router){
    this.isUserData= ManageLocalData.isLocalData();
  }

  cerrarSesion(){
    ManageLocalData.deleteLocalData();
    this.router.navigate(['']);
  }
}
