import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UserModel } from 'src/app/models/user/user.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly urlLogin = 'http://localhost:8080/api/auth/login';

  constructor(
    private http: HttpClient,
    private router: Router,
  ) { }

  public loginUser(userModel: UserModel): Observable<UserModel> {
    return this.http.post<UserModel>(this.urlLogin, userModel);
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