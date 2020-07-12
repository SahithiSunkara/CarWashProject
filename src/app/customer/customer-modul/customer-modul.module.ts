import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTabsModule } from '@angular/material/tabs';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatGridListModule } from '@angular/material/grid-list';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import {MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {MatSelectModule} from '@angular/material/select';
import {MatButtonModule} from '@angular/material/button';



@NgModule({
  declarations: [
],
  imports: [
    CommonModule,
FormsModule,
ReactiveFormsModule,
HttpClientModule,
MatDialogModule,
MatTabsModule,
MatFormFieldModule,
MatInputModule,
MatGridListModule,
MatProgressSpinnerModule,
MatTableModule,
MatPaginatorModule,
MatSortModule,
MatSelectModule,
MatButtonModule
  ],
 exports: [
	CommonModule,
	FormsModule,
	ReactiveFormsModule,
	HttpClientModule,
	MatDialogModule,
	MatTabsModule,
	MatFormFieldModule,
	MatInputModule,
	MatGridListModule,
	MatProgressSpinnerModule,
	MatTableModule,
MatPaginatorModule,
MatSortModule,
MatSelectModule,
MatButtonModule
]
})
export class CustomerModulModule { }
