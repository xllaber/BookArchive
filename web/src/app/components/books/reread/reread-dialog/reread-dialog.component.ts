import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogContent, MatDialogRef} from "@angular/material/dialog";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatInput} from "@angular/material/input";
import {Book} from "../../book";
import {BookService} from "../../../../services/book.service";
import {Reread} from "../reread";
import {MatSnackBar} from "@angular/material/snack-bar";
import {SnackbarComponent} from "../../../../shared/snackbar/snackbar.component";
import {RereadService} from "../../../../services/reread.service";

@Component({
  selector: 'app-reread-dialog',
  standalone: true,
	imports: [
		MatDialogContent,
		MatFormField,
		FormsModule,
		MatDatepicker,
		MatDatepickerInput,
		MatDatepickerToggle,
		MatInput,
		MatLabel,
		MatSuffix,
		ReactiveFormsModule
	],
  templateUrl: './reread-dialog.component.html',
  styles: ``
})
export class RereadDialogComponent implements OnInit{

	form: FormGroup;

	constructor(@Inject(MAT_DIALOG_DATA) private data: {reread: Reread, book: Book, insert: boolean},
				private ref: MatDialogRef<RereadDialogComponent>,
				private snackBar: MatSnackBar,
				private fb: FormBuilder,
				private rereadService: RereadService) {
		this.form = this.fb.group({
			startDate: [data.insert ? '' : data.reread.startDate, Validators.required],
			finishDate: [data.insert ? '' : data.reread.finishDate, Validators.required],
			impressions: [data.insert ? '' : data.reread.impressions, Validators.required],
			bookId: [data.book.id]
		})
	}

	ngOnInit(): void {
	}

	save() {
		if (this.data.insert) {
			console.log(this.form.value)
			this.rereadService.insert(this.form.value).subscribe(
			(data) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: 'Relectura insertada correctamente',
							success: true
						},
						duration: 4000
					})
					this.ref.close();
				},
				(error) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: `Error ${error.error.code}: ${error.error.message}`,
							success: false
						},
						duration: 4000
					})
					this.ref.close();
				}
			);
		} else {
			console.log(this.form.value);
			let reread = this.form.value;
			reread.id = this.data.reread.id;
			this.rereadService.update(reread).subscribe(
				(data) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: 'Relectura editada correctamente',
							success: true
						},
						duration: 4000
					})
					this.ref.close();
				},
				(error) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: `Error ${error.error.code}: ${error.error.message}`,
							success: false
						},
						duration: 4000
					})
					this.ref.close();
				}
			);
		}
	}

}
