import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import * as XLSX from "xlsx";

@Component({
  selector: 'app-report',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent {
  data = [
    {"Nombre":"Arroz", "Precio":2000, "Proveedor":"Carozzi"},
    {"Nombre":"Fideo", "Precio":1000, "Proveedor":"Acuenta"},
    {"Nombre":"Jugo", "Precio":1500, "Proveedor":"Watts"},
    {"Nombre":"Vino", "Precio":3000, "Proveedor":"Gato"},
    {"Nombre":"Manzana", "Precio":200, "Proveedor":"Sureña"}
  ]
  fileName = "PlantillaExcel.xlsx";
  generateExcel() {
      let data = document.getElementById("table-data");
      const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(data)

      const wb: XLSX.WorkBook = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(wb, ws, 'Sheet1')

      XLSX.writeFile(wb, this.fileName)
  }
}
