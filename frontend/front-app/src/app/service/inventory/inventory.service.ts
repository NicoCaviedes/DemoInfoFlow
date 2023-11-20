import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InventoryModel } from 'src/app/models/inventory/inventory.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';


@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private http: HttpClient,) { }

  readonly urlBase = 'http://localhost:8080/api/private/inventory';

  getInventory(): Observable<InventoryModel[]>{
    const localData = ManageLocalData.getLocalData();
    return this.http.get<InventoryModel[]>(this.urlBase+'/'+localData.idComercio);
  }

  saveInventory(product: InventoryModel){
    return this.http.post<InventoryModel>(this.urlBase+'/guardar', product);
  }
}
