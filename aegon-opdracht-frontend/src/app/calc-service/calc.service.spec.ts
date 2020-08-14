import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { CalcService } from './calc.service';
import { CalcInput } from '../models/calc-input';
import {environment} from "../../environments/environment";

describe('CalcService', () => {
  let service: CalcService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ]
    });
    service = TestBed.inject(CalcService);
    httpMock = TestBed.get(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should call the API successfully', () => {
    const input: CalcInput[] = [{
      leftNumber: 1,
      rightNumber: 2,
      operator: "+"
    }, {
      leftNumber: 2,
      rightNumber: 1,
      operator: "-"
    }];

    const mockResults = [3, 4];

    service.calculate(input).subscribe(results => {
      expect(results.length).toBe(2);
      expect(results).toEqual(mockResults);
    });
    const request = httpMock.expectOne(`${environment.baseUrl}api/calculator/multiple`);
    expect(request.request.method).toBe("POST");
    request.flush(mockResults);
  });
});
