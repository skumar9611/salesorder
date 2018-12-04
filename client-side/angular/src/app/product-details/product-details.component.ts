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
	isEdit: boolean;

  constructor(private salesOrderService: SalesOrderService, private listComponent: SalesOrderDetailsComponent) { }

  ngOnInit() {  }

  editProduct()
  {
  	console.log("Edit clicked");
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
	//salesOrder=this.salesOrderService.getSalesOrder("5c053339f003a61474583bdb");
	//salesOrder.product
   // this.salesOrderService.updateSalesProduct(this.salesOrder.id,this.product).subscribe(
   //     data => {
  //        console.log(data);
  //      },
  //      error => console.log(error));
  }


}
