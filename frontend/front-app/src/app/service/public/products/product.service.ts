import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductModel } from '../../../models/product/product.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  readonly urlAPIPublic = `${environment.baseApiURL}/api/public/products`;

  constructor(
    private http: HttpClient,
  ) { }

  getAllProds(): Observable<ProductModel[]> {
    return this.http.get<ProductModel[]>(this.urlAPIPublic);
  }

  getProduct(idProduct: number): Observable<ProductModel> {
    return this.http.get<ProductModel>(`${this.urlAPIPublic}/${idProduct}`);
  }
}
