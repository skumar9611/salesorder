import { Component, OnInit, Input } from '@angular/core';
import { SalesOrderService } from '../salesorder.service';
import { SalesOrder } from '../salesorder';
import { Product } from '../product';
import { Observable } from 'rxjs';
//import { ProductDetailsComponent } from '../product-details/product-details.component';

import { SalesOrderListComponent } from '../sales-order-list/sales-order-list.component';

@Component({
  selector: 'sales-order-details',
  templateUrl: './sales-order-details.component.html',
  styleUrls: ['./sales-order-details.component.css','../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class SalesOrderDetailsComponent implements OnInit {

  @Input() salesOrder: SalesOrder;
  show: boolean;
  cancel: boolean;
  addBtn: boolean;
  add: boolean;
  tempName: string;
  isEditable: boolean = false;
  products: Observable<Object>;
  productAdd: Product = new Product();

  constructor(private salesOrderService: SalesOrderService, private listComponent: SalesOrderListComponent) { }

  ngOnInit() {    }

  toggle() 
  {
    this.show = !this.show;
  }
  deleteSalesOrder() 
  {
    this.salesOrderService.deleteSalesOrder(this.salesOrder.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log(error));
  }
	
  editSalesOrder()
  {
	  this.isEditable = !this.isEditable;
	  this.tempName = this.salesOrder.name;
  }
  viewSalesOrder() 
  {
    this.salesOrderService.getSalesOrder(this.salesOrder.id);
	this.products=this.salesOrder.products;
	this.addBtn=!this.addBtn;
  }

  saveSalesOrder()
  {
    this.isEditable=!this.isEditable;
    this.salesOrderService.updateSalesOrder(this.salesOrder.id,this.salesOrder.name,this.salesOrder).subscribe(
        data => {
          console.log(data);
        },
        error => console.log(error));
  }

  generateView(products)
  {
    this.products=products;
  }

  cancelEdit()
  {
	  this.salesOrder.name=this.tempName;
    this.isEditable=!this.isEditable;  
  }
  
  addSalesProduct()
  {
	  this.add=!this.add;
	  this.addBtn=!this.addBtn;
	  this.cancel=!this.cancel;
  }
  cancelAddSalesProduct()
  {
	  this.add=!this.add;
	  this.addBtn=!this.addBtn;
	  this.cancel=!this.cancel;
  }
	
  addNewProduct()
  {
      this.salesOrderService.createProduct(this.salesOrder.id,this.productAdd).subscribe(
        data => {
          console.log(data);
        },
        error => console.log(error));
	  this.add=!this.add;
	  this.addBtn=!this.addBtn;
	  this.cancel=!this.cancel;
	  window.location.reload();
  }
}
