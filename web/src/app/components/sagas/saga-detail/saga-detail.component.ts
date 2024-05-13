import {Component, Inject, OnInit} from '@angular/core';
import {Saga} from "../saga";
import {ActivatedRoute, Router} from "@angular/router";
import {SagaService} from "../../../services/saga.service";
import {MAT_DIALOG_DATA, MatDialogClose, MatDialogContent, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Book} from "../../books/book";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {SnackbarComponent} from "../../../shared/snackbar/snackbar.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-saga-detail',
  standalone: true,
	imports: [
		MatDialogContent,
		ReactiveFormsModule,
		MatFormField,
		MatInput,
		MatLabel,
		MatDialogClose
	],
  templateUrl: './saga-detail.component.html',
  styleUrl: './saga-detail.component.scss'
})
export class SagaDetailComponent implements OnInit{

	saga!: Saga;
	booksOfSaga: Book[] = [];
	form: FormGroup;
	editMode: boolean = false;
	isUpdate: boolean = false;

	constructor(@Inject(MAT_DIALOG_DATA) private data: any,
				public ref: MatDialogRef<SagaDetailComponent>,
				private snackBar: MatSnackBar,
				private router: Router,
				private fb: FormBuilder,
				private activatedRoute: ActivatedRoute,
				private sagaService: SagaService) {
		this.saga = this.data.saga;
		this.form = this.fb.group({
			name: [{value: "", disabled: !!this.saga}, Validators.required],
			publishStart: [{value: "", disabled: !!this.saga}, Validators.required],
			publishEnd: [{value: "", disabled: !!this.saga}]
		});
	}

	ngOnInit(): void {
		this.editMode = true;
		if(this.saga) {
			this.editMode = false;
			this.isUpdate = true;
			this.form.patchValue(this.saga);
			this.sagaService.findBooksBySagaId(this.saga.id).subscribe(data => this.booksOfSaga = data);
		}
	}

	enableEdit(enable: boolean) {
		this.editMode = enable;
		this.form.get('name')?.enable();
		this.form.get('publishStart')?.enable();
		this.form.get('publishEnd')?.enable();
	}

	goToBookDetail(bookId: number | undefined) {
		this.ref.close();
		this.router.navigate([`/books/${bookId}`]);
	}

	save() {
		this.saga = this.form.value;
		if (this.isUpdate) {
			this.saga.id = this.data.saga.id;
			this.sagaService.update(this.saga).subscribe(data => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: 'La saga se ha actualizado correctamente',
							success: true
						},
						duration: 4000
					});
					if (data) {
						this.ref.close();
					}
				},
				(error) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: `Error ${error.error.code}: ${error.error.message}`,
							success: false
						},
						duration: 4000
					});
					this.ref.close();
				}
			);
		} else {
			this.sagaService.insert(this.saga).subscribe(data => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: 'La Saga se ha insertado correctamente',
							success: true
						},
						duration: 4000
					});
					if (data) {
						this.ref.close();
					}
				},
				(error) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: `Error ${error.error.code}: ${error.error.message}`,
							success: false
						},
						duration: 4000
					});
					this.ref.close();
				}
			);
		}
	}

	delete(sagaId: number | undefined) {
		this.sagaService.delete(sagaId).subscribe(data => {
				this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: 'La saga se ha eliminado correctamente',
						success: true
					},
					duration: 4000
				});
				this.ref.close();
			},
			(error) => {
				this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: `Error ${error.error.code}: ${error.error.message}`,
						success: false
					},
					duration: 4000
				});
				this.ref.close();
			}
		);
	}

}
