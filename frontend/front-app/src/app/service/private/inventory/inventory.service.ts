import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InventoryModel } from 'src/app/models/inventory/inventory.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';
import { environment } from 'src/environments/environment.prod';


@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private http: HttpClient,) { }

  // readonly urlBase = '/api/priv/store/inventory';
  readonly urlBase = `${environment.baseApiURL}/api/priv/store/inventory`;

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
