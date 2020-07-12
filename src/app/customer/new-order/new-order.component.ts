import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup,Validators ,FormBuilder} from '@angular/forms';
import { CustomerService } from '../customer.service';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormFieldModule,MatFormFieldControl} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { OrderDetails } from '.././OrderDetails';
import { MatButtonModule } from '@angular/material/button'

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-new-order',
  templateUrl: './new-order.component.html',
  styleUrls: ['./new-order.component.css']
})
export class NewOrderComponent implements OnInit {

imageSrc: string;
clicked: boolean = false;
			response : any;
			username:any;
			packages: any = ['package1', 'package2', 'package3', 'package4']
		
			orderform = new FormGroup({
				car_no : new FormControl('',Validators.required),
				scheduled_date : new FormControl(''),
				delivery_date : new FormControl('',Validators.required),
				pickuplocation : new FormControl('',Validators.required),
				droplocation : new FormControl('',Validators.required),
				notes : new FormControl('',Validators.required),
				add_ons : new FormControl('',Validators.required),
				image: new FormControl('', [Validators.required]),
				name : new FormControl(''),
				customer : new FormControl('')
			})
	
  constructor(private service:CustomerService,public formBuilder: FormBuilder,private actrouter:ActivatedRoute,private router:Router) {
	
 }
packageForm = this.formBuilder.group({
    name: ['']
  })

			
		
		 get f(){
    return this.orderform.controls;
  }
   
  onFileChange(event : any) {
    const reader = new FileReader();
    
    if(event.target.files && event.target.files.length) {
      const [file] = event.target.files;
      reader.readAsDataURL(file);
    
      reader.onload = () => {
   
        this.imageSrc = reader.result as string;
     
        this.orderform.patchValue({
          image: [file]
        });
   
      };
   
    }
  }
		
  ngOnInit(){
	
	this.service.loginUserName.subscribe(result=>{
		console.log(result)
		this.username=result;
		this.orderform.patchValue({
			customer : this.username
		})
		
	})
	
		this.actrouter.paramMap.subscribe(params => {
			const orderId= +params.get('id');
			if(orderId){
				this.getUser(orderId);
			}
		})	
  }

			getUser(orderId: number){
				this.service.getbyOrderId(orderId).subscribe((orders: OrderDetails) =>{
					this.editUser(orders),
					(error: any) => console.log(error)
				})
			}

		editUser(orders: OrderDetails){
			this.orderform.patchValue({
				car_no: orders.car_no,
				scheduled_date: orders.scheduled_date,
				delivery_date : orders.delivery_date,
				pickuplocation : orders.pickuplocation,
				droplocation : orders.droplocation,
				notes : orders.notes,
				add_ons : orders.add_ons,
				packages : orders.packages
				
			})
		}

			onSubmit(){
				console.log(this.orderform.get("image").value)
				console.log(this.orderform.get("customer").value)
				this.service.createOrder(this.orderform.value).subscribe((result)=>{
		console.warn(result)
		this.response = result
		alert("Order Successfully placed")
		this.router.navigate(['/customerhome']);
			})
}

}
