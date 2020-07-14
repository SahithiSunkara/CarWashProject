import { Component, OnInit } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormFieldModule,MatFormFieldControl} from '@angular/material/form-field';
import { FormControl,FormGroup,Validators } from '@angular/forms';
import { CustomerService } from '.././customer.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { MatButtonModule } from '@angular/material/button';
import {Customer } from '.././customer';


@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.css']
})
export class HomeLoginComponent implements OnInit {

		IsWait : boolean = false;
		res:any;
		customer: Customer;
		loginform = new FormGroup({
			email : new FormControl(''),
			password : new FormControl('')
		})
	
	
  constructor(private login:CustomerService,private router: Router) {}

  ngOnInit(): void {
	this.login.loginUserName.subscribe(result=>{
		this.loginform.patchValue({
			username:result
		})
	})
  }

onSubmit(){
	
				this.IsWait=true;
				console.log(this.loginform.value)
				this.login.changeUserName(this.loginform.get('email').value);
				if(this.loginform.get('email').value == "Admin" && this.loginform.get('password').value == "password"){
					alert("Logged In")
					this.router.navigate(['/adminhome']);
					
				}
				else{
				this.res=this.login.login(this.loginform.get('email').value)
					console.log(this.res);
					this.response=JSON.stringify(this.res);
					if(this.response.role == "cutomer"){
					this.router.navigate(['/customerhome']);
					}
					else{
						this.router.navigate(['/washerhome']);
					}
					this.IsWait=false;
				}
				
		
}


}
