import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginModelApi } from 'src/app/models/login/login.model';
import { UserModel } from 'src/app/models/user/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private readonly urlLogin = 'http://localhost:8080/api/private/sesion';

  constructor(
    private http: HttpClient,
  ) { }

  public loginUser(userModel: UserModel): Observable<LoginModelApi> {
    return this.http.post<LoginModelApi>(this.urlLogin, userModel);
  }
}
