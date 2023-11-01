import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../../base/navbar/navbar.component";
import { FooterComponent } from "../../base/footer/footer.component";
import { ProductModel } from 'src/app/models/product/product.model';
import { ProductService } from 'src/app/service/products/product.service';
import { FormsModule } from '@angular/forms';
import { InventoryModel } from 'src/app/models/inventory/inventory.model';
import { UserModel } from 'src/app/models/user/user.model';
import { ManageLocalData } from 'src/app/utils/manage.localdata';
import { InventoryService } from 'src/app/service/inventory/inventory.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, NavbarComponent, FooterComponent, FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  idProduct: number = 0;
  product!: ProductModel;
  valorTmp!: number;
  cantidadTmp!: number;
  userData: UserModel;

  constructor(private productService: ProductService, private inventoryService: InventoryService){
    this.userData = ManageLocalData.getLocalData();
  }

  getProduct(){
    this.productService.getProduct(this.idProduct).subscribe(result => {
      this.product = result;
    });
  }

  saveProduct(){
    console.log('hola');
    const newProduct: InventoryModel = {
      idProd: this.product.idProducto,
      nombreProd: this.product.nombreProducto,
      idEmpresa: this.userData.idShop,
      codigoBarra: this.product.codigoBarra,
      tipoProducto: this.product.tipoProducto,
      quantityProds: this.cantidadTmp,
      unitPriceProd: this.valorTmp,
      pesoNeto: this.product.pesoNeto,
      unidadPesoNeto: this.product.unidadPesoNeto,
      idInv: this.product.idProducto,
    };
    console.log(newProduct);
    this.inventoryService.saveInventory(newProduct).subscribe(result => console.log(result));
  }
  
}
