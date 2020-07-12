import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { HomeLoginComponent } from '../home-login/home-login.component';

import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';



@Component({
  selector: 'app-washer-home',
  templateUrl: './washer-home.component.html',
  styleUrls: ['./washer-home.component.css']
})
export class WasherHomeComponent implements OnInit {
	@ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
	@ViewChild(MatSort, {static: true}) sort:MatSort;
	displayedColumns: string[] = ['orderno', 'carno', 'packages', 'status','customer'];
	dataSource:any;
	clicked: boolean= false;
     id : any;
username:any;
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
	this.service.getById(this.username).subscribe((result:any)=>{
		this.ELEMENT_DATA = result
		this.setDataSet();
	})
}

		EditClick(orderId: number){
			this.route.navigate(['/editorder',orderId]);
		}
		
		editClick(username : string){
		this.route.navigate(['/edituser',username]);
	}

}