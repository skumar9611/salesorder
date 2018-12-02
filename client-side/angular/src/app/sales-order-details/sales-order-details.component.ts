import { Component, OnInit, Input } from '@angular/core';
import { SalesOrderService } from '../salesorder.service';
import { SalesOrder } from '../salesorder';

import { SalesOrderListComponent } from '../sales-order-list/sales-order-list.component';

@Component({
  selector: 'sales-order-details',
  templateUrl: './sales-order-details.component.html',
  styleUrls: ['./sales-order-details.component.css','../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class SalesOrderDetailsComponent implements OnInit {

	@Input() salesOrder: SalesOrder;
  show: boolean;
  isEditable: boolean = false;

  constructor(private salesOrderService: SalesOrderService, private listComponent: SalesOrderListComponent) { }

  ngOnInit() {  }

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

  viewSalesOrder() 
  {
    this.salesOrderService.getProducts(this.salesOrder.id);
  }

  saveSalesOrder()
  {
    this.isEditable=!this.isEditable;
    this.salesOrderService.updateSalesOrder(this.salesOrder.id,this.salesOrder.name);
  }

}
