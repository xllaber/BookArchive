import {Component, Inject, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {Author} from "../author";
import {AuthorService} from "../../../services/author.service";
import {MAT_DIALOG_DATA, MatDialogClose, MatDialogContent, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {SnackbarComponent} from "../../../shared/snackbar/snackbar.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-author-detail',
  standalone: true,
	imports: [CommonModule, MatDialogContent, ReactiveFormsModule, MatFormField, MatInput, MatLabel, MatDialogClose],
  templateUrl: './author-detail.component.html',
  styleUrl: './author-detail.component.scss'
})
export class AuthorDetailComponent implements OnInit{

	author!: Author;
	form: FormGroup;
	isUpdate: boolean = false
	editMode: boolean = false;
	cancelEnabled: boolean = false;
	authorImage: any;

	constructor(@Inject(MAT_DIALOG_DATA) private data: any,
				public ref: MatDialogRef<AuthorDetailComponent>,
				private snackBar: MatSnackBar,
				private fb: FormBuilder,
				private authorService: AuthorService) {
		this.author = this.data.author;
		this.form = this.fb.group({
			name: [{value: "", disabled: !!this.author}, Validators.required],
			country: [{value: "", disabled: !!this.author}, Validators.required],
			birthYear: [{value: "", disabled: !!this.author}, Validators.required],
			deathYear: [{value: "", disabled: !!this.author}]
		})
		if (this.author) {
			this.form.patchValue(this.author);
		}
	}

	ngOnInit(): void {
		this.editMode = true;
		if (this.data.author) {
			this.isUpdate = true;
			this.editMode = false;
			this.authorImage = this.data.author.image;
		}
	}

	onFileSelected(event: any) {
		this.authorImage = event.target.files[0] ?? null;
		const reader: FileReader = new FileReader();

		if (this.authorImage) {
			reader.readAsDataURL(this.authorImage);
		}

		reader.onloadend = () => {
			this.authorImage = reader.result as string;
		}
	}

	save() {
		if (this.form.valid) {
			this.author = this.form.value;
			if (this.isUpdate) {
				this.author.id = this.data.author.id;
				this.author.image = this.authorImage;
				this.authorService.update(this.author).subscribe(
					(data) => {
						this.snackBar.openFromComponent(SnackbarComponent, {
							data: {
								message: 'El autor se ha actualizado correctamente',
								success: true
							},
							duration: 4000
						})
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
						})
						this.ref.close();
					}
				);
			} else {
				console.log(this.author)
				this.authorService.insert(this.author).subscribe(
					(data) => {
						this.snackBar.openFromComponent(SnackbarComponent, {
							data: {
								message: 'El autor se ha insertado correctamente',
								success: true
							},
							duration: 4000
						})
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
						})
						this.ref.close();
					}
				);
			}
		}

	}

	delete(authorId: number | undefined) {
		if (authorId){
			this.authorService.delete(authorId).subscribe();
		}
	}

	enableEdit(enable: boolean) {
		this.editMode = enable;
		this.cancelEnabled = enable;
		if (enable){
			this.form.get('name')?.enable();
			this.form.get('country')?.enable();
			this.form.get('birthYear')?.enable();
			this.form.get('deathYear')?.enable();
		} else {
			this.form.patchValue(this.author);
			this.form.get('name')?.disable();
			this.form.get('country')?.disable();
			this.form.get('birthYear')?.disable();
			this.form.get('deathYear')?.disable();
		}
	}

}
