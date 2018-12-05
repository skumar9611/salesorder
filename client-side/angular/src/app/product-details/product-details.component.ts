import { Component, OnInit, Input } from '@angular/core';
import { SalesOrderService } from '../salesorder.service';
import { Product } from '../product';
import { SalesOrder } from '../salesorder';

import { SalesOrderDetailsComponent } from '../sales-order-details/sales-order-details.component';

@Component({
  selector: 'product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css','../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class ProductDetailsComponent implements OnInit {

	@Input() product: Product;
    @Input() salesId: string;
	salesOrder: SalesOrder;
	tempProdProdName: string;
	tempProdType: string;
	tempProdPrice: number;
	tempProdApproved: boolean;
	tempProdQuantity: number;
	isEdit: boolean;

  constructor(private salesOrderService: SalesOrderService, private listComponent: SalesOrderDetailsComponent) { }

  ngOnInit() {  }

  editProduct()
  {
	this.tempProdProdName = this.product.productName;
	this.tempProdType = this.product.type;
	this.tempProdPrice = this.product.price;
	this.tempProdApproved = this.product.approved;
	this.tempProdQuantity = this.product.quantity;
	this.isEdit = !this.isEdit;
  }

  deleteProduct()
  {
  	this.salesOrderService.deleteProduct(this.salesId,this.product.id).subscribe(
        data => {
          console.log(data);
        },
        error => console.log(error));		
	window.location.reload();
  }
  
  saveEditProduct()
  {
	this.isEdit=!this.isEdit;
	this.salesOrderService.updateSalesProduct(this.salesId,this.product).subscribe(
        data => {        },
        error => console.log(error));
  }
	
  cancelEditProduct()
  {
	this.product.productName = this.tempProdProdName;
	this.product.type = this.tempProdType;
	this.product.price = this.tempProdPrice;
	this.product.approved = this.tempProdApproved;
	this.product.quantity = this.tempProdQuantity;
	this.isEdit=!this.isEdit;
	  
  }

}
