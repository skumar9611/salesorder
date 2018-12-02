import { Component, OnInit, Input } from '@angular/core';
import { SalesOrderService } from '../salesorder.service';
import { Product } from '../product';

import { SalesOrderDetailsComponent } from '../sales-order-details/sales-order-details.component';

@Component({
  selector: 'product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css','../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class ProductDetailsComponent implements OnInit {

	@Input() product: Product;

  constructor(private salesOrderService: SalesOrderService, private listComponent: SalesOrderDetailsComponent) { }

  ngOnInit() {
  }

  editProduct()
  {
  	console.log("Edit clicked");
  }

  deleteProduct()
  {
  	console.log("Delete clicked");
  }


}
