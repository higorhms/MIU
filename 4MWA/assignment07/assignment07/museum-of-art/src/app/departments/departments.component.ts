import { Component, OnInit } from '@angular/core';
import { Department, DepartmentDataService, DepartmentsApiResponse } from '../department-data.service';

interface GetDepartmentsResponse {
  departments: Department[]
}

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent implements OnInit {
  public departments: Department[] = []

  constructor(
    private departmentDataService: DepartmentDataService,
    ){}

  ngOnInit(): void {
    this.departmentDataService.getDepartments().subscribe({
      next: (response: any)=>{
        this.departments = response.departments;
        console.log(this.departments)
      }
    })
  }
}
