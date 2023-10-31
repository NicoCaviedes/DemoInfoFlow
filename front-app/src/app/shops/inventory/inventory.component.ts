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
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatTableModule } from '@angular/material/table';
import { InventoryService } from 'src/app/service/inventory/inventory.service';
import { InventoryModel } from 'src/app/models/inventory/inventory.model';

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
  
  displayedColumns: string[] = ['ID Producto','Nombre Producto','ID Proveedor','Codigo Barra','Tipo Producto','Cantidad','Precio Unitario', 'Peso Neto','Unidad peso neto'];
  
  listProducts!: InventoryModel[];
  flagQueue: boolean = false;
  
  ngOnInit(): void {
  }

  constructor(private inventoryService: InventoryService){
  }

  getInventory(){
    this.inventoryService.getInventory().subscribe(result => {
      this.listProducts = result;
      console.log(result)
    });
  }

  isQueueActive(){
    return this.flagQueue;
  }
}
