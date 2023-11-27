import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UserModel } from 'src/app/models/user/user.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly urlLogin = `${environment.baseApiURL}/api/auth/login`;

  constructor(
    private http: HttpClient,
    private router: Router,
  ) { }

  public loginUser(userModel: UserModel): Observable<UserModel> {
    const clientLogin = {
      emailClient:userModel.emailClient,
      passwordClient:userModel.passwordClient
    }
    return this.http.post<UserModel>(this.urlLogin, clientLogin);
  }
  
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean{
    const userData = ManageLocalData.getLocalData();
    if(userData.emailClient != undefined) {
      return true;
    }
    this.router.navigate(['/login']);
    return false; 
  }
}

export const AuthGuard: CanActivateFn = (next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean => {
  return inject(LoginService).canActivate(next, state);
}