import {Component, OnInit} from '@angular/core';
import {
	MatDialogContainer,
	MatDialogContent,
	MatDialogModule,
	MatDialogTitle
} from "@angular/material/dialog";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {BookService} from "../../../services/book.service";
import {Book} from "../book";
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
		MatDatepicker
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
	rereadForm: FormGroup;
	book!: Book;
	sagaOptions!: Saga[];
	authorOptions!: Author[];
	genreOptions!: Genre[];
	coverUpload: any = null;

	constructor(private formBuilder: FormBuilder,
				private bookService: BookService,
				private sagaService: SagaService,
				private authorService: AuthorService,
				private genreService: GenreService) {
		this.form = this.formBuilder.group({
			title: ["", Validators.required],
			saga: [""],
			sagaNum: [""],
			authors: ["", Validators.required],
			publishYear: ["", Validators.required],
			pages: ["", Validators.required],
			fave: [false],
			image: [""],
			genres: ["", Validators.required],
			reread: ["", Validators.required]
		});
		this.rereadForm = this.formBuilder.group({
			startDate: ["", Validators.required],
			finishDate: ["", Validators.required],
			impressions: ["", Validators.required],
		})
	}

	ngOnInit(): void {
		this.sagaService.findAll().subscribe(data => this.sagaOptions = data);
		this.authorService.findAll().subscribe(data => this.authorOptions = data);
		this.genreService.findAll().subscribe(data => this.genreOptions = data);
	}

	onFileSelected(event: any) {
		this.coverUpload = event.target.files[0] ?? null;
		console.log(this.coverUpload);
	}

	save() {
		if(this.form.valid) {
			this.book.title = this.form.controls['title'].value;
			// this.book.saga = this.form.controls['saga'].value;
			this.book.sagaNum = this.form.controls['sagaNum'].value;
			// this.book.authors = this.form.controls['title'].value;
			this.book.publishYear = this.form.controls['publishYear'].value;
			this.book.pages = this.form.controls['pages'].value;
			this.book.fave = this.form.controls['fave'].value;
			// this.book.image = this.form.controls['image'].value;
			this.book.genre = this.form.controls['genres'].value;
			// this.book.rereads = this.form.controls['reread'].value;
			this.bookService.insert(this.book);
		}
	}

}
