import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { FormGroup } from '@angular/forms';
import { environment } from '../../environments/environment';
import { Customer } from './customer';
import { asLiteral } from '@angular/compiler/src/render3/view/util';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
    private userSubject: BehaviorSubject<Customer>;
    public user: Observable<Customer>;
	response:any;

	private loginUserNameSource = new BehaviorSubject<any>('');
	loginUserName = this.loginUserNameSource.asObservable();

    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.userSubject = new BehaviorSubject<Customer>(JSON.parse(localStorage.getItem('user')));
        this.user = this.userSubject.asObservable();
    }

changeUserName(form: FormData){
	this.loginUserNameSource.next(form);
}

   

   async login(email: string) {
    return  await this.http.get(environment.loginapiUrl+"/"+email).toPromise().then((data : any) =>{
        this.response= console.log(data);
     })
    }

		getbyCustomer(email : string){
			return this.http.get(environment.getbycustomerUrl+"/"+email)
		}

    logout() {
        // remove user from local storage and set current user to null
        localStorage.removeItem('user');
        this.userSubject.next(null);
        this.router.navigate(['/account/login']);
    }

    register(user: FormGroup) {
        return this.http.post(environment.registerapiUrl, user)

    }

	createOrder(data : FormGroup){
		return this.http.post(environment.neworderUrl, data)
	}

    upload(data:any){
        return this.http.post(environment.uploadImg,data);
    }

   public getAll() {
	
	return this.http.get(environment.getAllUrl);
        //return this.http.get<Customer[]>(environment.getAllUrl);
    }

    getById(email: string) {
        return this.http.get<Customer>(environment.loginapiUrl+"/"+email);
    }
	
	getAllOrders(){
		return this.http.get(environment.getAllorders);
	}

	getbyOrderId(orderId: number){
		return this.http.get(environment.getbyorderId+"/"+orderId);
	}
    
    getImage(name: string){
        return this.http.get(environment.getImage+"/"+name);
    }

    delete(id: string) {
        return this.http.delete(`${environment.deleteuserUrl}/users/${id}`)
            .pipe(map(x => {
                // auto logout if the logged in user deleted their own record
               /* if (id == this.userValue.id) {
                    this.logout();
                }*/
                return x;
            }));
    }
}
