import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { SalesOrderService } from '../salesorder.service';
import { SalesOrder } from '../salesorder';

@Component({
  selector: 'sales-order-list',
  templateUrl: './sales-order-list.component.html',
  styleUrls: ['./sales-order-list.component.css','../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class SalesOrderListComponent implements OnInit {

  salesOrders: Observable<SalesOrder[]>;

  constructor(private salesOrderService: SalesOrderService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.salesOrders = this.salesOrderService.getSalesOrderList();
  }
}
