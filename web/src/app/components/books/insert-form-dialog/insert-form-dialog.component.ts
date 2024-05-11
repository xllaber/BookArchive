import {Component, OnInit} from '@angular/core';
import {MatDialogContainer, MatDialogContent, MatDialogModule, MatDialogTitle} from "@angular/material/dialog";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {BookService} from "../../../services/book.service";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {Saga} from "../../sagas/saga";
import {SagaService} from "../../../services/saga.service";
import {Author} from "../../authors/author";
import {AuthorService} from "../../../services/author.service";
import {Genre} from "../../genres/genre";
import {GenreService} from "../../../services/genre.service";
import {MatCheckbox} from "@angular/material/checkbox";
import {MAT_RADIO_DEFAULT_OPTIONS, MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MAT_DATE_LOCALE} from "@angular/material/core";
import {MatSnackBar} from "@angular/material/snack-bar";
import {SnackbarComponent} from "../../../shared/snackbar/snackbar.component";

@Component({
  	selector: 'app-insert-form-dialog',
  	standalone: true,
	imports: [
		MatDialogModule,
		MatDialogTitle,
		MatDialogContent,
		MatDialogContainer,
		ReactiveFormsModule,
		MatFormField,
		MatInput,
		MatLabel,
		MatSelect,
		MatOption,
		MatCheckbox,
		MatRadioGroup,
		MatRadioButton,
		MatDatepickerInput,
		MatDatepickerToggle,
		MatSuffix,
		MatDatepicker,
		FormsModule
	],
	providers: [
		{
		  	provide: MAT_RADIO_DEFAULT_OPTIONS,
			useValue: {color: 'primary'}
		},
		{
			provide: MAT_DATE_LOCALE,
			useValue: 'es-ES'
		}
	],
  	templateUrl: './insert-form-dialog.component.html',
  	styleUrl: './insert-form-dialog.component.scss'
})
export class InsertFormDialogComponent implements OnInit{

	form: FormGroup;
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
	sagaOptions!: Saga[];
	authorOptions!: Author[];
	genreOptions!: Genre[];
	coverUpload: any = null;
	uploadRequest!: {file: File, fileName: string};
	sendForm: FormGroup;

	constructor(private formBuilder: FormBuilder,
				private bookService: BookService,
				private sagaService: SagaService,
				private authorService: AuthorService,
				private genreService: GenreService,
				private snackBar: MatSnackBar) {
		this.form = this.formBuilder.group({
			title: ["", Validators.required],
			saga: [""],
			sagaNum: [""],
			authors: ["", Validators.required],
			publishYear: ["", Validators.required],
			pages: ["", Validators.required],
			fave: [false],
			genres: ["", Validators.required],
			reread: this.formBuilder.group({
				startDate: ["", Validators.required],
				finishDate: ["", Validators.required],
				impressions: ["", Validators.required],
			})
		});
		this.sendForm = this.formBuilder.group({
			image: []
		})
	}

	ngOnInit(): void {
		this.sagaService.findAll().subscribe(data => this.sagaOptions = data);
		this.authorService.findAll().subscribe(data => this.authorOptions = data);
		this.genreService.findAll().subscribe(data => this.genreOptions = data);
	}

	onFileSelected(event: any) {
		this.coverUpload = event.target.files[0] ?? null;
		const formData: FormData = new FormData();
		if (this.coverUpload) {
			let fileName = `${this.form.controls['title'].value.replace(/\s+/g, '_')}.jpeg`;
		}
	}

	save() {
		console.log(this.form.value);
		if(this.form.valid) {
			this.book.sagaId = this.form.controls['saga'].value;
			this.book.sagaNum = this.form.controls['sagaNum'].value;
			this.book.authorIds = this.form.controls['authors'].value;
			this.book.publishYear = this.form.controls['publishYear'].value;
			this.book.pages = this.form.controls['pages'].value;
			this.book.fave = this.form.controls['fave'].value;
			this.book.genreIds = this.form.controls['genres'].value;
			this.book.rereadCreateRequest = this.form.controls['reread'].value;
			this.bookService.insert(this.book).subscribe(
				(data) => this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: 'El libro se ha insertado correctamente',
						success: true
					},
					duration: 4000
				}),
				(error) => this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: `Error ${error.error.code}: ${error.error.message}`,
						success: false
					},
					duration: 4000
				})
			);
			// this.multimediaService.upload(this.coverUpload);
			console.log(this.book);
		}
	}

	testFile: any = null;

	test(event: any) {
		this.testFile = event.target.files[0];
	}

}
