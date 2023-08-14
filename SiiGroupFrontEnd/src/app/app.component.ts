import { Component } from '@angular/core';
import { EmployeeService } from './Employee/employee.service';
import { Employee } from './Employee/model/Employee';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SiiGroupFrontEnd';
  id:number;

  employees: Employee[];

  constructor(private service:EmployeeService,
    private toast: ToastrService){

  }

  searchEmployee(){
    if(this.id != null){
      this.service.getEmployeeById(this.id).subscribe(data => {
        this.employees = []
        this.employees.push(data);
      }, error => {
        this.toast.error(error.error, "Error");
      });
      return;
    }
    this.service.getAllEmployees().subscribe(data => {
      this.employees = data;
    }, error => {
      this.toast.error(error.error, "Error");
    })
  }
}
