import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InventoryModel } from 'src/app/models/inventory/inventory.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';


@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private http: HttpClient,) { }

  readonly urlBase = 'http://localhost:8080/api/priv/store/inventory';

  getInventory(): Observable<InventoryModel[]>{
    const localData = ManageLocalData.getLocalData();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Bearer '+localData.tokenAuthClient
      })
    }
    return this.http.get<InventoryModel[]>(this.urlBase+'/'+localData.idCompany, httpOptions);
  }

  saveInventory(product: InventoryModel){
    const localData = ManageLocalData.getLocalData();
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Bearer '+localData.tokenAuthClient
      })
    }
    return this.http.post<InventoryModel>(this.urlBase+'/guardar', product, httpOptions);
  }
}
