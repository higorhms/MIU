import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export class Department{
  constructor(
    public departmentId: number,
    public displayName: string,
  ){}
}

export interface DepartmentsApiResponse {
  departments: Department[]
}

@Injectable({
  providedIn: 'root'
})
export class DepartmentDataService {

  _baseUrl: string = 'https://collectionapi.metmuseum.org/public/collection/v1/departments';

  constructor(private _httpClient: HttpClient) { }

  public getDepartments(): Observable<DepartmentsApiResponse[]> {
    return this._httpClient.get<DepartmentsApiResponse[]>(this._baseUrl);
  }
}
