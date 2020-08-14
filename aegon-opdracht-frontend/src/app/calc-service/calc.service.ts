import {Injectable} from '@angular/core';
import {CalcInput} from '../models/calc-input';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CalcService {

  constructor(private http: HttpClient) {
  }

  calculate(formData: CalcInput[]): Observable<number[]> {
    return this.http.post<number[]>(`${environment.baseUrl}api/calculator/multiple`, formData);
  }
}
