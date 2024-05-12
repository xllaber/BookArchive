import {Component, Inject, OnInit} from '@angular/core';
import {
	MAT_DIALOG_DATA,
	MatDialogActions,
	MatDialogClose,
	MatDialogContent,
	MatDialogRef
} from "@angular/material/dialog";
import {Book} from "../book";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MAT_RADIO_DEFAULT_OPTIONS, MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {SagaService} from "../../../services/saga.service";
import {AuthorService} from "../../../services/author.service";
import {GenreService} from "../../../services/genre.service";
import {BookService} from "../../../services/book.service";
import {Saga} from "../../sagas/saga";
import {Author} from "../../authors/author";
import {Genre} from "../../genres/genre";
import {MatInput} from "@angular/material/input";
import {MatSelect} from "@angular/material/select";
import {SnackbarComponent} from "../../../shared/snackbar/snackbar.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  	selector: 'app-edit-dialog',
  	standalone: true,
	imports: [
		MatDialogContent,
		FormsModule,
		MatFormField,
		MatLabel,
		MatOption,
		MatRadioButton,
		MatRadioGroup,
		ReactiveFormsModule,
		MatInput,
		MatSelect,
		MatDialogActions,
		MatDialogClose
	],
	providers: [
		{
			provide: MAT_RADIO_DEFAULT_OPTIONS,
			useValue: {color: 'primary'}
		},
	],
  	templateUrl: './edit-dialog.component.html',
  	styleUrl: './edit-dialog.component.scss'
})
export class EditDialogComponent implements OnInit{

	form: FormGroup;
	sagaOptions: Saga[] = [];
	authorOptions: Author[] = [];
	genreOptions: Genre[] = [];
	book: any = {
		title: '',
		pages: 0,
		publishYear: 0,
		fave: false,
		authors: [],
		genre: [],
		rereadCreateRequest: null,
		authorIds: [],
		genreIds: []
	};
	coverUpload: any;
	selectedAuthorsIds = this.data.authors.map(a => a.id);
	selectedGenresIds = this.data.genres.map(g => g.id);

	constructor(@Inject(MAT_DIALOG_DATA) private data: Book,
				private snackBar: MatSnackBar,
				private ref: MatDialogRef<EditDialogComponent>,
				private fb: FormBuilder,
				private sagaService: SagaService,
				private authorService: AuthorService,
				private genreService: GenreService,
				private bookService: BookService) {
		this.form = this.fb.group({
			title: [data.title, Validators.required],
			saga: [data.saga?.id],
			sagaNum: [data.sagaNum],
			authors: [this.selectedAuthorsIds, Validators.required],
			pages: [data.pages, Validators.required],
			genres: [this.selectedGenresIds, Validators.required],
			fave:[data.fave],
			publishYear: [data.publishYear, Validators.required]
		});
		this.book = this.data;
	}

	ngOnInit(): void {
		this.sagaService.findAll().subscribe(data => this.sagaOptions = data);
		this.authorService.findAll().subscribe(data => this.authorOptions = data);
		this.genreService.findAll().subscribe(data => this.genreOptions = data);
	}

	onFileSelected(event: any) {
		this.coverUpload = event.target.files[0] ?? null;
		const reader: FileReader = new FileReader();

		if (this.coverUpload) {
			reader.readAsDataURL(this.coverUpload);
		}

		reader.onloadend = () => {
			const base64String = reader.result as string;
			console.log(base64String);
			this.book.image = base64String;
		}
	}

	update() {
		if(this.form.valid) {
			this.book.id = this.data.id;
			this.book.title = this.form.controls['title'].value;
			this.book.sagaId = this.form.controls['saga'].value;
			this.book.sagaNum = this.form.controls['sagaNum'].value;
			this.book.authorIds = this.form.controls['authors'].value;
			this.book.publishYear = this.form.controls['publishYear'].value;
			this.book.pages = this.form.controls['pages'].value;
			this.book.fave = this.form.controls['fave'].value;
			this.book.genreIds = this.form.controls['genres'].value;
			this.bookService.update(this.book).subscribe(
				(data) => {
					this.snackBar.openFromComponent(SnackbarComponent, {
						data: {
							message: 'El libro se ha actualizado correctamente',
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
