import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalesOrderService {

  private baseUrl = 'http://localhost:8080/api/salesorder';

  constructor(private http: HttpClient) { }

  getSalesOrder(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createSalesOrder(salesorder: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, salesorder);
  }

  updateSalesOrder(id: string, name: string): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, `${this.baseUrl}/${name}`);
  }

  deleteSalesOrder(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getSalesOrderList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  getProducts(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
