// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
	registerapiUrl: 'http://localhost:8080/customer/AddDetails',
	loginapiUrl: 'http://localhost:8080/customer/getbyEmail',
	getAllUrl: 'http://localhost:8080/customer/getCustomers',
	updateuserUrl: 'http://localhost:8080/customer/updatecustomer',
	deleteuserUrl: 'http://localhost:8080/customer/deletecustomer',
	getbyorderId: 'http://localhost:8090/orders/getbyId',
	getAllorders: 'http://localhost:8090/orders/getorders',
	getbycustomerUrl: 'http://localhost:8090/orders/getbycustomer',
	getbyWasherUrl: 'http://localhost:8090/orders/getbywasher',
	neworderUrl: 'http://localhost:8090/orders/createorder',
	updatorderUrl: 'http://localhost:8090/orders/updateorder',
	getImage: 'http://localhost:8090/orders/getimage',
	uploadImg: 'http://localhost:8090/orders/upload'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
