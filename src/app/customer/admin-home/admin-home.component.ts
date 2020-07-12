import { Component, OnInit ,ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import { FormControl,FormGroup,Validators } from '@angular/forms';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormFieldModule,MatFormFieldControl} from '@angular/material/form-field';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

import {MatTableDataSource} from '@angular/material/table';
import { ActivatedRoute,Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { HomeLoginComponent } from '../home-login/home-login.component';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
	
	@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
	@ViewChild(MatSort, {static: true}) sort:MatSort;
	displayedColumns: string[] = ['firstName', 'email', 'role', 'phone_no','actions'];
	dataSource:any;
 id : any;
username:any;
nameclicked:boolean = false;
backend: any;
response : any;

		userform  = new FormGroup({
			firstName : new FormControl('',Validators.required),
			middleName : new FormControl(''),
			lastName : new FormControl('',Validators.required),
			email : new FormControl('',Validators.required),
			phone_no : new FormControl('',Validators.required),
			address : new FormControl('',Validators.required),
			
		})
		
		
@ViewChild(HomeLoginComponent) homecomponent:any;
  constructor(private route: Router, private service:CustomerService,public dialog: MatDialog) {
 }
ELEMENT_DATA: any[] = [
 
];

  ngOnInit(){
	
	this.service.loginUserName.subscribe(result=>{
		this.username=result;
	})
	
	
	console.log(this.username);
	//this.setDataSet();
	this.fetchData();
  }
setDataSet(){
	this.dataSource = new MatTableDataSource<any>(this.ELEMENT_DATA);
this.dataSource.paginator = this.paginator;
this.dataSource.sort = this.sort;
}


fetchData(){
	console.log("entered fetch data function")
	this.service.getAll().subscribe((result:any)=>{
		this.ELEMENT_DATA = result
		console.log(this.ELEMENT_DATA)
		this.setDataSet();
	})
}
			
			EditUser(email: string){
				this.route.navigate(['/edituser',email]);
			}
}
