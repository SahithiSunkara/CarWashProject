export class OrderDetails{
	orderId: number;
	car_no: string;
	add_ons: string;
	customer: string;
	washer: string;
	scheduled_date: Date;
	delivery_date: Date;
	status: string;
	payment: number;
	rating: number;
	notes: string;
	feedback: string;
	packages: string;
	pickuplocation: string;
	droplocation: string;
	
constructor(orderId: number,car_no: string,add_ons: string,customer: string, washer: string, scheduled_date: Date,delivery_date: Date, status: string,payment: number,rating: number,
	notes: string,
	feedback: string,
	packages: string,
	pickuplocation: string,
	droplocation: string){
this.orderId = orderId;
this.car_no = car_no;
this.add_ons = add_ons;
this.customer = customer;
this.washer = washer;
this.scheduled_date = scheduled_date;
this.delivery_date = delivery_date;
this.payment = payment;
this.rating = rating;
this.notes = notes;
this.feedback = feedback;
this.packages = packages;
this.pickuplocation = pickuplocation;
this.droplocation = droplocation;

}
}