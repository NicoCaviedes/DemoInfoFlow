import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  standalone: true,
  imports: [MdbTabsModule]
})
export class NavbarComponent {

  constructor(private router: Router){
  }

  redirectDash(){
    this.router.navigate(['dashboard']);
  }
  redirectInvetory(){
    this.router.navigate(['inventory']);
  }
}
