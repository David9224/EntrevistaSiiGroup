import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  URL = 'http://localhost:8080/v1/employee';

  constructor(private http: HttpClient) { }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.URL);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(this.URL + "/" + id);
  }
}
