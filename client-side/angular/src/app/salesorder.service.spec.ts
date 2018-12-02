import { TestBed, inject } from '@angular/core/testing';

import { SalesOrderService } from './salesorder.service';

describe('SalesOrderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalesOrderService]
    });
  });

  it('should be created', inject([SalesOrderService], (service: SalesOrderService) => {
    expect(service).toBeTruthy();
  }));
});
