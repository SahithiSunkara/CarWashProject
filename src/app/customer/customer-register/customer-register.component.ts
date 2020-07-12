import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup,Validators } from '@angular/forms';
import { CustomerService } from '../customer.service';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormFieldModule,MatFormFieldControl} from '@angular/material/form-field';
import { Customer } from '.././customer';
import { MatGridListModule } from '@angular/material/grid-list';
import  { MatButtonModule } from '@angular/material/button';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
 

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {

			clicked: boolean = false;
			response : any;
		registerform = new FormGroup({
			firstName : new FormControl('',Validators.required),
			middleName : new FormControl(''),
			lastName : new FormControl('',Validators.required),
			email : new FormControl('',Validators.required),
			phone_no : new FormControl('',Validators.required),
			address : new FormControl('',Validators.required),
			password : new FormControl('',Validators.required)
			
		})
		
	
  constructor(private register:CustomerService, private activeRoute:ActivatedRoute,private rout:Router) { }

  ngOnInit(){
	
		this.activeRoute.paramMap.subscribe(params => {
			const email= params.get('id');
			console.log(email)
			if(email){
				this.getUser(email);
			}
		})
  }

			getUser(email: string){
				console.log("Entered getuser function-46")
				this.register.getById(email).subscribe((user: Customer) =>{
					console.log(user[0])
					this.editUser(user[0])
					
				})
			}

		editUser(user: Customer){
			this.registerform.patchValue({
				firstName: user.firstName,
			middleName : user.middleName,
			lastName : user.lastName,
			email : user.email,
			phone_no : user.phone_no,
			address :user.address
			})
		}

			onSubmit(){
				console.log(this.registerform.value)
				this.register.register(this.registerform.value).subscribe((result)=>{
		console.warn(result)
		this.response = result
		alert("Registration successful")
		this.rout.navigate(['/'])
			})
}
}
