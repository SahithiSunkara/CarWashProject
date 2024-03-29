import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup,Validators } from '@angular/forms';
import { ActivatedRoute , Router} from '@angular/router';
import { HomeLoginComponent } from '../home-login/home-login.component';
import { ViewChild, AfterViewInit } from '@angular/core';
import {CustomerService} from '../customer.service';

import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';



@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {
	@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
	@ViewChild(MatSort, {static: true}) sort:MatSort;
	displayedColumns: string[] = ['orderId', 'car_no', 'packages', 'status','washer','actions'];
	dataSource:any;

     id : any;
formValues:any;
username:any;
backend:any;
@ViewChild(HomeLoginComponent) homecomponent:any;
  constructor(private route: Router, private service:CustomerService,public dialog: MatDialog) {
 }
ELEMENT_DATA: any[] = [
 
];

  ngOnInit(){
	
	this.service.loginUserName.subscribe(result=>{
		console.log(result)
		this.formValues=result;
		this.username=this.formValues
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
	console.log(this.username)
	this.service.getbyCustomer(this.username).subscribe((result:any)=>{
		this.ELEMENT_DATA = result
		console.log(this.ELEMENT_DATA)
		this.setDataSet();
	})
}

		EditClick(orderId: number){
			this.route.navigate(['/editorder',orderId]);
		}

	editClick(){
		this.route.navigate(['/edituser',this.username]);
	}

	PlaceOrder(){
		this.route.navigate(['/neworder'])
	}

}