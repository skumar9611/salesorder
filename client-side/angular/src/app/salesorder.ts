import { Product } from './product';
import { Observable } from 'rxjs';
export class SalesOrder {
    id: string;
    name: string;
    products: Observable<Product>;
}