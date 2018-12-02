import { Component, OnInit } from '@angular/core';

import { SalesOrder } from '../salesorder';
import { SalesOrderService } from '../salesorder.service';

@Component({
  selector: 'create-salesorder',
  templateUrl: './create-salesorder.component.html',
  styleUrls: ['./create-salesorder.component.css','../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class CreateSalesorderComponent implements OnInit {

  salesOrder: SalesOrder = new SalesOrder();
  submitted = false;

  constructor(private salesOrderService: SalesOrderService) { }

  ngOnInit() {
  }

  newSalesOrder(): void {
    this.submitted = false;
    this.salesOrder = new SalesOrder();
  }

  save() {
    this.salesOrderService.createSalesOrder(this.salesOrder)
      .subscribe(data => console.log(data), error => console.log(error));
    this.salesOrder = new SalesOrder();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

}
