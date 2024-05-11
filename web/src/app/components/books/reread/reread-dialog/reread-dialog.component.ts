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
import {error} from "@angular/compiler-cli/src/transformers/util";

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
				private bookService: BookService) {
		this.form = this.fb.group({
			startDate: [data.insert ? '' : data.reread.startDate, Validators.required],
			finishDate: [data.insert ? '' : data.reread.finishDate, Validators.required],
			impressions: [data.insert ? '' : data.reread.impressions, Validators.required]
		})
	}

	ngOnInit(): void {
	}

	save() {
		let book =  this.data.book;
		let newReread: Reread = {
			startDate: this.form.controls['startDate'].value,
			finishDate: this.form.controls['finishDate'].value,
			impressions: this.form.controls['impressions'].value
		};
		if (this.data.insert) {
			book.rereads.push(newReread);
		} else {
			let index = book.rereads.findIndex(r => r.id == this.data.reread.id);
			newReread.id = this.data.reread.id;
			book.rereads.splice(index, 1, newReread);
		}
		this.bookService.update(book).subscribe(
			(data) => {
				this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: 'El libro se ha actualizado correctamente',
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
