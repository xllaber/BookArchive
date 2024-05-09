import {Component, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {BookService} from "../../../services/book.service";
import {Book} from "../book";
import {Router, RouterLink} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {MatDialog, MatDialogConfig, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {InsertFormDialogComponent} from "../insert-form-dialog/insert-form-dialog.component";

@Component({
  	selector: 'app-book-list',
  	standalone: true,
	imports: [CommonModule, RouterLink, FormsModule, MatDialogModule],
  	templateUrl: './book-list.component.html',
	styleUrl: './book-list.component.scss'
})
export class BookListComponent implements OnInit {

	books: Book[] = [];
	year: number = new Date().getFullYear();
	totals : {
		totalBooks: number,
		totalPages: number,
		totalTime: number
	} = {
		totalBooks: 0,
		totalPages: 0,
		totalTime: 0
	};
	parseInt = parseInt;

	constructor(private router: Router,
				private bookService: BookService,
				public dialog: MatDialog) {
	}

	ngOnInit(): void {
		this.bookService.findAll(this.year).subscribe(data => this.loadData(data));
	}

	loadData(data: Book[]) {
		this.books = data;
		this.books.forEach(b => {
			b.readTime = this.calculateReadTime(new Date(b.rereads[0].startDate), new Date(b.rereads[0].finishDate));
		})
		this.totals.totalBooks = this.books.length;
		this.books.forEach(b => this.totals.totalPages += b.pages);
		this.books.forEach(b => this.totals.totalTime += b.readTime);
	}

	calculateReadTime(startDate: Date, finishDate: Date) {
		let diffInMilisec = Math.abs(finishDate.getTime() - startDate.getTime());
		return Math.floor(diffInMilisec / (1000 * 3600));
	}

	changeYear(increment: boolean) {
		this.bookService.findAll(increment ? ++this.year : --this.year).subscribe(data => this.loadData(data));
	}

	yearJump(year: number) {
		this.bookService.findAll(year).subscribe(data=> this.loadData(data));
	}

	openAddForm(enterAnimationDuration: string, exitAnimationDuration: string) {
		this.dialog.open(InsertFormDialogComponent, {
			enterAnimationDuration: enterAnimationDuration,
			exitAnimationDuration: exitAnimationDuration,
			autoFocus: true
		});
	}

}
