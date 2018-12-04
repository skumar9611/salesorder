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

  updateSalesOrder(id: string, name: string,salesorder: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}/${name}`, salesorder);
  }

  deleteSalesOrder(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

   getProduct(id: string): Observable<Object> {
    return this.http.get(`${this.baseUrl}/products/${id}`);
  }

  getSalesOrderList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }

  updateSalesProduct(id: string,salesorder: Object): Observable<Object> {
    return this.http.put(`${this.baseUrl}/updateProd/${id}`, salesorder);
  }
  
  createProduct(id: string, product: Object): Observable<Object> {
	  return this.http.put(`${this.baseUrl}/createProduct/${id}`,product);
  }
  
  deleteProduct(id: string, pid: string): Observable<Object> {
	  return this.http.put(`${this.baseUrl}/deleteProduct/${id}/${pid}`,pid);
  }


}
