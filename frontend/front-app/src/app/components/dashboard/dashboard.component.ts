import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../../base/navbar/navbar.component";
import { FooterComponent } from "../../base/footer/footer.component";
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { DialogComponent } from 'src/app/base/dialog/dialog.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { ProductModel } from 'src/app/models/product/product.model';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTableModule } from '@angular/material/table';
import { ProductService } from 'src/app/service/products/product.service';

@Component({
    selector: 'app-dashboard',
    standalone: true,
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
    imports: [
      CommonModule, NavbarComponent, FooterComponent, 
      MatCardModule, MatButtonModule, MatFormFieldModule,
      MatInputModule, FormsModule, MatDialogModule,
      MatListModule, MatProgressSpinnerModule, MatTableModule
    ]
})
export class DashboardComponent implements OnInit{
  
  displayedColumns: string[] = ['ID Producto','Nombre Producto','Nombre Proveedor','Codigo Barra','Tipo Producto','Peso Neto']

  idProduct: number | undefined;

  flagViewAllProds: boolean = false;
  flagViewProd: boolean = false;
  flagQueue: boolean = false;

  listProducts: ProductModel[] | undefined;
  productSearched: ProductModel | undefined;

  constructor(
    public dialog: MatDialog,
    private productService: ProductService,
  ){}

  ngOnInit(): void {
  }


  openPopUp(): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      data: {idProduct: this.idProduct}
    });

    dialogRef.afterClosed().subscribe(result =>{
      this.flagQueue = true;

      this.idProduct = result;
      const resultQuery = this.productService.getProduct(result);
      
      resultQuery.subscribe(result => {
        this.productSearched = result;
        this.flagQueue = false;
        this.flagViewProd = true;
      });
    });
  }

  getAllProducts(): void{
    this.flagQueue = true;
    this.productService.getAllProds().subscribe(result => {
      this.listProducts = result;
      this.flagViewAllProds = true;
      this.flagQueue = false;
    });
  }

  isQueueActive(){
    return this.flagQueue;
  }

  isViewAllProds(){
    return this.flagViewAllProds;
  }

  isViewProd(){
    return this.flagViewProd;
  }
}
