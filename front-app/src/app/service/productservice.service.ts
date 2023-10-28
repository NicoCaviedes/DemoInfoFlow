import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ProductModel } from '../models/product/product.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  readonly urlBase = 'http://localhost:8080/api/productos';

  constructor(
    private http: HttpClient,
  ) { }

  getAllProds(): Observable<ProductModel[]> {
    return this.http.get<ProductModel[]>(this.urlBase);
  }

  getProduct(idProduct: number): Observable<ProductModel> {
    return this.http.get<ProductModel>(`${this.urlBase}/${idProduct}`);
  }
}
