import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../../base/navbar/navbar.component";
import { FooterComponent } from "../../base/footer/footer.component";
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { ProductModel } from 'src/app/models/product/product.model';
import { ProductService } from 'src/app/service/productservice.service';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-inventory',
  standalone: true,
  imports: [CommonModule, NavbarComponent, FooterComponent, 
    MatCardModule, MatButtonModule, MatFormFieldModule,
    MatInputModule, FormsModule, MatDialogModule,
    MatListModule, MatProgressSpinnerModule, MatTableModule],
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.scss']
})
export class InventoryComponent implements OnInit{
  
  displayedColumns: string[] = ['ID Producto','Nombre Producto','Nombre Proveedor','Codigo Barra','Tipo Producto','Peso Neto','Cantidad','Precio Unitario'];
  
  listProducts!: ProductModel[];
  flagQueue: boolean = false;
  
  ngOnInit(): void {
  }

  constructor(private productService: ProductService){
    this.getAllProducts();
  }

  getAllProducts(){
    this.productService.getAllProds().subscribe(result => {
      this.listProducts = result;
      console.log(result)
    });
  }

  isQueueActive(){
    return this.flagQueue;
  }
}
