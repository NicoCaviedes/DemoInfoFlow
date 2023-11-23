import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { Router, RouterModule } from '@angular/router';
import { UserModel } from 'src/app/models/user/user.model';
import { LoginService } from 'src/app/service/private/login/login.service';
import { FormsModule } from '@angular/forms';
import { ManageLocalData } from 'src/app/utils/manage.localdata';
import { NavbarComponent } from 'src/app/base/navbar/navbar.component';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, MatFormFieldModule, MatInputModule, MatIconModule, MatCardModule, MatButtonModule, RouterModule, FormsModule, MatSnackBarModule,
    NavbarComponent,
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

  emailForm: string = '';
  passwordForm: string = '';

  hide = true;

  constructor(
    private router: Router,
    private loginService: LoginService,
    private snackBar: MatSnackBar,
  ){

  }

  ngOnInit(): void {
  }

  public loginUser(): void {
    const userForm: UserModel = {
      idClient: 0,
      firstNameClient:'',
      lastNameClient:'',
      emailClient: this.emailForm,
      passwordClient: this.passwordForm,
      tokenAuthClient: '',
      idComercio: 0
    };

    this.loginService.loginUser(userForm).subscribe(result => {
      if(result != null){
        ManageLocalData.saveLoginLocalData(result);
        this.router.navigate(['/dashboard'], {state: {userData: result}})
      } else {
        this.openSnackBar("Error, no se ha encontrado el usuario");
      }
    });
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, 'Cerrar');
  }

}
