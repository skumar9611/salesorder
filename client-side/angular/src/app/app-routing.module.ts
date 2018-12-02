import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateSalesorderComponent } from './create-salesorder/create-salesorder.component';
import { SalesOrderListComponent } from './sales-order-list/sales-order-list.component';

const routes: Routes = [
    { path: '', redirectTo: 'salesorder', pathMatch: 'full' },
    { path: 'add', component: CreateSalesorderComponent },
    { path: 'salesorder', component: SalesOrderListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
