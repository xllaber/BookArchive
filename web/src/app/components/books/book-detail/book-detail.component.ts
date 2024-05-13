import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {BookService} from "../../../services/book.service";
import {Book} from "../book";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {Author} from "../../authors/author";
import {AuthorService} from "../../../services/author.service";
import {Saga} from "../../sagas/saga";
import {SagaService} from "../../../services/saga.service";
import {MatFormField, MatInput} from "@angular/material/input";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatDialog} from "@angular/material/dialog";
import {EditDialogComponent} from "../edit-dialog/edit-dialog.component";
import {RereadComponent} from "../reread/reread.component";
import {MatSnackBar} from "@angular/material/snack-bar";
import {SnackbarComponent} from "../../../shared/snackbar/snackbar.component";

@Component({
  selector: 'app-book-detail',
  standalone: true,
	imports: [CommonModule, RouterLink, MatInput, MatFormField, MatSelect, MatOption, RereadComponent],
  templateUrl: './book-detail.component.html',
  styleUrl: './book-detail.component.scss'
})
export class BookDetailComponent implements OnInit{

	book!: Book;
	authorOptions!: Author[];
	sagaOptions!: Saga[];

	constructor(private router: Router,
				private activatedRoute: ActivatedRoute,
				private bookService: BookService,
				private authorService: AuthorService,
				private sagaService: SagaService,
				private dialog: MatDialog,
				private snackBar: MatSnackBar) {
	}

	ngOnInit(): void {
		this.bookService.findById(this.activatedRoute.snapshot.params['id'])
			.subscribe(book => this.book = book);
		this.sagaService.findAll().subscribe(data => this.sagaOptions = data);
		this.authorService.findAll().subscribe(data => this.authorOptions = data);
	}

	openEditDialog() {
		const ref = this.dialog.open(EditDialogComponent, {
			enterAnimationDuration: 100,
			exitAnimationDuration: 100,
			autoFocus: true,
			data: this.book
		});

		ref.afterClosed().subscribe(() => this.ngOnInit());
	}

	delete() {
		this.bookService.delete(this.book.id).subscribe(
			(data) => {
				this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: 'El libro se ha eliminado correctamente',
						success: true
					},
					duration: 4000
				})
			},
			(error) => {
				this.snackBar.openFromComponent(SnackbarComponent, {
					data: {
						message: `Error ${error.error.code}: ${error.error.message}`,
						success: false
					},
					duration: 4000
				})
			}
		);
		this.router.navigate(['/books']);
	}

}
