import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductModel } from 'src/app/models/product/product.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  readonly urlAPIPrivate = `${environment.baseApiURL}/api/priv/store/products`;

  constructor(private http: HttpClient,) { }

  getAllProds(): Observable<ProductModel[]> {
    const localData = ManageLocalData.getLocalData();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Bearer '+localData.tokenAuthClient
      })
    }
    return this.http.get<ProductModel[]>(this.urlAPIPrivate, httpOptions);
  }

  getProduct(idProduct: number): Observable<ProductModel> {
    const localData = ManageLocalData.getLocalData();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Bearer '+localData.tokenAuthClient
      })
    }
    return this.http.get<ProductModel>(`${this.urlAPIPrivate}/${idProduct}`, httpOptions);
  }

  saveProduct(idProduct: number){
    const localData = ManageLocalData.getLocalData();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Bearer '+localData.tokenAuthClient
      })
    }
    return this.http.post<ProductModel>(this.urlAPIPrivate, idProduct, httpOptions)
  }
}
